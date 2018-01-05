package com.leiholmes.domain.executors;


import io.reactivex.Scheduler;

public interface PostExecutor {
    Scheduler getScheduler();
}
