package dev.huannguyen.motionlayoutdemo

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat.makeSceneTransitionAnimation
import com.bumptech.glide.Glide
import dev.huannguyen.motionlayoutdemo.databinding.TransitionDemoFirstDemoBinding
import kotlinx.android.parcel.Parcelize


class TransitionDemoFirstScreen : AppCompatActivity() {
    private lateinit var binding: TransitionDemoFirstDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TransitionDemoFirstDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.list.run {
            for (i in 0 until childCount) {
                val view = getChildAt(i) as ImageView
                val listing = listingData[i]
                Glide.with(this)
                    .load(listing.photo)
                    .into(view)

                view.setOnClickListener {
                    val activity = this@TransitionDemoFirstScreen
                    view.transitionName = "photo"
                    val options = makeSceneTransitionAnimation(activity, view, view.transitionName)

                    val intent = Intent(activity, TransitionDemoSecondScreen::class.java).apply {
                        putExtra(KEY_LISTING, listing)
                    }
                    startActivity(intent, options.toBundle())
                }
            }
        }
    }
}

private val listingData = listOf(
    Listing(
        "https://i2.au.reastatic.net/800x600-format=webp/8308042d48c8dd938efd162e9e4abadbed31c51df6296d485c9e72dd3ef1488b/image.jpg",
        "4401a/625 Chapel Street, South Yarra",
        "$25,000,000",
        "Our Sales Suite is located at 228 Toorak Road, South Yarra. If you wish find out more about the property, please book an appointment by calling the listed agent or (03) 9090 2500.\n" +
        "\n" +
        "OPENING HOURS\n" +
        "Monday - Friday 10:00am - 6:00pm\n" +
        "Saturday and Sundays 10:00am - 4:00pm"
    ),
    Listing(
        "https://i2.au.reastatic.net/800x600-format=webp/2c0c17226fa0b0b43ac682305dbae100ec5f58581839e35564aa284e971a5768/image.jpg",
        "279 Domain Road, South Yarra",
        "$100,000,000",
        "This spectacular two storey town residence spanning across over 407sqm (approx.) of luxurious internal living area with uninterrupted northern vistas in this enviable location.\n" +
        "A stunning collaboration from renowned designers Woods Bagot, MGS Architects and Jack Merlo landscapes have created this stunning " +
        "residence that provides 4 bedroom accommodation, 3 defined living zones, separate custom study and private basement garaging for 3 " +
        "cars and private lift. Perched on the doorstep of the Botanic Gardens and set High on Domain Hill this beautifully created residence " +
        "introduces new genre of living, positioned in arguably Melbourne’s most breathtaking lifestyle locations."
    ),
    Listing(
        "https://i2.au.reastatic.net/1000x750-format=webp/e31b22d5391ef9011ecc5e741f8969e34d11d256d2b7f3235de06e25bb8f9bfc/image.jpg",
        "270a Punt Road, South Yarra",
        "$3,000,000",
        "This is a world first. A daring 3 bedroom + study, 5 bathroom bespoke residence with an indoor and outdoor swimming pool. " +
        "Architect Robert Buckerfield has excelled, every centimetre of this luxurious oasis is thoughtful and well-crafted, from the " +
        "art-inspired Sicis mosaic wall tiles, Textured Venetian render, architectural glazing, incredible slabs of stunning marble that are " +
        "ubiquitous, Paco Jaanson fittings, Ebony Macassar inspired finishes and amazing exquisite bespoke details everywhere you look."
    ),
    Listing(
        "https://i2.au.reastatic.net/800x600-format=webp/64c69a0ce03fb5929e9e0c9e67c9c61cc380e2758f93fcdd0f561f96ef09fc07/image.jpg",
        "402/2 Hobson Street, South Yarra",
        "$2,000,000",
        "Spectacular Penthouse residence with enormous terraces that surround the perimeter of this extraordinary luxurious inner city " +
        "apartment enjoying spectacular,uninterrupted views of the expansive city skyline. Fingerprint technology that allows exclusive access " +
        "via a lift to the top floor, enters directly and securely to a contemporary light filled large open plan living and dining area with " +
        "adjacent formal sitting room with both areas having impressive marble open fire places and all opening onto alfresco terraces that are " +
        "great for all year outdoor entertaining complete with built in BBQ and spa. The magnificent European kitchen also has a separate pantry. " +
        "All three beautiful bedrooms enjoy en-suite amenities. Master ensuite has a shower/steam room and an enormous dressing room. Floor to " +
        "ceiling double glazed windows throughout , excellent heating and cooling. Powder room. Laundry, Fabulous, secure, multi car garage and gym. " +
        "Convenient location within a short walk to vibrant Hawksburn shopping centre, transport, cafes and all amenities. Inspection a must !!!"
    )
)

@Parcelize
data class Listing(val photo: String, val address: String, val price: String, val desc: String) : Parcelable
