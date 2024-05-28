package io.ionic.portalsecommerce

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.annotations.Until
import io.ionic.portalsecommerce.data.ShoppingCart
import io.ionic.portalsecommerce.data.model.Address
import io.ionic.portalsecommerce.ui.address.AddressScreen
import io.ionic.portalsecommerce.ui.cart.Cart
import io.ionic.portalsecommerce.ui.help.Help
import io.ionic.portalsecommerce.ui.home.HomeSections
import io.ionic.portalsecommerce.ui.home.addHomeGraph
import io.ionic.portalsecommerce.ui.navigation.MainDestinations
import io.ionic.portalsecommerce.ui.navigation.rememberEcommerceNavController
import io.ionic.portalsecommerce.ui.payment.PaymentScreen
import io.ionic.portalsecommerce.ui.payment.PaymentScreenPreview
import io.ionic.portalsecommerce.ui.product.ProductDetail
import io.ionic.portalsecommerce.ui.theme.PortalsEcommerceTheme

@Composable
fun PortalsEcommerceApp() {

    PortalsEcommerceTheme {
        val ecommerceNavController = rememberEcommerceNavController()
        NavHost(
            navController = ecommerceNavController.navController,
            startDestination = MainDestinations.HOME_ROUTE
        ) {
            ecommerceNavGraph(
                onNavigateRoute = ecommerceNavController::onNavigateRoute,
                onProductClick = ecommerceNavController::navigateToProductDetail,
                upPress = ecommerceNavController::upPress
            )
        }
    }
}

private fun NavGraphBuilder.ecommerceNavGraph(
    onNavigateRoute: (String) -> Unit,
    onProductClick: (Int, NavBackStackEntry) -> Unit,
    upPress: () -> Unit
) {
    navigation(
        route = MainDestinations.HOME_ROUTE,
        startDestination = HomeSections.SHOP.route
    ) {
        addHomeGraph(onNavigateRoute, onProductClick, upPress)
    }
    composable(
        "${MainDestinations.PRODUCT_DETAIL_ROUTE}/{${MainDestinations.PRODUCT_ID_KEY}}",
        arguments = listOf(navArgument(MainDestinations.PRODUCT_ID_KEY) { type = NavType.IntType })
    ) { backStackEntry ->
        val arguments = requireNotNull(backStackEntry.arguments)
        val productId = arguments.getInt(MainDestinations.PRODUCT_ID_KEY)
        ProductDetail(productId, upPress, onNavigateRoute)
    }
    composable(
        "${MainDestinations.ADDRESS_ROUTE}/{${MainDestinations.ADDRESS_ID_KEY}}",
        arguments = listOf(navArgument(MainDestinations.ADDRESS_ID_KEY) { type = NavType.IntType })
    ) { backStackEntry ->
        val arguments = requireNotNull(backStackEntry.arguments)
        val addressId = arguments.getInt(MainDestinations.ADDRESS_ID_KEY)
        AddressScreen(addressId, onNavigateRoute, upPress)
    }
    composable(
        "${MainDestinations.PAYMENT_ROUTE}/{${MainDestinations.PAYMENT_ID_KEY}}",
        arguments = listOf(navArgument(MainDestinations.PAYMENT_ID_KEY) { type = NavType.IntType })
    ) { backStackEntry ->
        val arguments = requireNotNull(backStackEntry.arguments)
        val paymentId = arguments.getInt(MainDestinations.PAYMENT_ID_KEY)
        PaymentScreen(paymentId, onNavigateRoute, upPress)
    }
    composable(MainDestinations.HELP_ROUTE) { from ->
        Help(upPress)
    }
}


