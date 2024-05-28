package io.ionic.portalsecommerce.ui.address

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.ionic.portalsecommerce.data.model.Address
import io.ionic.portalsecommerce.ui.theme.PortalsEcommerceTheme

@Composable
fun AddressListItem (fullName: String, address: Address, onEdit: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp)
    ) {
        Column {
            Text(text = fullName)
            Text(text = address.street!!)
            Text(text = "${address.city!!} ${address.state}  ${address.postal}")
        }
        Column () {
            Row (
            ) {
                Spacer(
                    modifier = Modifier.weight(1f)
                )
                if (address.preferred) {
                    Button(onClick = {  }) {
                        Text(text = "Default")
                    }
                }
                TextButton(onClick = { onEdit() }) {
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
        AddressListItem("Mary Jane", address, {})
    }
}