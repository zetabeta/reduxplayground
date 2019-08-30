package ch.checkbit.replayground.redux

import ch.checkbit.replayground.redux.base.Action

sealed class CalendarActions : Action {
    object Next : CalendarActions()
    object Previous : CalendarActions()
    object Init : CalendarActions()
}