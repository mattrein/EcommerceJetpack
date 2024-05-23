package io.ionic.portalsecommerce.ui.product

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.ionic.portalsecommerce.ui.components.EcommerceBottomAppBar
import io.ionic.portalsecommerce.ui.components.EcommerceTopAppBar
import io.ionic.portalsecommerce.ui.shop.ProductList
import io.ionic.portalsecommerce.ui.theme.PortalsEcommerceTheme

@Composable
fun ProductDetail(snackId: Long, upPress: () -> Unit, onNavigateRoute: (String) -> Unit) {
    Scaffold (
        topBar = { EcommerceTopAppBar(title = "Product Name", upPress, actionPress =
            {  -> onNavigateRoute("help") }) },
    ) {
        paddingValues ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {
            Text(text = "Image")
            Text(text = "Product Name")
            Text(text = "Product Description Product Description Product Description Product Description Product Description Product Description Product Description Product Description ")
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Add to Cart")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProductDetailPreview() {
    PortalsEcommerceTheme {
        ProductDetail(0, {}, {})
    }
}
