package com.leiholmes.cleanarchdemo.presenter;

import com.leiholmes.cleanarchdemo.contract.BaseView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Description:   基于RxJava的Presenter封装,控制订阅的生命周期
 * author         xulei
 * Date           2017/8/7
 */

public abstract class BasePresenter<T extends BaseView> implements BaseSimplePresenter<T> {
    protected T mView;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    /**
     * 解绑Presenter
     */
    @Override
    public void detachView() {
        this.mView = null;
    }
}
