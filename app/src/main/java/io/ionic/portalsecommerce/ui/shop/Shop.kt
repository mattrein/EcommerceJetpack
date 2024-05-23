package io.ionic.portalsecommerce.ui.shop

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.ionic.portalsecommerce.ui.components.EcommerceBottomAppBar
import io.ionic.portalsecommerce.ui.components.EcommerceTopAppBar

@Composable
fun Shop(onNavigateRoute: (String) -> Unit, onProductClick: (Int) -> Unit) {
    Scaffold (
        topBar = { EcommerceTopAppBar(title = "Shop") },
        bottomBar = { EcommerceBottomAppBar("home/shop", onNavigateRoute) }
    ) {
        paddingValues ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ){
            Text(
                text = "Must Haves, Bestsellers & More",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(10.dp)
            )
            Box(modifier = Modifier.padding(10.dp)) {
                FeaturedProducts(onProductClick)
            }
            Text(
                text = "Products",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(10.dp)
            )
            Box(modifier = Modifier.padding(10.dp)){
                ProductList(onProductClick)
            }
        }
    }
}