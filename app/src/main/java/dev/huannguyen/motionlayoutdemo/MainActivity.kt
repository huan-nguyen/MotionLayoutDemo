package dev.huannguyen.motionlayoutdemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
import kotlinx.android.synthetic.main.activity_main.container
import java.util.Dictionary

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addDemo<Demo1Activity>("Basic Animation")
        addDemo<FabDemoActivity>("Fab Animation")
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
        container.addView(view)
    }
}
