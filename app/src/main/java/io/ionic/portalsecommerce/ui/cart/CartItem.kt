package io.ionic.portalsecommerce.ui.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.ionic.portalsecommerce.R
import io.ionic.portalsecommerce.data.model.Product
import io.ionic.portalsecommerce.ui.theme.PortalsEcommerceTheme
import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

@Composable
fun CartItem(product: Product, quantity: Int) {

    val context = LocalContext.current
    val rName = product.image?.replace("-","_")?.replace(".png","")
    val drawableId = remember(rName) {
        val resId by derivedStateOf {
            context.resources.getIdentifier(
                rName,
                "drawable",
                context.packageName
            )
        }
        if (resId != 0 ) resId else R.drawable.not_found
    }
    val format: NumberFormat = NumberFormat.getCurrencyInstance()
    format.setMaximumFractionDigits(0)
    format.setCurrency(Currency.getInstance(Locale.US))
    Row (
        modifier = Modifier
            .padding(bottom = 10.dp)
    ) {
        Image(
            painter = painterResource(drawableId),
            contentDescription = product.title,
            modifier = Modifier
                .width(120.dp)
                .clip(RoundedCornerShape(10.dp))

        )
        Column (
            modifier = Modifier
                .padding(20.dp)
        ) {
            Text(
                text = product.title!!,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.fillMaxWidth(),
                )
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(text = "Qty $quantity")
                Text(text = format.format(product.price))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CartItemPreview() {
    val product = Product()
    product.title = "Capacitor Snapback"
    PortalsEcommerceTheme {
        CartItem(product, 1)
    }
}