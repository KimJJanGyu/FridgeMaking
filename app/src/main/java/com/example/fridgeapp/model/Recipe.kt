package com.example.fridgeapp.model

data class Nutrition(
    val title: String? = null,
    val calories: Double? = null,
    val protein: Double? = null,
    val fat: Double? = null,
    val carbs: Double? = null,
    val categories: String? = null,
    val group: String? = null
) {
    // 보조 생성자: Int/Long/Float/Double 모두 허용
    constructor(
        title: String? = null,
        calories: Number? = null,
        protein: Number? = null,
        fat: Number? = null,
        carbs: Number? = null,
        categories: String? = null,
        group: String? = null
    ) : this(
        title = title,
        calories = calories?.toDouble(),
        protein  = protein ?.toDouble(),
        fat      = fat     ?.toDouble(),
        carbs    = carbs   ?.toDouble(),
        categories = categories,
        group = group
    )
}

data class Recipe(
    val title: String,
    val ingredients: List<String>,
    val steps: List<String>,
    val nutrition: Nutrition? = null
)
