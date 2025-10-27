package com.example.fridgeapp.data.youtube

import com.example.fridgeapp.BuildConfig
import kotlinx.serialization.Serializable
import retrofit2.http.GET
import retrofit2.http.Query

@Serializable data class YtId(val videoId: String? = null)
@Serializable data class YtItem(val id: YtId)
@Serializable data class YtSearchResponse(val items: List<YtItem> = emptyList())

interface YouTubeApi {
    @GET("search")
    suspend fun search(
        @Query("key") key: String = BuildConfig.YOUTUBE_API_KEY,
        @Query("part") part: String = "snippet",
        @Query("q") q: String,
        @Query("type") type: String = "video",
        @Query("maxResults") max: Int = 5
    ): YtSearchResponse
}
