package com.github.junyu.kotlin.baserx

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2017/11/26 22:49
 */
class RxManager {
    private var compositeDisposable: CompositeDisposable? = null

    fun add(disposable: Disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable!!.add(disposable)
    }

    fun clear() {
        if (compositeDisposable != null) {
            compositeDisposable!!.clear()
        }
    }
}
