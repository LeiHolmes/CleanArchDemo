package com.leiholmes.cleanarchdemo.ui;

import android.os.Bundle;

import com.leiholmes.cleanarchdemo.contract.BaseView;
import com.leiholmes.cleanarchdemo.presenter.BasePresenter;

/**
 * Description:   入口Activity
 * author         xulei
 * Date           2017/8/7 16:20
 */
public abstract class BaseActivity<T extends BasePresenter> extends BaseSimpleActivity implements BaseView {
    protected T mPresenter;

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {
        //初始化Presenter
        mPresenter = initPresenter();
        //给Presenter绑定View
        if (mPresenter != null) {
            mPresenter.attachView(this);
            mPresenter.onPresenterCreated();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter.onPresenterDestroy();
        }
    }

    protected abstract T initPresenter();
}
