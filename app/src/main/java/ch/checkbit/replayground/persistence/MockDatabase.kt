package ch.checkbit.replayground.persistence

import java.time.LocalDate

object MockDatabase : DatabaseAPI {

    private var todos: MutableList<Todo> = mutableListOf()

    init {
        todos.add(Todo(id = 1, date = LocalDate.now(), description = "Laundry", done = false))
        todos.add(
            Todo(
                id = 2,
                date = LocalDate.now(),
                description = "Clean the kitchen",
                done = true
            )
        )
        todos.add(
            Todo(
                id = 3,
                date = LocalDate.now(),
                description = "Test Bug APP-2156",
                done = false
            )
        )
        todos.add(
            Todo(
                id = 4,
                date = LocalDate.now(),
                description = "Call dad for his Birthday",
                done = false
            )
        )
        todos.add(
            Todo(
                id = 5,
                date = LocalDate.now().minusDays(1),
                description = "Order pizza",
                done = true
            )
        )
        todos.add(
            Todo(
                id = 6,
                date = LocalDate.now().minusDays(1),
                description = "Visit the local museum of natural history",
                done = true
            )
        )
        todos.add(
            Todo(
                id = 7,
                date = LocalDate.now().minusDays(2),
                description = "Paint the garden door",
                done = true
            )
        )
        todos.add(
            Todo(
                id = 8,
                date = LocalDate.now().minusDays(2),
                description = "Fill out the bank credit documents",
                done = true
            )
        )
        todos.add(
            Todo(
                id = 9,
                date = LocalDate.now().minusDays(2),
                description = "Call to make a dentist appointment",
                done = true
            )
        )
        todos.add(
            Todo(
                id = 10,
                date = LocalDate.now().plusDays(1),
                description = "Make a cake for Jessy's Birthday",
                done = false
            )
        )
        todos.add(
            Todo(
                id = 11,
                date = LocalDate.now().plusDays(3),
                description = "Meeting in the new office",
                done = false
            )
        )
        todos.add(
            Todo(
                id = 12,
                date = LocalDate.now().plusDays(3),
                description = "Check for the shipment status of parcel 826428764",
                done = false
            )
        )
        todos.add(
            Todo(
                id = 13,
                date = LocalDate.now().plusDays(4),
                description = "Write E-mail to organize the class reunion",
                done = false
            )
        )
    }

    override fun getTodos(date: LocalDate): List<Todo> {
        return todos.filter { t -> t.date == date }
    }

    override fun getTodo(id: Long): Todo? {
        return todos.firstOrNull { t -> t.id == id }
    }

    override fun update(todo: Todo): Todo? {
        return getTodo(todo.id)?.apply {
            date = todo.date
            description = todo.description
            done = todo.done
        }
    }

    override fun addTodo(todo: Todo): Todo? {
        return if (getTodo(todo.id) == null) {
            todos.add(todo)
            todo
        } else {
            null
        }
    }

}