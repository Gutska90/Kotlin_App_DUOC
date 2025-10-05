package com.example.mykotlinappduoc

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.mykotlinappduoc.ui.screens.LoginScreen
import com.example.mykotlinappduoc.viewmodel.RecipeViewModel
import org.junit.Rule
import org.junit.Test

class LoginScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun loginButton_enablesWhenFieldsFilled() {
        composeTestRule.setContent {
            LoginScreen(
                onLoginSuccess = {},
                onNavigateToRegister = {},
                onNavigateToForgotPassword = {},
                viewModel = RecipeViewModel()
            )
        }

        composeTestRule.onNodeWithText("Usuario o Email").performTextInput("user@test.com")
        composeTestRule.onNodeWithText("Contraseña").performTextInput("123456")
        composeTestRule.onNodeWithText("Iniciar Sesión").performClick()
    }
}


