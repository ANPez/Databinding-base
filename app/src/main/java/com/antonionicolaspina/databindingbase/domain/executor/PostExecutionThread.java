package com.antonionicolaspina.databindingbase.domain.executor;

import rx.Scheduler;

public interface PostExecutionThread {
  Scheduler getScheduler();
}
