import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;

import java.util.concurrent.TimeUnit;

public class DisposableCompositeDisposable {
    public static void main(String[] args) {
//        handleDisposable();
//        handleDisposableInObserver();
//        handleDisposableOutsideObserver();
        compositeDisposable();

    }

    private static void handleDisposable() {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable = observable.subscribe(System.out::println);

        Utilities.pause(3000);
        disposable.dispose();
        Utilities.pause(3000);

    }

    private static void handleDisposableInObserver() {
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        Observer<Integer> observer = new Observer<Integer>(){

            Disposable disposable;
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(Integer integer) {
                if (integer == 3) {
                    disposable.dispose();
                }
                System.out.println(integer);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);
    }

    private static void handleDisposableOutsideObserver() {
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        ResourceObserver<Integer> observer = new ResourceObserver<Integer>(){

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        Disposable d = observable.subscribeWith(observer);
    }

    private static void compositeDisposable() {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable1 = observable.subscribe(item -> System.out.println("Observer 1: " + item));
        Disposable disposable2 = observable.subscribe(item -> System.out.println("Observer 2: " + item));
        compositeDisposable.addAll(disposable1, disposable2);
        Utilities.pause(3000);
//        disposable1.dispose();
//        disposable2.dispose();
        compositeDisposable.delete(disposable1);
        compositeDisposable.dispose();
        Utilities.pause(3000);
    }
}
