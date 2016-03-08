package com.antonionicolaspina.databindingbase.domain.interactor;

import com.antonionicolaspina.databindingbase.domain.executor.PostExecutionThread;
import com.antonionicolaspina.databindingbase.domain.executor.ThreadExecutor;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public abstract class UseCase {

  private final ThreadExecutor threadExecutor;
  private final PostExecutionThread postExecutionThread;

  private Subscription subscription = Subscriptions.empty();

  protected UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
    this.threadExecutor = threadExecutor;
    this.postExecutionThread = postExecutionThread;
  }

  protected abstract Observable buildUseCaseObservable(Object ... params);

  public void execute(final Subscriber useCaseSubscriber, Object ... params) {
    this.subscription = this.buildUseCaseObservable(params)
            .doOnError(new Action1<Throwable>() {
              @Override
              public void call(Throwable throwable) {
                useCaseSubscriber.onError(throwable);
              }
            })
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.getScheduler())
            .subscribe(useCaseSubscriber);
  }

  public void unsubscribe() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }
}
