package com.leiholmes.domain.repository;


import io.reactivex.Observable;

/**
 * Description:   提供数据的基本接口
 * author         xulei
 * Date           2018/1/5
 */

public interface Repository<T> {
    Observable<T> getObservable();
}
