package androidkotlin.fanjavaid.com.androidkotlin01.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidkotlin.fanjavaid.com.androidkotlin01.R

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var mSearchKeyword: EditText? = null
    var mButtonSearch: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSearchKeyword = findViewById(R.id.text_search_keyword)
        mButtonSearch = findViewById(R.id.button_search)

        mButtonSearch?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (mSearchKeyword?.text?.trim()?.length == 0) {
            mSearchKeyword?.setError("Keyword can't empty!", null)
        } else {
//            Toast.makeText(this, mSearchKeyword?.text, Toast.LENGTH_SHORT).show()

            val resultIntent = Intent(this, ResultActivity::class.java)
            startActivity(resultIntent)
        }
    }
}
