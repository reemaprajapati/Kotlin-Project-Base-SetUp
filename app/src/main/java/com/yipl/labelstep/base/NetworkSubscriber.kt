package com.yipl.labelstep.base

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

open class NetworkSubscriber<T> : Subscriber<T>{
    override fun onSubscribe(s: Subscription?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onComplete() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onNext(t: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(t: Throwable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    open fun onCompleted() {}
}