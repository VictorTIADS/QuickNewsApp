package com.vtools.quicknews.view.activities

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso
import com.vtools.quicknews.R
import com.vtools.quicknews.model.Article
import com.vtools.quicknews.util.convertMonthToWord
import kotlinx.android.synthetic.main.activity_news_details.*
import kotlinx.android.synthetic.main.content_news_details.*
import kotlinx.android.synthetic.main.toolbar_layout.*
import org.jetbrains.anko.sdk27.coroutines.onScrollChange
import org.jetbrains.anko.toast
import java.text.SimpleDateFormat
import java.time.MonthDay

class NewsDetailsActivity : AppCompatActivity() {

    lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        mToolbar = toolbar_normal
        mToolbar.navigationIcon = ContextCompat.getDrawable(this,R.drawable.ic_arrow_back)
        mToolbar.title = ""
        setSupportActionBar(mToolbar)

        val article = intent.getParcelableExtra<Article>("article")

        detail_title.text = article.title
        detail_description.text = article.description
        detail_content.text = article.content
        Picasso.get().load(article.urlToImage).centerCrop().resize(1500,1500).into(detail_image)
        detail_source_name.text = article.source?.name.orEmpty()


        val year  = article.publishedAt?.slice(0.rangeTo(3))
        val monthDay = article.publishedAt?.slice(5.rangeTo(6))
        val day = article.publishedAt?.slice(8.rangeTo(9))
        detail_date.text = "$day ${convertMonthToWord(monthDay!!)} $year "
        detail_web.setOnClickListener {
            val intentWeb = Intent(Intent.ACTION_VIEW)
            intentWeb.data = Uri.parse(article.url)
            this.startActivity(intentWeb)
        }

        detail_webview.loadUrl(article.url)
    }




}
