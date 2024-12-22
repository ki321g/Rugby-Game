package ie.setu.rugbygame.ui.components.donate

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import ie.setu.rugbygame.R
import ie.setu.rugbygame.ui.theme.RugbyGameTheme

@Composable
fun MessageInput(
    modifier: Modifier = Modifier,
    onMessageChange: (String) -> Unit
) {

    var message by remember { mutableStateOf("") }

    OutlinedTextField(
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = MaterialTheme.colorScheme.primary,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
        ),
        maxLines = 2,
        value = message,
        onValueChange = {
            message = it
            onMessageChange(message)
        },
        modifier = modifier.fillMaxWidth(),
        label = { Text(stringResource(R.string.enter_message)) }
    )
}

@Preview(showBackground = true)
@Composable
fun MessagePreview() {
    RugbyGameTheme {
        MessageInput(
            Modifier,
            onMessageChange = {})
    }
}