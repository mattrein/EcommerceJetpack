package io.ionic.portalsecommerce.ui.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.ionic.portalsecommerce.data.DataService
import io.ionic.portalsecommerce.data.ShoppingCart
import io.ionic.portalsecommerce.data.model.Address
import io.ionic.portalsecommerce.data.model.CreditCard
import io.ionic.portalsecommerce.ui.theme.PortalsEcommerceTheme

@Composable
fun CheckoutScreen (viewModel: CheckoutViewModel = CheckoutViewModel(LocalContext.current)) {

    val addresses = remember { mutableStateOf(viewModel.user.value.addresses) }
    val addressOptions = addresses.value!!.toMutableList()
    val (selectedAddress, onAddressSelected) = remember { mutableStateOf(addressOptions[0]) }

    val payments = remember { mutableStateOf(viewModel.user.value.creditCards) }
    val paymentOptions = payments.value!!.toMutableList()
    val (selectedPayment, onPaymentSelected) = remember { mutableStateOf(paymentOptions[0]) }
    Column (
        modifier = Modifier
            .padding(10.dp)
    ) {
        Text(text = "Delivery",
            style = MaterialTheme.typography.headlineSmall)
        Column(modifier = Modifier
            .selectableGroup()
            .padding(bottom = 20.dp)
        ) {
            addressOptions.forEach { address ->
                Row(  modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
                    .selectable(
                        selected = (address == selectedAddress),
                        onClick = { onAddressSelected(address) },
                        role = Role.RadioButton
                    )) {
                    RadioButton(
                        selected = (selectedAddress == address),
                        onClick = null
                    )
                    Column {
                        Text(text = address.street!!)
                        Text(text = "${address.city!!} ${address.state!!}  ${address.postal!!}")
                    }
                }
            }
        }
        OutlinedButton(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        ) {
            Text(text = "New Address")
        }
        Text(text = "Payment",
            style = MaterialTheme.typography.headlineSmall)
        Column(modifier = Modifier
            .selectableGroup()
            .padding(bottom = 20.dp)
        ) {
            paymentOptions.forEach { payment ->
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
                    .selectable(
                        selected = (payment == selectedPayment),
                        onClick = { onPaymentSelected(payment) },
                        role = Role.RadioButton
                    )) {
                    RadioButton(
                        selected = (selectedPayment == payment),
                        onClick = null
                    )
                    Column {
                        Text(text = "${payment.company!!} ending in ${payment.number!!.takeLast(4)}")
                    }
                }
            }
        }
        OutlinedButton(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        ) {
            Text(text = "New Payment Method")
        }

        Text(text = "Review Total",
            style = MaterialTheme.typography.headlineSmall)
        Text(text = "$32 + Tax",
            modifier = Modifier
                .padding(bottom = 20.dp))

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        ) {
            Text(text = "Place Your Order")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun CheckoutPreview() {
    PortalsEcommerceTheme {
        CheckoutScreen()
    }
}