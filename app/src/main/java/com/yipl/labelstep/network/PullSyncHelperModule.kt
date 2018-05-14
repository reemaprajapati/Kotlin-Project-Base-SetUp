package com.yipl.labelstep.network

import com.yipl.labelstep.data.Repository
import dagger.Module
import dagger.Provides

@Module
class PullSyncHelperModule {

    @Provides
    fun provideViewModel(repository: Repository) = PullSyncViewModel(repository)
}
