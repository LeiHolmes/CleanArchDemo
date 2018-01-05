package com.leiholmes.data.repository;

import com.leiholmes.domain.entity.User;
import com.leiholmes.domain.repository.Repository;

import io.reactivex.Observable;

/**
 * Description:   提供用户数据的实现类
 * author         xulei
 * Date           2018/1/5
 */

public class GetUserRepository implements Repository<User> {
    @Override
    public Observable<User> getObservable() {
        return Observable.just(new User("LeiHolmes", "male", 24));
    }
}
