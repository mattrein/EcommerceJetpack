package io.ionic.portalsecommerce.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.ionic.portalsecommerce.R
import io.ionic.portalsecommerce.data.model.Product
import io.ionic.portalsecommerce.ui.theme.PortalsEcommerceTheme

@Composable
fun ProductTile(
    product: Product,
    onProductClick: (Int) -> Unit
) {
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
    Surface (onClick = { onProductClick(product.id) }) {
        Column {
            Image(
                painter = painterResource(drawableId),
                contentDescription = product.title,
                modifier = Modifier
//                    .size(120.dp, 120.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Text(
                text = product.title!!,
                style = MaterialTheme.typography.bodyMedium

            )
            Text(
                text = "$${product.price}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun ProductTilePreview() {
    PortalsEcommerceTheme {
        val product = Product()
        product.id = 0
        product.title = "Capacitor Hat"
        product.price = 999.99F
        ProductTile(product, {})
    }
}