package io.ionic.portalsecommerce.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

object MainDestinations {
    const val HOME_ROUTE = "home"
    const val PRODUCT_DETAIL_ROUTE = "product"
    const val PRODUCT_ID_KEY = "productId"
    const val HELP_ROUTE = "help"
    const val ADDRESS_ROUTE = "address"
    const val ADDRESS_ID_KEY = "addressId"
    const val PAYMENT_ROUTE = "payment"
    const val PAYMENT_ID_KEY = "paymentId"
}

@Composable
fun rememberEcommerceNavController(
    navController: NavHostController = rememberNavController()
) : EcommerceNavController = remember(navController) {
    EcommerceNavController(navController)
}

@Stable
class EcommerceNavController(
    val navController: NavHostController,
) {

    fun onNavigateRoute(route: String) {
        navController.navigate(route)
    }

    fun upPress() {
        navController.navigateUp()
    }

    fun navigateToProductDetail(productId: Int, from: NavBackStackEntry) {
        // In order to discard duplicated navigation events, we check the Lifecycle
        if (from.lifecycleIsResumed()) {
            navController.navigate("${MainDestinations.PRODUCT_DETAIL_ROUTE}/$productId")
        }
    }
    fun navigateToAddressDetail(addressId: Int, from: NavBackStackEntry) {
        // In order to discard duplicated navigation events, we check the Lifecycle
        if (from.lifecycleIsResumed()) {
            navController.navigate("${MainDestinations.ADDRESS_ROUTE}/$addressId")
        }
    }

    private fun NavBackStackEntry.lifecycleIsResumed() =
        this.lifecycle.currentState == Lifecycle.State.RESUMED
}