package com.example.fridgeapp.data

object IngredientRepository {
    private val ingredientList = mutableListOf<Ingredient>()

    fun addIngredient(item: Ingredient) {
        ingredientList.add(item)
    }

    fun getIngredientsByCategory(category: String): List<Ingredient> {
        return ingredientList.filter { it.category == category }
    }

    // ✅ 삭제 함수 추가
    fun removeIngredient(item: Ingredient) {
        ingredientList.remove(item)
    }

    // ✅ 전체 목록 반환 (옵션)
    fun getAll(): List<Ingredient> = ingredientList
}