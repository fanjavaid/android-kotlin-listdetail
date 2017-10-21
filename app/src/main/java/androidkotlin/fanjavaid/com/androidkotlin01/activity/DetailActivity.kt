package androidkotlin.fanjavaid.com.androidkotlin01.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidkotlin.fanjavaid.com.androidkotlin01.R

class DetailActivity : AppCompatActivity() {

    companion object {
        val ARG_TITLE: String = "arg_title"
        val ARG_DESCRIPTION: String ="arg_description"
    }

    var mTitle: String? = null
    var mDescription: String? = null

    var mTextTitle: TextView? = null
    var mTextDescription: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        mTextTitle = findViewById(R.id.text_detail_title)
        mTextDescription = findViewById(R.id.text_detail_description)

        fillData()
    }

    fun fillData() {
        mTitle = intent.getStringExtra(ARG_TITLE) ?: "Unknown"
        mDescription = intent.getStringExtra(ARG_DESCRIPTION) ?: "Unknown Description"

        mTextTitle?.text = mTitle
        mTextDescription?.text = mDescription
    }
}
