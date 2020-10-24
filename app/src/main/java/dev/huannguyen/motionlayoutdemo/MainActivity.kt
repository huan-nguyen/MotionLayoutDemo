package dev.huannguyen.motionlayoutdemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
import dev.huannguyen.motionlayoutdemo.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addDemo<BasicDemo>("Basic Animation")
        addDemo<ViewHolderSwipeDemo>("ViewHolder Swipe Animation")
    }

    private inline fun <reified T: Activity> addDemo(name: String) {
        val view = TextView(this).apply {
            text = name
            setPadding(32)
            setOnClickListener { startActivity(Intent(this@MainActivity, T::class.java)) }
            val typedValue = TypedValue()
            context.theme.resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true)
            setBackgroundResource(typedValue.resourceId)
        }
        binding.container.addView(view)
    }
}
