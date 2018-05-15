package com.yipl.labelstep.di
import com.yipl.labelstep.network.PullSyncHelper
import com.yipl.labelstep.network.PullSyncHelperModule
import com.yipl.labelstep.ui.MainActivity
import com.yipl.labelstep.ui.di.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity


}