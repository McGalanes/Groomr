@file:OptIn(ExperimentalComposeUiApi::class)

package fr.mcgalanes.groomr.feature.createuserstory.presentation.component.need

import ExtractedStrings
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import fr.mcgalanes.groomr.core.compose.component.spacer.HorizontalSpace
import fr.mcgalanes.groomr.core.compose.component.spacer.VerticalSpace
import fr.mcgalanes.groomr.core.compose.theme.AppTheme
import fr.mcgalanes.groomr.feature.createuserstory.presentation.model.InputType

@Preview
@Composable
private fun NeedFormPreview() {
    Column {
        AppTheme(useDarkTheme = false) {
            NeedForm(
                modifier = Modifier.padding(16.dp),
                personaInput = "",
                wishInput = "",
                goalInput = "",
                onInputChange = { _, _ -> },
            )
        }

        HorizontalSpace(16.dp)

        AppTheme(useDarkTheme = true) {
            NeedForm(
                modifier = Modifier.padding(16.dp),
                personaInput = "",
                wishInput = "",
                goalInput = "",
                onInputChange = { _, _ -> },
            )
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun NeedForm(
    modifier: Modifier = Modifier,
    personaInput: String,
    wishInput: String,
    goalInput: String,
    onInputChange: (InputType, String) -> Unit,
) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .onKeyPressedDown { key ->
                when (key) {
                    Key.Escape -> {
                        focusManager.clearFocus()
                        true
                    }

                    Key.Tab -> {
                        focusManager.moveFocus(FocusDirection.Down)
                            .also { succeed ->
                                if (!succeed) focusManager.clearFocus()
                            }
                        true
                    }

                    else -> false
                }

            },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = ExtractedStrings.createuserstory_needform_title,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
        )

        VerticalSpace(24.dp)


        OutlinedTextField(
            label = { Text(text = ExtractedStrings.createuserstory_needform_persona_label) },
            placeholder = { Text(text = ExtractedStrings.createuserstory_needform_persona_placeholder) },
            value = personaInput,
            onValueChange = { onInputChange(InputType.PERSONA, it) },
        )

        VerticalSpace(16.dp)

        OutlinedTextField(
            label = { Text(text = ExtractedStrings.createuserstory_needform_wish_label) },
            placeholder = { Text(text = ExtractedStrings.createuserstory_needform_wish_placeholder) },
            value = wishInput,
            onValueChange = { onInputChange(InputType.WISH, it) },
        )

        VerticalSpace(16.dp)

        OutlinedTextField(
            label = { Text(text = ExtractedStrings.createuserstory_needform_goal_label) },
            placeholder = { Text(text = ExtractedStrings.createuserstory_needform_goal_placeholder) },
            value = goalInput,
            onValueChange = { onInputChange(InputType.GOAL, it) },
        )
    }
}

private fun Modifier.onKeyPressedDown(
    onKeyPressed: (Key) -> Boolean,
) =
    this.onPreviewKeyEvent {
        if (it.type == KeyEventType.KeyDown) {
            onKeyPressed(it.key)
        } else {
            false
        }
    }