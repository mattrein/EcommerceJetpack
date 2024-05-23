package io.ionic.portalsecommerce.ui.help

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.ionic.portalsecommerce.ui.theme.PortalsEcommerceTheme

@Composable
fun Help(upPress: () -> Unit) {
    Text(text = "Help Page")
    Button(onClick = upPress) {
        
    }
}


@Preview(showBackground = true)
@Composable
fun HelpPreview() {
    PortalsEcommerceTheme {
        Help({})
    }
}
