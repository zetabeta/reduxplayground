package ch.checkbit.replayground.persistence

import java.time.LocalDate


data class Todo(var id: Long, var date: LocalDate, var description: String, var done: Boolean)