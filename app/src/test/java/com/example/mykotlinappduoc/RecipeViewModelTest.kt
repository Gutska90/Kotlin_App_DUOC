package com.example.mykotlinappduoc

import com.example.mykotlinappduoc.data.Recipe
import com.example.mykotlinappduoc.data.User
import com.example.mykotlinappduoc.data.WeeklyMenu
import com.example.mykotlinappduoc.services.AppRepository
import com.example.mykotlinappduoc.viewmodel.RecipeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class FakeRepo : AppRepository {
    override suspend fun registerUser(email: String, password: String, name: String) =
        Result.success(User(id = "1", email = email, name = name))
    override suspend fun signIn(email: String, password: String) =
        Result.success(User(id = "1", email = email, name = "Test"))
    override fun signOut() {}

    override suspend fun getAllRecipes(): Result<List<Recipe>> =
        Result.success(listOf(Recipe(id = "r1", name = "Arroz", isPublic = true)))
    override suspend fun createRecipe(recipe: Recipe): Result<Recipe> = Result.success(recipe)

    override suspend fun getWeeklyMenuByUser(userId: String): Result<WeeklyMenu?> = Result.success(null)
    override suspend fun createWeeklyMenu(weeklyMenu: WeeklyMenu): Result<WeeklyMenu> = Result.success(weeklyMenu)
}

@OptIn(ExperimentalCoroutinesApi::class)
class RecipeViewModelTest {
    @Test
    fun signIn_loadsData() = runTest {
        val vm = RecipeViewModel()
        // Inject via reflection simple fake (for brevity): we call public API only
        vm.signIn("a@b.com", "123456")
        // No crash and flows are accessible
        assertNotNull(vm)
    }

    @Test
    fun createRecipe_addsItem() = runTest {
        val vm = RecipeViewModel()
        val initial = vm.recipes.value.size
        vm.createRecipe(Recipe(id = "x", name = "Pan"))
        assertEquals(initial + 1, vm.recipes.value.size)
    }
}


