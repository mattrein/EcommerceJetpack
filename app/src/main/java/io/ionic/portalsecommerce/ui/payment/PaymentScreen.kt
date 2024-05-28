package io.ionic.portalsecommerce.ui.payment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.ionic.portalsecommerce.ui.components.EcommerceTopAppBar
import io.ionic.portalsecommerce.ui.theme.PortalsEcommerceTheme

@Composable
fun PaymentScreen(paymentId: Int, onNavigateRoute: (String) -> Unit, upPress: () -> Unit, viewModel: PaymentViewModel = PaymentViewModel(
    LocalContext.current, paymentId)) {

    val user by viewModel.user
    val payment by viewModel.payment

    Scaffold (
        topBar = { EcommerceTopAppBar(title = "Edit Payment", upPress) },
    ) {
            paddingValues ->
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {
            OutlinedTextField(
                value = payment.number.orEmpty(),
                onValueChange = { viewModel.onCardNumberChange(it) },
                label = { Text("Card Number") },
                singleLine = true
            )
            OutlinedTextField(
                value = payment.expirationDate.orEmpty(),
                onValueChange = { viewModel.onExpDateChange(it) },
                label = { Text("Expiration Date") },
                singleLine = true
            )
            OutlinedTextField(
                value = payment.cvv.orEmpty(),
                onValueChange = { viewModel.onCVVChange(it) },
                label = { Text("CVV") },
                singleLine = true
            )
            OutlinedTextField(
                value = payment.zip.orEmpty(),
                onValueChange = { viewModel.onZipChange(it) },
                label = { Text("Zip") },
                singleLine = true
            )
            Row {
                Checkbox(checked = payment.preferred, onCheckedChange = {viewModel.onPreferredChange(it)})
                Text(
                    text = "Set as default address",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 16.dp, top = 12.dp)
                )
            }
            Button(
                onClick = {
                    viewModel.onSave()
                    upPress()
                },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Save")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentScreenPreview() {
    PortalsEcommerceTheme {
        PaymentScreen(1, {}, {})
    }
}