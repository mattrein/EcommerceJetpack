package io.ionic.portalsecommerce.ui.profile

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.ionic.portalsecommerce.ui.components.EcommerceBottomAppBar
import io.ionic.portalsecommerce.ui.components.EcommerceTopAppBar

@Composable
fun Profile(onNavigateRoute: (String) -> Unit) {
    Scaffold (
        topBar = { EcommerceTopAppBar(title = "Profile") },
        bottomBar = { EcommerceBottomAppBar("home/profile", onNavigateRoute) }
    ) {
            paddingValues ->
        Text(text = "Profile", Modifier.padding(paddingValues))
    }
}