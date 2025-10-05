package com.example.mykotlinappduoc.services

import com.example.mykotlinappduoc.data.Recipe
import com.example.mykotlinappduoc.data.User
import com.example.mykotlinappduoc.data.WeeklyMenu

interface AppRepository {
    suspend fun registerUser(email: String, password: String, name: String): Result<User>
    suspend fun signIn(email: String, password: String): Result<User>
    fun signOut()

    suspend fun getAllRecipes(): Result<List<Recipe>>
    suspend fun createRecipe(recipe: Recipe): Result<Recipe>

    suspend fun getWeeklyMenuByUser(userId: String): Result<WeeklyMenu?>
    suspend fun createWeeklyMenu(weeklyMenu: WeeklyMenu): Result<WeeklyMenu>
}


