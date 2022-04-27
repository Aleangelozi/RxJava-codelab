import io.reactivex.Observable;

public class ObservableFromCallable12 {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.fromCallable(() ->{
            System.out.println("Calling Method");
                return getNumber();
        });
        observable.subscribe(System.out::println, error -> System.out.println("An Exception occurred." +
                error.getLocalizedMessage()));

    }

    private static int getNumber() {
        System.out.println("Generating Value");
        return 1 /0;
    }
}
