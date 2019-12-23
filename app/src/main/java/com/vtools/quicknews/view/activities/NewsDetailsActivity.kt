package com.vtools.quicknews.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso
import com.vtools.quicknews.R
import com.vtools.quicknews.model.Article
import kotlinx.android.synthetic.main.activity_news_details.*
import kotlinx.android.synthetic.main.content_news_details.*
import kotlinx.android.synthetic.main.toolbar_layout.*
import org.jetbrains.anko.toast
import java.text.SimpleDateFormat

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


        detail_date.text =  article.publishedAt
    }


}
