@file:OptIn(ExperimentalComposeUiApi::class)

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import fr.mcgalanes.groomr.core.compose.theme.AppTheme
import fr.mcgalanes.groomr.feature.createuserstory.presentation.CreateUserStoryScreen

@ExperimentalComposeUiApi
@Composable
@Preview
fun App() {
    AppTheme(useDarkTheme = false) {
        CreateUserStoryScreen()
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
