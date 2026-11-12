package com.example.wallet2

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wallet.ui.screens.EditorScreen
import com.example.wallet.ui.screens.MapScreen
import com.example.wallet.ui.screens.SettingsScreen
import com.example.wallet.ui.screens.WalletScreen


@Composable
fun WalletApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.MAIN) {
        composable(Routes.MAIN) {
            WalletScreen(
                onItemClick = { navController.navigate(Routes.EDITOR) },
                onAddClick = { navController.navigate(Routes.EDITOR) },
                onMapClick = { navController.navigate(Routes.MAP) },
                onSettingsClick = { navController.navigate(Routes.SETTINGS) }
            )
        }
        composable(Routes.EDITOR) {
            EditorScreen(
                onBack = { navController.popBackStack() },
                onSave = { navController.popBackStack() }
            )
        }
        composable(Routes.MAP) {
            MapScreen(onBack = { navController.popBackStack() })
        }
        composable(Routes.SETTINGS) {
            SettingsScreen(onBack = { navController.popBackStack() })
        }
    }
}
