@file:OptIn(ExperimentalComposeUiApi::class)

package fr.mcgalanes.groomr.feature.createuserstory.presentation.component.need

import ExtractedStrings
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.mcgalanes.groomr.core.compose.component.spacer.HorizontalSpace
import fr.mcgalanes.groomr.core.compose.component.spacer.VerticalSpace
import fr.mcgalanes.groomr.core.compose.theme.AppTheme
import fr.mcgalanes.groomr.feature.createuserstory.presentation.component.StepForm
import fr.mcgalanes.groomr.feature.createuserstory.presentation.state.StepFormState

@Preview
@Composable
private fun NeedFormPreview() {
    Column {
        AppTheme(useDarkTheme = false) {
            NeedForm(
                modifier = Modifier.padding(16.dp),
                state = StepFormState.Need("", "", ""),
                onFormChange = {}
            )
        }

        HorizontalSpace(16.dp)

        AppTheme(useDarkTheme = true) {
            NeedForm(
                modifier = Modifier.padding(16.dp),
                state = StepFormState.Need("", "", ""),
                onFormChange = {}
            )
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun NeedForm(
    modifier: Modifier = Modifier,
    state: StepFormState.Need,
    onFormChange: (StepFormState.Need) -> Unit,
) {
    StepForm(
        modifier = modifier,
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
            value = state.persona,
            onValueChange = { onFormChange(state.copy(persona = it)) },
        )

        VerticalSpace(16.dp)

        OutlinedTextField(
            label = { Text(text = ExtractedStrings.createuserstory_needform_wish_label) },
            placeholder = { Text(text = ExtractedStrings.createuserstory_needform_wish_placeholder) },
            value = state.wish,
            onValueChange = { onFormChange(state.copy(wish = it)) },
        )

        VerticalSpace(16.dp)

        OutlinedTextField(
            label = { Text(text = ExtractedStrings.createuserstory_needform_goal_label) },
            placeholder = { Text(text = ExtractedStrings.createuserstory_needform_goal_placeholder) },
            value = state.goal,
            onValueChange = { onFormChange(state.copy(goal = it)) },
        )
    }
}