package fr.mcgalanes.groomr.feature.createuserstory.presentation.component.nav

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import fr.mcgalanes.groomr.core.compose.theme.AppTheme
import fr.mcgalanes.groomr.feature.createuserstory.domain.model.Step
import fr.mcgalanes.groomr.feature.createuserstory.presentation.model.toStepItem
import fr.mcgalanes.groomr.feature.createuserstory.presentation.state.StepsNavBarState

@Preview
@Composable
fun NavBarPreview() {
    AppTheme {
        NavBar(
            state = StepsNavBarState(
                items = Step.values().map { StepsNavBarState.ItemState(it.toStepItem(), false) },
            ),
            onSelectStep = {}
        )
    }
}

@Composable
fun NavBar(
    modifier: Modifier = Modifier,
    state: StepsNavBarState,
    onSelectStep: (Step) -> Unit,
) {
    Box(modifier) {
        NavigationRail {
            state.items.forEach { itemState ->
                NavigationRailItem(
                    modifier = Modifier.padding(vertical = 4.dp),
                    icon = {
                        Icon(
                            imageVector = itemState.item.icon,
                            contentDescription = itemState.item.label,
                        )
                    },
                    label = {
                        Text(
                            text = itemState.item.label,
                            textAlign = TextAlign.Center,
                        )
                    },
                    selected = itemState.isSelected,
                    onClick = { onSelectStep(itemState.item.step) }
                )
            }
        }

        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            onClick = {},
        ) {
            Icon(Icons.Filled.Share, "Localized description")
        }
    }
}
