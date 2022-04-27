package observables;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import static java.lang.Thread.sleep;


public class ColdHotConnectableObservables {

    public static void main(String[] args) {
//        createColdObservable();
        createHotObservable();
        createHotConnectableObservable();
    }

    private static void createHotConnectableObservable() {
        ConnectableObservable<Integer> observable = Observable.just(1,2,3,4,5).publish();

        observable.subscribe(item -> System.out.println("Observer 1: " + item));

        // Connectable observers don't start to emit after a subscription to an Observable
        observable.subscribe();

        // Connectable observers start to emit after connecting to an Observable
        observable.connect();

        // It can be called Hot Observer
        observable.subscribe(item -> System.out.println("Observer 2: " +  item));


    }

    private static void createHotObservable() {
    }

    private static void createColdObservable() {
        Observable<Integer> observable = Observable.just(1,2,3,4,5);

        observable.subscribe(item -> System.out.println("Observer 1: " + item));

        pause(3000);

        observable.subscribe(item -> System.out.println("Observer 2: " +  item));
    }

    private static void pause(int duration) {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
