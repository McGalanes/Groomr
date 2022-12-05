package fr.mcgalanes.groomr.feature.createuserstory.presentation

import fr.mcgalanes.groomr.feature.createuserstory.domain.StepUseCase
import fr.mcgalanes.groomr.feature.createuserstory.domain.model.Step
import io.mockk.every
import io.mockk.mockk
import kotlin.test.Test
import kotlin.test.assertEquals


internal class CreateUserStoryViewModelTest {

    private val stepUseCase: StepUseCase = mockk()
    private fun viewModel() = CreateUserStoryViewModel(stepUseCase)

    @Test
    fun `on next click, should show next step`() {
        //GIVEN
        val nextStep = Step.values().random()
        every { stepUseCase.getNext(any()) } returns nextStep

        val viewModel = viewModel()

        //WHEN
        viewModel.onNextClick()

        //THEN
        assertEquals(
            viewModel.userStoryState.value[nextStep],
            viewModel.uiState.value.stepFormState,
        )
    }

    @Test
    fun `on previous click, should show previous step`() {
        //GIVEN
        val previousStep = Step.values().random()
        every { stepUseCase.getPrevious(any()) } returns previousStep

        val viewModel = viewModel()

        //WHEN
        viewModel.onPreviousClick()

        //THEN
        assertEquals(
            viewModel.userStoryState.value[previousStep],
            viewModel.uiState.value.stepFormState,
        )
    }
}
