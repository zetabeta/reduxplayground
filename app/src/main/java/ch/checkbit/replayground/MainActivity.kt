package ch.checkbit.replayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.checkbit.replayground.persistence.Database
import ch.checkbit.replayground.redux.CalendarActions

import java.time.format.DateTimeFormatter


class MainActivity : AppCompatActivity() {


    var formatter : DateTimeFormatter = DateTimeFormatter.ofPattern("d MMMM, yyyy")

    private lateinit var todosRecyclerView: RecyclerView
    private lateinit var todosAdapter: TodosAdapter
    private lateinit var todosViewManager: RecyclerView.LayoutManager


    private val date by lazy { findViewById<AppCompatTextView>(R.id.date) }
    private val nextButton by lazy { findViewById<ImageView>(R.id.right_arrow) }
    private val previousButton by lazy { findViewById<ImageView>(R.id.left_arrow) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        todosViewManager = LinearLayoutManager(this)
        todosAdapter = TodosAdapter(listOf())

        todosRecyclerView = findViewById<RecyclerView>(R.id.todos).apply {
            setHasFixedSize(true)
            layoutManager = todosViewManager
            adapter = todosAdapter
        }

        DI.store.add {
            date.text = it.date.format(formatter)
            todosAdapter.items(Database.getTodos(it.date)) // TODO questions: new subscriber?????
        }

        DI.store.dispatch(CalendarActions.Init)

        nextButton.setOnClickListener {
           DI.store.dispatch(CalendarActions.Next)
        }

        previousButton.setOnClickListener {
            DI.store.dispatch(CalendarActions.Previous)
        }
    }
}
