package io.ionic.portalsecommerce.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.ionic.portalsecommerce.R
import io.ionic.portalsecommerce.ui.components.EcommerceBottomAppBar
import io.ionic.portalsecommerce.ui.components.EcommerceTopAppBar
import io.ionic.portalsecommerce.ui.theme.PortalsEcommerceTheme
import io.ionic.portalsecommerce.ui.address.AddressListItem
import io.ionic.portalsecommerce.ui.payment.CreditCardListItem
import io.ionic.portalsecommerce.ui.navigation.MainDestinations

@Composable
fun ProfileScreen(onNavigateRoute: (String) -> Unit, viewModel: ProfileViewModel = ProfileViewModel(
    LocalContext.current)) {

    val user by viewModel.user

    fun addAddress() {
    }

    Scaffold (
        topBar = { EcommerceTopAppBar(title = "Profile") },
        bottomBar = { EcommerceBottomAppBar("home/profile", onNavigateRoute) }
    ) {
            paddingValues ->
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .clickable { }
            ) {
                Image(
                    painter = painterResource(R.drawable.capacitor_hat),
                    contentDescription = "User Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(125.dp)
                        .clip(CircleShape)
                )
                Icon(
                    Icons.Filled.AddCircle,
                    contentDescription = "Update Profile Picture",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .size(30.dp)
                        .offset(y = 15.dp)
                        .border(2.dp, MaterialTheme.colorScheme.background, CircleShape)
                )
            }
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
            Column(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(20.dp)
            ) {
                Text(
                    text = "Adresses",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                )
                Column (
                    modifier = Modifier.padding(bottom = 30.dp)
                ) {
                    viewModel.addresses.forEach { address ->
                        AddressListItem(
                            user.fullName(),address,
                            { onNavigateRoute("${MainDestinations.ADDRESS_ROUTE}/${address.id}") }
                        )
                    }
                    Button(
                        onClick = { onNavigateRoute("${MainDestinations.ADDRESS_ROUTE}/${0}") },
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth()
                    ) {
                        Text(text = "New Address")
                    }
                }
                Text(
                    text = "Payment Methods",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                )
                Column (
                    modifier = Modifier.padding(bottom = 30.dp)
                ) {
                    viewModel.creditCards.forEach { creditCard ->
                        CreditCardListItem(creditCard,
                            { onNavigateRoute("${MainDestinations.PAYMENT_ROUTE}/${creditCard.id}") }
                        )
                    }
                    Button(
                        onClick = { onNavigateRoute("${MainDestinations.PAYMENT_ROUTE}/${0}")  },
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth()
                    ) {
                        Text(text = "New Payment Method")
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    PortalsEcommerceTheme {
        ProfileScreen({})
    }
}