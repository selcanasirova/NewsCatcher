package com.selcanasirova.newscatcher.unit.base

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

abstract class BaseUseCase<Params, Result> {

    abstract suspend fun onExecute(params: Params?, scope: CoroutineScope): Result?

    open val executionContext: CoroutineContext = Dispatchers.IO
    open val resultContext: CoroutineContext = Dispatchers.Main.immediate

    operator fun invoke(
        scope: CoroutineScope,
        params: Params? = null,
        showErrorDialog: Boolean = false,
        onStart: () -> Unit = {},
        onSuccess: suspend (Result?) -> Unit = {},
        onFailure: (throwable: Throwable) -> Unit = {},
        onCancelled: () -> Unit = {},
        onFinished: () -> Unit = {}
    ) {
        onStart()
        scope.launch(executionContext) {
            try {
                val result = onExecute(params, scope)

                withContext(resultContext) {
                    onSuccess(result)
                }
            } catch (cancellationException: CancellationException) {
                withContext(resultContext) {
                    onCancelled()
                }
                throw cancellationException
            } catch (e: Exception) {
                withContext(resultContext) {
                    onFailure(e)

//                    if (showErrorDialog) {
//                        ErrorStateManager.setErrorState(
//                            ErrorStateManager.ErrorState(
//                                UiText.StringResource(R.string.msg_error), e.message
//                            )//Can be written UiText.DynamicString(e.message ?: "Unknown error") instead of e.message
//                        )
//                    }
                }
            } finally {
                withContext(resultContext) {
                    onFinished()
                }
            }
        }
    }
}