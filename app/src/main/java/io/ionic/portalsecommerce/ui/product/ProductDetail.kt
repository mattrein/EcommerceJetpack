package io.ionic.portalsecommerce.ui.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.ionic.portalsecommerce.R
import io.ionic.portalsecommerce.data.DataService
import io.ionic.portalsecommerce.data.ShoppingCart
import io.ionic.portalsecommerce.ui.components.EcommerceBottomAppBar
import io.ionic.portalsecommerce.ui.components.EcommerceTopAppBar
import io.ionic.portalsecommerce.ui.theme.PortalsEcommerceTheme
import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

@Composable
fun ProductDetail(productId: Int, upPress: () -> Unit, onNavigateRoute: (String) -> Unit) {
    val context = LocalContext.current

    val product = DataService.getInstance(context).getProduct(productId)!!
    val cart = ShoppingCart.getInstance(context).getCart()!!


    val rName = product.image?.replace("-","_")?.replace(".png","")
    val drawableId = remember(rName) {
        val resId by derivedStateOf {
            context.resources.getIdentifier(
                rName,
                "drawable",
                context.packageName
            )
        }
        if (resId != 0) resId else R.drawable.not_found
    }

    val format: NumberFormat = NumberFormat.getCurrencyInstance()
    format.setMaximumFractionDigits(0)
    format.setCurrency(Currency.getInstance(Locale.US))
    Scaffold (
        topBar = { EcommerceTopAppBar(title = product.title!!, upPress, actionPress =
            {  -> onNavigateRoute("help") }) },
        bottomBar = { EcommerceBottomAppBar(currentRoute = "home/shop", onNavigateRoute) }
    ) {
        paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxHeight()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column{
                Image(
                    painter = painterResource(drawableId),
                    contentDescription = product.title,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth())
                Text(
                    text = product.title!!,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .padding(10.dp)
                )
                Text(
                    text = format.format(product.price!!),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .padding(10.dp)
                )
                Text(
                    text = product.description!!,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }

            Button(
                onClick = {
                    ShoppingCart.getInstance(context).addItem(product)
                    upPress()
                          },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .padding(bottom = 20.dp)
            ) {
                Text(text = "Add to Cart")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProductDetailPreview() {
    PortalsEcommerceTheme {
        ProductDetail(1, {}, {})
    }
}
