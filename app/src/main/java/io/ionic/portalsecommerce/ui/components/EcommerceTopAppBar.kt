package io.ionic.portalsecommerce.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.ionic.portalsecommerce.ui.theme.PortalsEcommerceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcommerceTopAppBar(title: String) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(title)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun EcommerceTopAppBarPreview() {
    PortalsEcommerceTheme {
        EcommerceTopAppBar("Title")
    }
}