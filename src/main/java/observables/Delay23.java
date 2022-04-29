package observables;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Delay23 {
    public static void main(String[] args) {
        //delay();
        delayError();
    }

    private static void delay() {
        Observable.just(1,2,3,4,5)
                .delay(3000, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);

        pause(5000);
    }

    private static void delayError() {
        Observable.error( new Exception("Error"))
                .delay(3, TimeUnit.SECONDS, true)
                .subscribe(System.out::println,
                        error -> System.out.println(error.getLocalizedMessage()),
                () -> System.out.println("Completed"));

        pause(5000);
    }

    public static void pause(int duration) {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
