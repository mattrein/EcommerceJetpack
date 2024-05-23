package io.ionic.portalsecommerce.ui.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.ionic.portalsecommerce.data.model.Product
import io.ionic.portalsecommerce.ui.components.EcommerceBottomAppBar
import io.ionic.portalsecommerce.ui.components.EcommerceTopAppBar
import io.ionic.portalsecommerce.ui.components.ProductTile
import io.ionic.portalsecommerce.ui.navigation.MainDestinations
import io.ionic.portalsecommerce.ui.theme.PortalsEcommerceTheme

@Composable
fun Cart(onNavigateRoute: (String) -> Unit) {
    Scaffold (
        topBar = { EcommerceTopAppBar(title = "Checkout") },
        bottomBar = { EcommerceBottomAppBar("home/cart", onNavigateRoute) }
    ) {
            paddingValues ->
        Column (
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "Your cart is empty",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(20.dp)
                )
                Button(
                    onClick = { onNavigateRoute(MainDestinations.HOME_ROUTE) },
                ) {
                    Text( text = "Go Shop!" )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartPreview() {
    PortalsEcommerceTheme {
        Cart({})
    }
}