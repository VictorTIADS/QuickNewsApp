package com.vtools.quicknews.di

import com.vtools.quicknews.network.RetrofitConfig
import com.vtools.quicknews.repository.ServiceRequestRepository
import com.vtools.quicknews.viewmodel.activities.MainViewModel
import com.vtools.quicknews.viewmodel.fragments.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodel = module {
    viewModel { MainViewModel(get()) }
    viewModel { HomeViewModel(get()) }

}
val network = module {
    single { ServiceRequestRepository() }
    single { RetrofitConfig()}
}