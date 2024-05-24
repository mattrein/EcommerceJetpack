package io.ionic.portalsecommerce.ui.components

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.ionic.portalsecommerce.data.model.Address
import io.ionic.portalsecommerce.ui.theme.PortalsEcommerceTheme

@Composable
fun AddressListItem (fullName: String, address: Address) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column {
            Text(text = fullName)
            Text(text = address.street!!)
            Text(text = "${address.city!!}")
        }
        Column () {
            Row (
            ) {
                Spacer(
                    modifier = Modifier.weight(1f)
                )
                if (address.preferred) {
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Default")
                    }
                }
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Edit")
                }
            }
        }
     }
}


@Preview(showBackground = true)
@Composable
fun AddressListItemPreview() {
    PortalsEcommerceTheme {
        val address = Address()
        address.id = 0
        address.street = "123 main st"
        address.city = "townville AA 55555"
        address.state = "AA"
        address.postal = "55555"
        AddressListItem("Mary Jane", address)
    }
}