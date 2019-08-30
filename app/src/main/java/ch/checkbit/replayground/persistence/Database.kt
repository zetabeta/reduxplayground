package ch.checkbit.replayground.persistence

import java.time.LocalDate

object Database {

    // to change the database, change here
    private var database: DatabaseAPI = MockDatabase

    fun getTodos(date: LocalDate): List<Todo> {
        return database.getTodos(date)
    }

    fun getTodo(id: Long): Todo? {
        return database.getTodo(id)
    }

    fun update(todo: Todo): Todo? {
        return database.update(todo)
    }

    fun addTodo(todo: Todo): Todo? {
        return database.addTodo(todo)
    }
}