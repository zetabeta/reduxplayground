package ch.checkbit.replayground

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ch.checkbit.replayground.persistence.Database
import ch.checkbit.replayground.persistence.Todo

class TodosAdapter(private var items: List<Todo>) :
    RecyclerView.Adapter<TodosAdapter.TodoViewHolder>() {

    fun items(data: List<Todo>) {
        this.items = data
        this.notifyDataSetChanged()
    }

    class TodoViewHolder(val layout: LinearLayout) : RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.todos_item_view,
            parent,
            false
        ) as LinearLayout
        return TodoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.layout.findViewById<TextView>(R.id.descripion).text = items[position].description

        val done = holder.layout.findViewById<CheckBox>(R.id.done)
        done.isChecked = items[position].done
        done.setOnClickListener {
            val item = items[position]
            item.done = !item.done
            Database.update(item) // TODO here we change state?? maybe save in the store
            notifyDataSetChanged()
        }

    }

    override fun getItemCount() = items.size
}
