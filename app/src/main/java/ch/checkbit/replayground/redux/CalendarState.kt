package ch.checkbit.replayground.redux

import ch.checkbit.replayground.redux.base.State
import java.time.LocalDate

data class CalendarState(val date: LocalDate = LocalDate.now()) :
    State