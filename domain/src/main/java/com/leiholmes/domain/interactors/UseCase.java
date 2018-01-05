package com.leiholmes.domain.interactors;

import com.leiholmes.domain.executors.PostExecutor;
import com.leiholmes.domain.executors.ThreadExecutor;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Description:   用例基本抽象类
 * author         xulei
 * Date           2018/1/4
 */

public abstract class UseCase<T> {
    private CompositeDisposable compositeDisposable;
    private PostExecutor postExecutor;
    private ThreadExecutor threadExecutor;

    UseCase(PostExecutor postExecutor, ThreadExecutor threadExecutor) {
        this.postExecutor = postExecutor;
        this.threadExecutor = threadExecutor;
        compositeDisposable = new CompositeDisposable();
    }

    abstract Observable<T> buildUseCaseObservable();

    public void execute(DisposableObserver<T> observer) {
        Observable<T> observable = buildUseCaseObservable();
        observable.subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutor.getScheduler());
        addDisposable(observable.subscribeWith(observer));
    }

    private void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    public void clearDisposable() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }
}
