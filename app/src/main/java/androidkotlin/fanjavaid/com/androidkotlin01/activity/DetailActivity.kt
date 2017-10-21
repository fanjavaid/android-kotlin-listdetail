package androidkotlin.fanjavaid.com.androidkotlin01.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import androidkotlin.fanjavaid.com.androidkotlin01.R
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    companion object {
        val ARG_THUMBNAIL = "arg_thumbnail"
        val ARG_TITLE: String = "arg_title"
        val ARG_DESCRIPTION: String ="arg_description"
    }

    var mThumnbail: String? = null
    var mTitle: String? = null
    var mDescription: String? = null

    var mImageThumbnail: ImageView? = null
    var mTextTitle: TextView? = null
    var mTextDescription: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        mTextTitle = findViewById(R.id.text_detail_title)
        mTextDescription = findViewById(R.id.text_detail_description)
        mImageThumbnail = findViewById(R.id.image_detail_thumbnail)

        fillData()
    }

    fun fillData() {
        mThumnbail = intent.getStringExtra(ARG_THUMBNAIL)
        mTitle = intent.getStringExtra(ARG_TITLE) ?: "Unknown"
        mDescription = intent.getStringExtra(ARG_DESCRIPTION) ?: "Unknown Description"

        mTextTitle?.text = mTitle
        mTextDescription?.text = mDescription

        Glide.with(this)
                .load(mThumnbail)
                .into(mImageThumbnail)
    }
}
