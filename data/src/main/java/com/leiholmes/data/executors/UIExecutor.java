package com.leiholmes.data.executors;

import com.leiholmes.domain.executors.PostExecutor;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Description:
 * author         xulei
 * Date           2018/1/5
 */

public class UIExecutor implements PostExecutor {
    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
