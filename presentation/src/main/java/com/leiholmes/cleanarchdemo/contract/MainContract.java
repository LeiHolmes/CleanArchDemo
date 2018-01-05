package com.leiholmes.cleanarchdemo.contract;

import com.leiholmes.cleanarchdemo.presenter.BaseSimplePresenter;

/**
 * Description:
 * author         xulei
 * Date           2018/1/5
 */

public interface MainContract {
    interface View extends BaseView {
        void showTitle(String title);
    }

    interface Presenter extends BaseSimplePresenter<View> {
        void getTitle();
    }
}
