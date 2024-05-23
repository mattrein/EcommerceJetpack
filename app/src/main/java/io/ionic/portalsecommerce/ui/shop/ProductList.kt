package io.ionic.portalsecommerce.ui.shop

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.ionic.portalsecommerce.R
import io.ionic.portalsecommerce.data.DataService
import io.ionic.portalsecommerce.ui.components.ProductTile
import io.ionic.portalsecommerce.ui.theme.PortalsEcommerceTheme
import kotlin.math.ceil

@Composable
fun ProductList(onProductClick: (Int) -> Unit) {

    val products = DataService.getInstance(LocalContext.current).getProducts()?.filter { it.category != "MustHaves" }!!

    var height = ceil(products.count() / 2.0) * 225

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        userScrollEnabled = false,
        modifier = Modifier.height(height.dp)
    ) {
        items(products) { product ->
            ProductTile(product, onProductClick)
        }
    }
}




@Preview(showBackground = true)
@Composable
fun ProductListPreview() {
    PortalsEcommerceTheme {
        ProductList({})
    }
}