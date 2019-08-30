package ch.checkbit.replayground

import ch.checkbit.replayground.redux.CalendarActions
import ch.checkbit.replayground.redux.CalendarState
import ch.checkbit.replayground.redux.DefaultStore
import ch.checkbit.replayground.redux.base.Reducer


val CalendarStateReducer: Reducer<CalendarState> = { old, action ->
    when (action) {
        is CalendarActions.Init -> CalendarState()
        is CalendarActions.Next -> old.copy(date = old.date.plusDays(1))
        is CalendarActions.Previous -> old.copy(date = old.date.minusDays(1))
        else -> old
    }
}

object DI {
    val store =
        DefaultStore(
            initialState = CalendarState(),
            reducer = CalendarStateReducer
        )
}