package io.ionic.portalsecommerce.ui.cart

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.ionic.portalsecommerce.ui.components.EcommerceBottomAppBar
import io.ionic.portalsecommerce.ui.components.EcommerceTopAppBar

@Composable
fun Cart(onNavigateRoute: (String) -> Unit) {
    Scaffold (
        topBar = { EcommerceTopAppBar(title = "Checkout") },
        bottomBar = { EcommerceBottomAppBar("home/cart", onNavigateRoute) }
    ) {
            paddingValues ->
        Text(text = "Cart", Modifier.padding(paddingValues))
        Row {

        }
    }
}