package dev.huannguyen.motionlayoutdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import dev.huannguyen.motionlayoutdemo.databinding.CollapsibleToolbarDemoActivityBinding
import dev.huannguyen.motionlayoutdemo.databinding.ItemViewBinding

class CollapsibleToolbarDemo : AppCompatActivity() {
    private lateinit var binding: CollapsibleToolbarDemoActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CollapsibleToolbarDemoActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.run {
            adapter = Adapter(testData)
            addItemDecoration(DividerItemDecoration(this@CollapsibleToolbarDemo, RecyclerView.VERTICAL))
        }
    }
}

val testData = (1..20).map { "Item $it" }

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
