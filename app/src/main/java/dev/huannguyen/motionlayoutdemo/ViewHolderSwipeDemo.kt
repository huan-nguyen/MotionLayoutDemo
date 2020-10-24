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
        }
    }
}
