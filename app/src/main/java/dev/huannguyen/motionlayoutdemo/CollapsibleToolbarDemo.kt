package dev.huannguyen.motionlayoutdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import dev.huannguyen.motionlayoutdemo.databinding.CollapsibleToolbarDemoActivityBinding

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
