package io.ionic.portalsecommerce.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import io.ionic.portalsecommerce.ui.theme.PortalsEcommerceTheme

@Composable
fun EcommerceBottomAppBar(currentRoute: String, onNavigateRoute: (String) -> Unit) {

    fun onClick (route: String){
        onNavigateRoute(route)
    }
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Shop") },
//            label = { Text("Shop") },
            selected = "home/shop" == currentRoute,
            onClick = {
                onNavigateRoute("home/shop")
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.ShoppingCart, contentDescription = "Cart") },
//            label = { Text("Cart") },
            selected = "home/cart" == currentRoute,
            onClick = {
                onNavigateRoute("home/cart")
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.AccountCircle, contentDescription = "Profile") },
//            label = { Text("Profile") },
            selected = "home/profile" == currentRoute,
            onClick = {
                onNavigateRoute("home/profile")
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EcommerceBottomAppBarPreview() {
    PortalsEcommerceTheme {
        EcommerceBottomAppBar("home/shop", {})
    }
}