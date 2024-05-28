package io.ionic.portalsecommerce.ui.payment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
import io.ionic.portalsecommerce.ui.components.EcommerceBottomAppBar
import io.ionic.portalsecommerce.ui.components.EcommerceTopAppBar
import io.ionic.portalsecommerce.ui.theme.PortalsEcommerceTheme
import io.ionic.portalsecommerce.ui.components.CreditCardListItem

@Composable
fun PaymentScreen(onNavigateRoute: (String) -> Unit, upPress: () -> Unit, viewModel: PaymentViewModel = PaymentViewModel(
    LocalContext.current)) {

    val user by viewModel.user

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
                value = user.firstName.orEmpty(),
                onValueChange = { viewModel.onFirstNameChange(it) },
                label = { Text("First Name") },
                singleLine = true
            )
            OutlinedTextField(
                value = user.lastName.orEmpty(),
                onValueChange = { viewModel.onLastNameChange(it) },
                label = { Text("Last Name") },
                singleLine = true
            )
            OutlinedTextField(
                value = user.email.orEmpty(),
                onValueChange = { viewModel.onEmailChange(it) },
                label = { Text("Email") },
                singleLine = true
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentScreenPreview() {
    PortalsEcommerceTheme {
        PaymentScreen({}, {})
    }
}