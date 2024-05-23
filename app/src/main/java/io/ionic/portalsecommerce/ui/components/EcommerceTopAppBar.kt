package io.ionic.portalsecommerce.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import io.ionic.portalsecommerce.ui.theme.PortalsEcommerceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcommerceTopAppBar(title: String, upPress: (() -> Unit)? = null, actionPress: (() -> Unit)? = null) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(title)
        },
        navigationIcon = {
            if (upPress != null) {
                IconButton(onClick = { upPress() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }

        },
        actions = {
            if(actionPress != null) {
                IconButton(onClick = actionPress) {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "Localized description"
                    )
                }
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
fun EcommerceTopAppBarPreview() {
    PortalsEcommerceTheme {
        EcommerceTopAppBar("Title")
    }
}
@Preview(showBackground = true)
@Composable
fun EcommerceTopAppBarWithBackArrowAndActionPreview() {
    PortalsEcommerceTheme {
        EcommerceTopAppBar("Title", { }, { })
    }
}