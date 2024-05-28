package io.ionic.portalsecommerce.ui.address

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
import androidx.compose.material3.TextField
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
fun AddressScreen(addressId: Int, onNavigateRoute: (String) -> Unit, upPress: () -> Unit, viewModel: AddressViewModel = AddressViewModel(
    LocalContext.current, addressId)) {

    val user by viewModel.user
    val address by viewModel.address

    Scaffold (
        topBar = { EcommerceTopAppBar(title = "Edit Address", upPress) },
    ) {
            paddingValues ->
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
                .padding(top = 20.dp)
        ) {
            TextField(value = user.fullName(), onValueChange = {}, readOnly = true)
            OutlinedTextField(
                value = address.street.orEmpty(),
                onValueChange = { viewModel.onAddressChange(it) },
                label = { Text("Address") },
                singleLine = true
            )
            OutlinedTextField(
                value = address.postal.orEmpty(),
                onValueChange = { viewModel.onZipCodeChange(it) },
                label = { Text("Zip COde") },
                singleLine = true
            )
            OutlinedTextField(
                value = address.city.orEmpty(),
                onValueChange = { viewModel.onCityChange(it) },
                label = { Text("City") },
                singleLine = true
            )
            OutlinedTextField(
                value = address.state.orEmpty(),
                onValueChange = { viewModel.onStateChange(it) },
                label = { Text("State") },
                singleLine = true
            )
            Row {
                Checkbox(checked = address.preferred, onCheckedChange = {viewModel.onPreferredChange(it)})
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
fun AddressScreenPreview() {
    PortalsEcommerceTheme {
        AddressScreen(1, {}, {})
    }
}