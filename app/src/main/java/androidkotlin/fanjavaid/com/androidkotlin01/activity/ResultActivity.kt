package androidkotlin.fanjavaid.com.androidkotlin01.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidkotlin.fanjavaid.com.androidkotlin01.R

class ResultActivity : AppCompatActivity(), SearchResultFragment.OnClickViewResultDetail {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
    }

    override fun onViewDetail(title: String?, description: String?) {
        val detailIntent = Intent(this, DetailActivity::class.java)
        detailIntent.putExtra(DetailActivity.ARG_TITLE, title)
        detailIntent.putExtra(DetailActivity.ARG_DESCRIPTION, description)

        startActivity(detailIntent)
    }
}
