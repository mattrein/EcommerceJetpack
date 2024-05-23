package io.ionic.portalsecommerce.ui.shop

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.ionic.portalsecommerce.R
import io.ionic.portalsecommerce.data.DataService
import io.ionic.portalsecommerce.data.model.Product
import io.ionic.portalsecommerce.ui.components.ProductTile
import io.ionic.portalsecommerce.ui.theme.PortalsEcommerceTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeaturedProducts(onProductClick: (Int) -> Unit) {

    val products = DataService.getInstance(LocalContext.current).getProducts().filter { it.category == "MustHaves" }

    val pagerState = rememberPagerState(pageCount = { products.size })
    HorizontalPager(
        state = pagerState,
        pageSize = PageSize.Fixed(200.dp),
        pageSpacing = 10.dp

    ) { page ->
        val product = products[page]
        ProductTile(product, onProductClick)
    }
}

@Preview(showBackground = true)
@Composable
fun FeaturedProductsPreview() {
    PortalsEcommerceTheme {
        FeaturedProducts({})
    }
}