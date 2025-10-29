package com.example.fridgeapp.ui.dialog

import androidx.appcompat.app.AlertDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.fridgeapp.data.Ingredient
import com.example.fridgeapp.data.IngredientRepository


fun showIngredientListDialog(fragment: Fragment, category: String) {
    val context = fragment.requireContext()
    val dialog = AlertDialog.Builder(context).create()
    val composeView = ComposeView(context)
    composeView.isFocusableInTouchMode = true

    composeView.setContent {
        MaterialTheme {
            val ingredients by remember {
                derivedStateOf { IngredientRepository.getIngredientsByCategory(category) }
            }

            var showConfirmDialog by remember { mutableStateOf(false) }
            var confirmType by remember { mutableStateOf("") } // "edit" or "delete"
            var selectedIngredient by remember { mutableStateOf<Ingredient?>(null) }

            Surface(modifier = Modifier.fillMaxWidth(), tonalElevation = 6.dp) {
                Column(Modifier.padding(20.dp)) {
                    Text("$category 목록", style = MaterialTheme.typography.titleLarge)
                    Spacer(Modifier.height(10.dp))

                    if (ingredients.isEmpty()) {
                        Text("등록된 식재료가 없습니다.")
                    } else {
                        ingredients.forEach { item ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 6.dp)
                                    .clickable {
                                        fragment.showIngredientDetailDialog(item) // ✅ 상세보기 다이얼로그 호출
                                    },
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                                )
                            ) {
                                Column(Modifier.padding(12.dp)) {
                                    Text(item.name, style = MaterialTheme.typography.bodyLarge)
                                    Text("수량: ${item.quantity}")
                                    item.expiry?.let { Text("유통기한: $it") }

                                    Spacer(Modifier.height(6.dp))
                                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                        Button(
                                            onClick = {
                                                selectedIngredient = item
                                                confirmType = "edit"
                                                showConfirmDialog = true
                                            },
                                            modifier = Modifier.weight(1f)
                                        ) { Text("수정") }

                                        OutlinedButton(
                                            onClick = {
                                                selectedIngredient = item
                                                confirmType = "delete"
                                                showConfirmDialog = true
                                            },
                                            modifier = Modifier.weight(1f),
                                            colors = ButtonDefaults.outlinedButtonColors(
                                                contentColor = MaterialTheme.colorScheme.error
                                            )
                                        ) { Text("삭제") }
                                    }
                                }
                            }
                        }
                    }

                    Spacer(Modifier.height(8.dp))
                    TextButton(onClick = { dialog.dismiss() }) { Text("닫기") }

                    // ✅ 수정 / 삭제 확인 다이얼로그
                    if (showConfirmDialog && selectedIngredient != null) {
                        val ing = selectedIngredient!!
                        val titleText = if (confirmType == "edit") "수정하시겠습니까?" else "삭제하시겠습니까?"
                        val bodyText = if (confirmType == "edit")
                            "${ing.name} 정보를 수정하시겠습니까?"
                        else
                            "${ing.name} 정보를 삭제합니다."

                        AlertDialog(
                            onDismissRequest = { showConfirmDialog = false },
                            title = { Text(titleText) },
                            text = { Text(bodyText) },
                            confirmButton = {
                                TextButton(onClick = {
                                    if (confirmType == "edit") {
                                        showConfirmDialog = false
                                        dialog.dismiss()
                                        showIngredientDialog(context, ing)
                                    } else {
                                        IngredientRepository.removeIngredient(ing)
                                        showConfirmDialog = false
                                        dialog.dismiss()
                                        showIngredientListDialog(fragment, category)
                                    }
                                }) { Text("예") }
                            },
                            dismissButton = {
                                TextButton(onClick = { showConfirmDialog = false }) { Text("아니오") }
                            }
                        )
                    }
                }
            }
        }
    }

    dialog.setView(composeView)
    dialog.show()
}
