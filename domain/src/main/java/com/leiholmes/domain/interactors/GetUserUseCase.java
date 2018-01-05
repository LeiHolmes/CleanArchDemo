package com.leiholmes.domain.interactors;

import com.leiholmes.domain.entity.User;
import com.leiholmes.domain.executors.PostExecutor;
import com.leiholmes.domain.executors.ThreadExecutor;
import com.leiholmes.domain.repository.Repository;

import io.reactivex.Observable;

/**
 * Description:   获取用户数据的用例实现类
 * author         xulei
 * Date           2018/1/5
 */

public class GetUserUseCase extends UseCase<User> {
    Repository<User> repository;

    public GetUserUseCase(ThreadExecutor threadExecutor, PostExecutor postExecutor, Repository<User> repository) {
        super(postExecutor, threadExecutor);
        this.repository = repository;
    }

    @Override
    Observable<User> buildUseCaseObservable() {
        return repository.getObservable();
    }
}
