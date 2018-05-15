package com.yipl.labelstep.network

import android.util.Log
import com.yipl.labelstep.base.NetworkSubscriber
import com.yipl.labelstep.data.AppPreferences
import com.yipl.labelstep.exception.NetworkConnectionException
import com.yipl.labelstep.ui.MainActivityViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import java.net.SocketException
import javax.inject.Inject


public class PullSyncHelper @Inject constructor(var appPreferences: AppPreferences, var activityViewModel: MainActivityViewModel) {


    public val TAG = "PullSyncHelper"
    val REQUEST_STANDARDS = 1
    val REQUEST_AUDITS = 2
    val REQUEST_SUPPLIERS = 3
    val REQUEST_WAGE_RATE = 4
    var syncSuccessStatus: Boolean = false
    var syncPosition: Int = Int.MIN_VALUE

    public fun fetchData(position: Int) {
//        syncSuccessStatus = true
//        syncPosition = if (position == Int.MIN_VALUE) {
//            1
//        } else position
        Log.d("Pull Sync Helper", "Fetch Data Called")
        Log.d("Pull", appPreferences.example)
        pullData(1)
    }

    fun pullData(position: Int) {
        when (position) {
            REQUEST_STANDARDS -> {
                activityViewModel.getStandards()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ SyncSubscriber() })

            }
//            else ->
//                return

        }
    }


    private inner class SyncSubscriber : NetworkSubscriber<Boolean>() {

        override fun onNext(t: Boolean) {
            super.onNext(t)
            Log.e(TAG, "Sync finished for: \t $syncPosition \tstatus: $t")
//            if ((!t)) syncSuccessStatus = false
//            syncPosition++
        }

        override fun onError(t: Throwable?) {
            super.onError(t)
            Log.e(TAG, "Sync error for: \t " + syncPosition + " \tstatus: " + false + " \nerror: " + t!!.message)
            if (t is NetworkConnectionException || t is SocketException) {
//                appPreferences.setDataFetchPosition(syncPosition)
//                pullData(++syncPosition)
            }
        }

        override fun onCompleted() {
            super.onCompleted()
            Log.e("Sync Complete", "Complete")
//            pullData(syncPosition)
        }
    }


}