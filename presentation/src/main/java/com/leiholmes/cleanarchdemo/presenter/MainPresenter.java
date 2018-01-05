package com.leiholmes.cleanarchdemo.presenter;

import com.leiholmes.cleanarchdemo.contract.MainContract;
import com.leiholmes.data.executors.JobExecutor;
import com.leiholmes.data.executors.UIExecutor;
import com.leiholmes.data.repository.GetUserRepository;
import com.leiholmes.domain.entity.User;
import com.leiholmes.domain.interactors.GetUserUseCase;

import io.reactivex.observers.DisposableObserver;

/**
 * Description:
 * author         xulei
 * Date           2018/1/5
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {
    GetUserUseCase getTitleUseCase;

    @Override
    public void onPresenterCreated() {
        getTitleUseCase = new GetUserUseCase(new JobExecutor(), new UIExecutor(), new GetUserRepository());
    }

    @Override
    public void onPresenterDestroy() {

    }

    @Override
    public void getTitle() {
        getTitleUseCase.execute(new DisposableObserver<User>() {
            @Override
            public void onNext(User user) {
                mView.showTitle(user.getName());
            }

            @Override
            public void onError(Throwable e) {
                mView.showToast("请求错误");
            }

            @Override
            public void onComplete() {
                mView.showToast("请求完成");
            }
        });
    }
}
