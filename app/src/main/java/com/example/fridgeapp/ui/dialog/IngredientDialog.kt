package com.example.fridgeapp.ui.dialog

import android.content.Context
import androidx.appcompat.app.AlertDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import com.example.fridgeapp.data.Ingredient
import com.example.fridgeapp.data.IngredientRepository
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
fun showIngredientDialog(context: Context, existing: Ingredient? = null) {
    val dialog = AlertDialog.Builder(context).create()
    val composeView = ComposeView(context)

    composeView.setContent {
        MaterialTheme {
            var name by remember { mutableStateOf(existing?.name ?: "") }
            var quantity by remember { mutableStateOf(existing?.quantity ?: "") }
            var expiry by remember { mutableStateOf(existing?.expiry ?: "") }
            var detail by remember { mutableStateOf(existing?.detail ?: "") }
            var category by remember { mutableStateOf(existing?.category ?: "") }
            var showDatePicker by remember { mutableStateOf(false) }
            var expanded by remember { mutableStateOf(false) }
            var quantityError by remember { mutableStateOf(false) }

            // ✅ 자동완성 관련 변수
            var isEditMode by remember { mutableStateOf(existing != null) }
            val allIngredients = remember { IngredientRepository.getAll() }
            val suggestions = remember(name, isEditMode) {
                if (name.isNotBlank() && !isEditMode)
                    allIngredients.filter { it.name.contains(name, ignoreCase = true) }.map { it.name }
                else emptyList()
            }

            val categoryList = listOf("육류", "해산물", "과일", "채소", "음료", "유제품", "냉동식품", "소스류", "반찬", "기타")
            val datePickerState = rememberDatePickerState()

            if (showDatePicker) {
                DatePickerDialog(
                    onDismissRequest = { showDatePicker = false },
                    confirmButton = {
                        TextButton(onClick = {
                            datePickerState.selectedDateMillis?.let {
                                expiry = SimpleDateFormat("yyyy.MM.dd", Locale.getDefault()).format(Date(it))
                            }
                            showDatePicker = false
                        }) { Text("확인") }
                    },
                    dismissButton = {
                        TextButton(onClick = { showDatePicker = false }) { Text("취소") }
                    }
                ) { DatePicker(state = datePickerState) }
            }

            Surface(modifier = Modifier.fillMaxWidth(), tonalElevation = 8.dp) {
                Column(Modifier.padding(20.dp)) {
                    Text(if (existing == null) "식재료 등록" else "식재료 수정", style = MaterialTheme.typography.titleLarge)
                    Spacer(Modifier.height(16.dp))

                    // ✅ 카테고리
                    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded }) {
                        OutlinedTextField(
                            value = category,
                            onValueChange = {},
                            label = { Text("카테고리") },
                            readOnly = true,
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
                            modifier = Modifier.menuAnchor().fillMaxWidth()
                        )
                        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                            categoryList.forEach {
                                DropdownMenuItem(text = { Text(it) }, onClick = {
                                    category = it
                                    expanded = false
                                })
                            }
                        }
                    }

                    Spacer(Modifier.height(12.dp))

                    // ✅ 자동완성
                    OutlinedTextField(
                        value = name,
                        onValueChange = {
                            name = it
                            isEditMode = false
                        },
                        label = { Text("재료 이름") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    if (suggestions.isNotEmpty()) {
                        Card(modifier = Modifier.fillMaxWidth().padding(top = 4.dp)) {
                            Column(Modifier.padding(4.dp)) {
                                suggestions.take(6).forEach { suggestion ->
                                    Text(
                                        text = suggestion,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clickable {
                                                name = suggestion
                                                isEditMode = true
                                            }
                                            .padding(8.dp)
                                    )
                                    Divider()
                                }
                            }
                        }
                    }

                    Spacer(Modifier.height(12.dp))
                    OutlinedTextField(
                        value = quantity,
                        onValueChange = {
                            quantity = it
                            quantityError = it.isNotEmpty() && it.toIntOrNull() == null
                        },
                        label = { Text("수량") },
                        isError = quantityError,
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    if (quantityError) {
                        Text("⚠ 숫자만 입력 가능합니다.", color = MaterialTheme.colorScheme.error)
                    }

                    Spacer(Modifier.height(12.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) { showDatePicker = true }
                    ) {
                        OutlinedTextField(
                            value = expiry,
                            onValueChange = {},
                            label = { Text("유통기한 (선택)") },
                            readOnly = true,
                            enabled = false,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    Spacer(Modifier.height(12.dp))
                    OutlinedTextField(
                        value = detail,
                        onValueChange = { detail = it },
                        label = { Text("상세") },
                        modifier = Modifier.fillMaxWidth(),
                        maxLines = 3
                    )

                    Spacer(Modifier.height(20.dp))
                    Button(
                        onClick = {
                            if (quantityError) return@Button
                            if (name.isBlank() || category.isBlank()) return@Button
                            val ingredient = Ingredient(name, quantity, expiry, detail, category)
                            if (existing == null) IngredientRepository.addIngredient(ingredient)
                            dialog.dismiss()
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) { Text(if (existing == null) "등록" else "수정 완료") }

                    Spacer(Modifier.height(8.dp))
                    TextButton(onClick = { dialog.dismiss() }) { Text("닫기") }
                }
            }
        }
    }

    dialog.setView(composeView)
    dialog.show()
}
