package com.example.fridgeapp.ui.dialog

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AlertDialog
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.fridgeapp.data.Ingredient
import com.example.fridgeapp.data.repository.YoutubeRepository
import com.example.fridgeapp.data.youtube.YouTubeApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


fun Fragment.showIngredientDetailDialog(ingredient: Ingredient) {
    val dialog = AlertDialog.Builder(requireContext()).create()
    val composeView = ComposeView(requireContext())

    composeView.setContent {
        MaterialTheme {
            val context = LocalContext.current
            var videos by remember { mutableStateOf<List<String>>(emptyList()) }
            var isLoading by remember { mutableStateOf(true) }
            val coroutineScope = rememberCoroutineScope()

            // ✅ 유튜브 검색 비동기 처리
            LaunchedEffect(Unit) {
                coroutineScope.launch {
                    try {
                        val retrofit = Retrofit.Builder()
                            .baseUrl("https://www.googleapis.com/youtube/v3/")
                            .addConverterFactory(
                                Json { ignoreUnknownKeys = true }
                                    .asConverterFactory("application/json".toMediaType())
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

                    if (isLoading) {
                        CircularProgressIndicator(Modifier.padding(8.dp))
                    } else if (videos.isEmpty()) {
                        Text("관련 영상을 찾을 수 없습니다.")
                    } else {
                        videos.forEach { id ->
                            TextButton(
                                onClick = {
                                    val intent = Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse("https://www.youtube.com/watch?v=$id")
                                    )
                                    context.startActivity(intent)
                                }
                            ) {
                                Text("▶ https://youtu.be/$id")
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
