package dev.huannguyen.motionlayoutdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import dev.huannguyen.motionlayoutdemo.databinding.ItemViewBinding
import dev.huannguyen.motionlayoutdemo.databinding.ViewHolderSwipeDemoActivityBinding

class ViewHolderSwipeDemo : AppCompatActivity() {
    private lateinit var binding: ViewHolderSwipeDemoActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ViewHolderSwipeDemoActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.run {
            adapter = Adapter(testData)
            addItemDecoration(DividerItemDecoration(this@ViewHolderSwipeDemo, RecyclerView.VERTICAL))
//            ItemTouchHelper(SwipeToArchiveCallback()).attachToRecyclerView(this)
        }
    }
}

private val testData = (1..10).map { "Item $it" }

class Adapter(private val items: List<String>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemViewBinding.bind(view)

    fun bind(value: String) {
        binding.name.text = value
    }
}

class SwipeToArchiveCallback : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.START) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean = false

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

    }
}
