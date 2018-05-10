package com.yipl.labelstep.ui.di

import com.yipl.labelstep.data.Repository
import com.yipl.labelstep.ui.MainActivityViewModel
import com.yipl.labelstep.util.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideViewModel(repository: Repository, schedulerProvider: SchedulerProvider) = MainActivityViewModel(repository, schedulerProvider)
}
