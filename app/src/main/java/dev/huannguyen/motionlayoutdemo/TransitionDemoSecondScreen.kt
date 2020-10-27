package dev.huannguyen.motionlayoutdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import dev.huannguyen.motionlayoutdemo.databinding.TransitionDemoSecondScreenBinding

const val KEY_LISTING = "listing"

class TransitionDemoSecondScreen : AppCompatActivity() {
    private lateinit var binding: TransitionDemoSecondScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TransitionDemoSecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listing = intent.getParcelableExtra<Listing>(KEY_LISTING) ?: return
        binding.run {
            Glide.with(this@TransitionDemoSecondScreen)
                .load(listing.photo)
                .into(photo)

            address.text = listing.address
            price.text = listing.price
            desc.text = listing.desc
        }
    }
}
