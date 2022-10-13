package com.pedro.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pedro.intents.Constants.URL
import com.pedro.intents.databinding.ActivityUrlBinding

class UrlActivity : AppCompatActivity() {

    private val aub: ActivityUrlBinding by lazy {
        ActivityUrlBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(aub.root)
        supportActionBar?.subtitle = "UrlActivity"
        val urlAnterior = intent.getStringExtra(URL) ?: ""
        urlAnterior.takeIf { it.isNotEmpty() }.also {
            aub.urlEt.setText(it)
        }

        aub.entrarUrlBt.setOnClickListener {
            val retornoIntent: Intent = Intent()
            retornoIntent.putExtra(URL, aub.urlEt.text.toString())
            setResult(RESULT_OK, retornoIntent)
            finish()
        }
    }
}