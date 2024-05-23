package io.ionic.portalsecommerce.ui.help

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.ionic.portalsecommerce.ui.components.EcommerceTopAppBar
import io.ionic.portalsecommerce.ui.theme.PortalsEcommerceTheme

@Composable
fun Help(upPress: () -> Unit) {
    Scaffold (
        topBar = { EcommerceTopAppBar(title = "Help", upPress) }
    ) { paddingValues ->
        Column (
            modifier = Modifier
                .padding(paddingValues)
                .padding(top = 20.dp)
                .padding(10.dp)

        ) {
            Text(
                text = "Get Assistance",
                style = MaterialTheme.typography.headlineSmall,
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                style = MaterialTheme.typography.bodyLarge
            )
            TextButton (
                onClick = {},
                modifier = Modifier
                    .padding(top = 30.dp)
                    .padding(10.dp)
            ){
                Icon(Icons.Filled.Email, contentDescription = "Email")
                Text(text = "help@portals.ionic.io", modifier = Modifier.padding(start = 20.dp))
            }
            TextButton (
                onClick = {},
                modifier = Modifier
                    .padding(10.dp)
            ){
                Icon(Icons.Filled.Phone, contentDescription = "Phone")
                Text(
                    text = "1-800-PORTALS",
                    modifier = Modifier.padding(start = 20.dp)
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun HelpPreview() {
    PortalsEcommerceTheme {
        Help({})
    }
}
