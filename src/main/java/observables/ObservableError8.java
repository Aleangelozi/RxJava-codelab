package observables;

import io.reactivex.Observable;

public class ObservableError8 {
    public static void main(String[] args) {
//        throwException();
        throwExceptionUsingCallable();
    }


    private static void throwExceptionUsingCallable() {

        // It always creates a new error instance
        Observable observable = Observable.error(() -> {
            System.out.println("New Exception Created");
            return new Exception("An Exception");
        });
        observable.subscribe(System.out::println, error -> System.out.println("Error 1: " + error.hashCode()));
        observable.subscribe(System.out::println, error -> System.out.println("Error 2: " + error.hashCode()));
    }

    private static void throwException() {

        // It only creates one error instance
        Observable observable = Observable.error(new Exception("An Exception"));
        observable.subscribe(System.out::println, error -> System.out.println("Error 1: " + error.hashCode()));
        observable.subscribe(System.out::println, error -> System.out.println("Error 2: " + error.hashCode()));
    }
}
