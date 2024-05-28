package io.ionic.portalsecommerce.ui.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.ionic.portalsecommerce.data.ShoppingCart
import io.ionic.portalsecommerce.data.model.Product
import io.ionic.portalsecommerce.ui.address.AddressListItem
import io.ionic.portalsecommerce.ui.components.EcommerceBottomAppBar
import io.ionic.portalsecommerce.ui.components.EcommerceTopAppBar
import io.ionic.portalsecommerce.ui.components.ProductTile
import io.ionic.portalsecommerce.ui.navigation.MainDestinations
import io.ionic.portalsecommerce.ui.theme.PortalsEcommerceTheme
import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

@Composable
fun Cart(onNavigateRoute: (String) -> Unit) {
    val context = LocalContext.current

    val cart = ShoppingCart.getInstance(context)
    val format: NumberFormat = NumberFormat.getCurrencyInstance()
    format.setMaximumFractionDigits(0)
    format.setCurrency(Currency.getInstance(Locale.US))
    Scaffold (
        topBar = { EcommerceTopAppBar(title = "Cart") },
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
            if(cart.contents.size == 0) {
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
            } else {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .padding(20.dp)
                        .verticalScroll(rememberScrollState())
                ){
                    Column (
                        modifier = Modifier.padding(bottom = 30.dp)
                    ) {
                        cart.contents.forEach { cartItem ->
                            CartItem(cartItem.key, cartItem.value)
                        }
                    }
                    HorizontalDivider(color = MaterialTheme.colorScheme.primary, thickness = 1.dp, modifier = Modifier.padding(bottom = 20.dp))
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(text = "Subtotal")
                        Text(text = "${format.format(cart.getTotalPriceOfProductsInCart())}")
                    }
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ){
                        Text(text = "Shipping")
                        Text(text = "Standard - Free")
                    }
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ){
                        Text(
                            text = "Estimated Total",
                            style = MaterialTheme.typography.headlineSmall)
                        Text(
                            text = "${format.format(cart.getTotalPriceOfProductsInCart())} + Tax",
                            style = MaterialTheme.typography.headlineSmall)
                    }
                    Button(
                        onClick = { },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text( text = "Checkout")
                    }
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