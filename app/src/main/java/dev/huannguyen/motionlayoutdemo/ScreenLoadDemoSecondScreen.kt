package dev.huannguyen.motionlayoutdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import dev.huannguyen.motionlayoutdemo.databinding.ScreenLoadDemoSecondScreenBinding

const val KEY_LISTING = "listing"

class ScreenLoadDemoSecondScreen : AppCompatActivity() {
    private lateinit var binding: ScreenLoadDemoSecondScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ScreenLoadDemoSecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listing = intent.getParcelableExtra<Listing>(KEY_LISTING) ?: return
        binding.run {
            Glide.with(this@ScreenLoadDemoSecondScreen)
                .load(listing.photo)
                .into(photo)

            address.text = listing.address
            price.text = listing.price
            desc.text = listing.desc
        }
    }
}
