package com.vtools.quicknews.view.fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.vtools.quicknews.R
import com.vtools.quicknews.`interface`.InterfaceRecyclerView
import com.vtools.quicknews.adapter.NewsAdapter
import com.vtools.quicknews.animation.FadeIn
import com.vtools.quicknews.animation.FadeOut
import com.vtools.quicknews.model.Article
import com.vtools.quicknews.model.BaseModel
import com.vtools.quicknews.model.Request
import com.vtools.quicknews.view.activities.NewsDetailsActivity
import com.vtools.quicknews.viewmodel.fragments.HomeViewModel
import kotlinx.android.synthetic.main.content_recycler_view.*
import kotlinx.android.synthetic.main.list_news_hint.*
import org.jetbrains.anko.support.v4.toast
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() ,InterfaceRecyclerView {

    private val viewModel : HomeViewModel by viewModel()
    lateinit var mAdapter: NewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getNews()
        mAdapter = NewsAdapter(requireContext(), Request("", 0, arrayListOf()),this)
        recycler_view.adapter = mAdapter
        recycler_view.layoutManager = LinearLayoutManager(requireContext())
        setObservable()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun setObservable() {
        viewModel.dataNews.observe(this, Observer {
            when (it.status) {
                BaseModel.Companion.STATUS.SUCCESS -> {
                    it.data?.let { it1 -> configureNewsAdapter(it1) }
                    controlViewState(BaseModel.Companion.STATUS.SUCCESS)

                }
                BaseModel.Companion.STATUS.ERROR -> {

                }
            }
        })
    }

    private fun controlViewState(state: BaseModel.Companion.STATUS) {
        when (state) {
            BaseModel.Companion.STATUS.SUCCESS -> {
                content_news.FadeIn()
                list_hint.FadeOut()
            }
            BaseModel.Companion.STATUS.ERROR -> {
                startSomeFragment(StateErrorFragment.newInstance())
            }
        }
    }

    private fun startSomeFragment(fragment: Fragment) {
        fragmentManager?.beginTransaction()
            ?.setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            ?.replace(R.id.main_content_principal, fragment)?.commit()
    }


    private fun configureNewsAdapter(request: Request) {
        mAdapter = NewsAdapter(requireContext(), request,this)
        recycler_view.adapter = mAdapter
        recycler_view.layoutManager = LinearLayoutManager(requireContext())
        mAdapter.notifyDataSetChanged()
    }


    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onItemNewsClick(article: Article) {
        val intentNewsDetail = Intent(requireContext(),NewsDetailsActivity::class.java)
        intentNewsDetail.putExtra("article",article)
        startActivity(intentNewsDetail)
    }


}
