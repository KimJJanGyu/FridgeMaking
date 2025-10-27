package com.example.fridgeapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.ImageView
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.fridgeapp.data.Ingredient
import com.example.fridgeapp.data.IngredientRepository
import com.example.fridgeapp.data.repository.YoutubeRepository
import com.example.fridgeapp.data.youtube.YouTubeApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import java.text.SimpleDateFormat
import java.util.*

class MainImageFragment : Fragment() {

    private var isClosed = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val parentView = inflater.inflate(R.layout.fragment_main_image, container, false)
        val imageView = parentView.findViewById<ImageView>(R.id.fridgeInside)
        val btnAdd = parentView.findViewById<Button>(R.id.btnAddIngredient)

        // 🟢 한글 입력이 막히지 않도록 ComposeView 포커스 허용
        parentView.isFocusableInTouchMode = true
        parentView.requestFocus()

        val categoryButtons = mapOf(
            R.id.btnMeat to "육류",
            R.id.btnFruit to "과일",
            R.id.btnDrink to "음료",
            R.id.btnDairy to "유제품",
            R.id.btnFrozen to "냉동식품",
            R.id.btnSeafood to "해산물",
            R.id.btnVegetable to "채소",
            R.id.btnSauce to "소스류",
            R.id.btnSide to "반찬",
            R.id.btnEtc to "기타"
        )

        imageView.setImageResource(R.drawable.fridge_closed)
        categoryButtons.keys.forEach { parentView.findViewById<Button>(it).visibility = View.GONE }

        imageView.setOnClickListener {
            isClosed = !isClosed
            val nextImage = if (isClosed) R.drawable.fridge_closed else R.drawable.fridgeinside
            imageView.animate().alpha(0f).setDuration(300).withEndAction {
                imageView.setImageResource(nextImage)
                imageView.animate().alpha(1f).setDuration(300).start()
                categoryButtons.keys.forEach { id ->
                    parentView.findViewById<Button>(id).visibility =
                        if (isClosed) View.GONE else View.VISIBLE
                }
            }.start()
        }

        categoryButtons.forEach { (id, name) ->
            parentView.findViewById<Button>(id).setOnClickListener {
                showIngredientListDialog(name)
            }
        }

        btnAdd.setOnClickListener {
            showIngredientDialog()
        }

        return parentView
    }

    // ✅ 식재료 등록 / 수정 다이얼로그
    @OptIn(ExperimentalMaterial3Api::class)
    private fun showIngredientDialog(existing: Ingredient? = null) {
        val dialog = androidx.appcompat.app.AlertDialog.Builder(requireContext()).create()
        val composeView = ComposeView(requireContext())
        composeView.isFocusableInTouchMode = true

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

                val categoryList = listOf("육류", "해산물", "과일", "채소", "음료", "유제품", "냉동식품", "소스류", "반찬", "기타")
                val datePickerState = rememberDatePickerState()

                // ✅ DatePicker는 Composition 외부에서 렌더링
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
                    ) {
                        DatePicker(state = datePickerState)
                    }
                }

                Surface(modifier = Modifier.fillMaxWidth(), tonalElevation = 8.dp) {
                    Column(Modifier.padding(20.dp)) {
                        Text(if (existing == null) "식재료 등록" else "식재료 수정", style = MaterialTheme.typography.titleLarge)
                        Spacer(Modifier.height(16.dp))

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
                                        category = it; expanded = false
                                    })
                                }
                            }
                        }

                        Spacer(Modifier.height(12.dp))
                        OutlinedTextField(
                            value = name,
                            onValueChange = { name = it },
                            label = { Text("식재료 이름") },
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true
                        )

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
                            Text(
                                "⚠ 숫자만 입력 가능합니다.",
                                color = MaterialTheme.colorScheme.error,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }

                        Spacer(Modifier.height(12.dp))
                        OutlinedTextField(
                            value = expiry,
                            onValueChange = {},
                            label = { Text("유통기한 (선택)") },
                            readOnly = true,
                            modifier = Modifier.fillMaxWidth().clickable { showDatePicker = true }
                        )

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
                            modifier = Modifier.fillMaxWidth(),
                            enabled = name.isNotBlank() && category.isNotBlank() && !quantityError
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

    // ✅ 식재료 목록 다이얼로그 (삭제 기능 복원)
    private fun showIngredientListDialog(category: String) {
        val dialog = androidx.appcompat.app.AlertDialog.Builder(requireContext()).create()
        val composeView = ComposeView(requireContext())
        composeView.isFocusableInTouchMode = true

        composeView.setContent {
            val ingredients by remember {
                derivedStateOf { IngredientRepository.getIngredientsByCategory(category) }
            }

            MaterialTheme {
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
                                        .clickable { showIngredientDetailDialog(item) },
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                                ) {
                                    Column(Modifier.padding(12.dp)) {
                                        Text(item.name, style = MaterialTheme.typography.bodyLarge)
                                        Text("수량: ${item.quantity}")
                                        item.expiry?.let { Text("유통기한: $it") }

                                        Spacer(Modifier.height(6.dp))
                                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                            Button(onClick = { showIngredientDialog(item) }, modifier = Modifier.weight(1f)) {
                                                Text("수정")
                                            }
                                            OutlinedButton(
                                                onClick = {
                                                    IngredientRepository.removeIngredient(item)
                                                    dialog.dismiss()
                                                    showIngredientListDialog(category)
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
                    }
                }
            }
        }

        dialog.setView(composeView)
        dialog.show()
    }

    // ✅ 상세 + 유튜브 검색
    private fun showIngredientDetailDialog(ingredient: Ingredient) {
        val dialog = androidx.appcompat.app.AlertDialog.Builder(requireContext()).create()
        val composeView = ComposeView(requireContext())

        composeView.setContent {
            MaterialTheme {
                val context = LocalContext.current
                var videos by remember { mutableStateOf<List<String>>(emptyList()) }
                var isLoading by remember { mutableStateOf(true) }
                val coroutineScope = rememberCoroutineScope()

                LaunchedEffect(Unit) {
                    coroutineScope.launch {
                        try {
                            val retrofit = Retrofit.Builder()
                                .baseUrl("https://www.googleapis.com/youtube/v3/")
                                .addConverterFactory(
                                    Json { ignoreUnknownKeys = true }.asConverterFactory("application/json".toMediaType())
                                )
                                .build()
                            val api = retrofit.create(YouTubeApi::class.java)
                            val repo = YoutubeRepository(api)
                            videos = withContext(Dispatchers.IO) {
                                repo.searchRecipeVideos("${ingredient.name} 레시피")
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        } finally {
                            isLoading = false
                        }
                    }
                }

                Surface(modifier = Modifier.fillMaxWidth(), tonalElevation = 8.dp) {
                    Column(Modifier.padding(20.dp)) {
                        Text("${ingredient.name} 상세 정보", style = MaterialTheme.typography.titleLarge)
                        Text("카테고리: ${ingredient.category}")
                        Text("수량: ${ingredient.quantity}")
                        ingredient.expiry?.let { Text("유통기한: $it") }
                        ingredient.detail?.let { Text("상세: $it") }

                        Spacer(Modifier.height(12.dp))
                        Text("관련 레시피 영상", style = MaterialTheme.typography.titleMedium)
                        if (isLoading) CircularProgressIndicator(Modifier.padding(8.dp))
                        else if (videos.isEmpty()) Text("관련 영상을 찾을 수 없습니다.")
                        else videos.forEach { id ->
                            TextButton(onClick = {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=$id"))
                                context.startActivity(intent)
                            }) { Text("▶ https://youtu.be/$id") }
                        }

                        Spacer(Modifier.height(8.dp))
                        TextButton(onClick = { dialog.dismiss() }) { Text("닫기") }
                    }
                }
            }
        }

        dialog.setView(composeView)
        dialog.show()
    }
}
