import io.reactivex.Observable;

import static java.lang.Thread.sleep;

public class EmptyVsNeverObservable9 {

    public static void main(String[] args) {
        //createObservableUsingEmpty();
        createObservableUsingNever();
    }

    private static void createObservableUsingEmpty() {
        Observable observable = Observable.empty();

        observable.subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
    }

    private static void createObservableUsingNever() {
        Observable observable = Observable.never();

        observable.subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));

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
