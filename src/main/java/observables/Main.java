package observables;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        createObservableFromIterable();
//        createObservableUsingCreate();
        createObservableWithJust();


    }

    private static void createObservableUsingCreate() {
        Observable<Integer>  observable = Observable.just(1,2,3,4,5);
        observable.subscribe(item -> System.out.println(item));
    }

    private static void createObservableFromIterable() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Observable<Integer> observable = Observable.fromIterable(list);
        observable.subscribe(System.out::println);
    }

    private static void createObservableWithJust() {
        Observable<Integer> observable = Observable.create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(1);
            emitter.onNext(1);
            emitter.onNext(1);
            emitter.onNext(1);
            emitter.onNext(null);
            emitter.onComplete();
        });
        observable.subscribe(item -> System.out.println(item),
                error -> System.out.println("There was an error here:" + error.getLocalizedMessage()),
                () -> System.out.println("Completed"));
    }
}
