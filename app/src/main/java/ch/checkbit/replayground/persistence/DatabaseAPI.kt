package ch.checkbit.replayground.persistence

import java.time.LocalDate

interface DatabaseAPI {

    fun getTodos(date: LocalDate): List<Todo>

    fun getTodo(id: Long): Todo?

    fun update(todo: Todo): Todo?

    fun addTodo(todo: Todo): Todo?
}