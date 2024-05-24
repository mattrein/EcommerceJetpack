package io.ionic.portalsecommerce.ui.home

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.ionic.portalsecommerce.R
import io.ionic.portalsecommerce.ui.cart.Cart
import io.ionic.portalsecommerce.ui.profile.ProfileScreen
import io.ionic.portalsecommerce.ui.shop.Shop

enum class HomeSections(
    @StringRes val title: Int,
    val icon: ImageVector,
    val route: String
) {
    SHOP(R.string.home_shop, Icons.Outlined.Home, "home/shop"),
    CART(R.string.home_cart, Icons.Outlined.ShoppingCart, "home/cart"),
    PROFILE(R.string.home_profile, Icons.Outlined.AccountCircle, "home/profile"),
}

fun NavGraphBuilder.addHomeGraph(
    onNavigateRoute: (String) -> Unit,
    onProductClick: (Int, NavBackStackEntry) -> Unit,
    upPress: () -> Unit
) {
    composable(HomeSections.SHOP.route) { from ->
        Shop(onNavigateRoute, onProductClick = {id -> onProductClick(id, from)})
    }
    composable(HomeSections.CART.route) { from ->
        Cart(onNavigateRoute)
    }
    composable(HomeSections.PROFILE.route) { from ->
        ProfileScreen(onNavigateRoute)
    }
}
