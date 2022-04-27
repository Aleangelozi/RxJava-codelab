package observables;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ObservableInterval13 {
    public static void main(String[] args) {
        Observable observable = Observable.interval(1, TimeUnit.SECONDS);
        observable.subscribe(item -> System.out.println("Observer 1: " + item));
        pause(2000);
        observable.subscribe(item -> System.out.println("Observer 2: " + item));
        pause(3000);
    }

    private static void pause(int duration) {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
