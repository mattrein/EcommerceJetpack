package io.ionic.portalsecommerce.ui.payment

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.ionic.portalsecommerce.data.model.CreditCard
import io.ionic.portalsecommerce.ui.theme.PortalsEcommerceTheme

@Composable
fun CreditCardListItem (creditCard: CreditCard, onEdit: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {

            Row (
        ) {
            Text(
                text = "${creditCard.company!!} ending in ${creditCard.number!!.takeLast(4)}",
                modifier = Modifier
                    .height(50.dp)
                    .wrapContentHeight(Alignment.CenterVertically)
            )
            Spacer(
                modifier = Modifier.weight(1f)
            )
            TextButton(onClick = { onEdit() }) {
                Text(text = "Edit")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CreditCardListItemPreview() {
    PortalsEcommerceTheme {
        val creditCard = CreditCard()
        creditCard.id = 0
        creditCard.company = "Visa"
        creditCard.number = "12345678900"
        CreditCardListItem(creditCard, {})
    }
}