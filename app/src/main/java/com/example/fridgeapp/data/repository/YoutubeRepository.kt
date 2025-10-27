package com.example.fridgeapp.data.repository

import com.example.fridgeapp.BuildConfig
import com.example.fridgeapp.data.youtube.YouTubeApi


class YoutubeRepository (
    private val api: YouTubeApi
) {
    suspend fun searchRecipeVideos(query: String, max: Int = 5): List<String> {
        val res = api.search(q = query, max = max, key = BuildConfig.YOUTUBE_API_KEY)
        return res.items.mapNotNull { it.id?.videoId }
    }
}
