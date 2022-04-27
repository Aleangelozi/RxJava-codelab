import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class SingleMaybeCompletable14 {
    public static void main(String[] args) {
        createSingle();
        addSeparationLine();
        createMaybe();
        addSeparationLine();
        createCompletable();
    }

    private static void createSingle() {
        Single.just("Hello World").subscribe(System.out::println);
    }

    private static void createMaybe() {
        Maybe.empty().subscribe(new MaybeObserver<Object>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(Object o) {
                System.out.println(o);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("Done");

            }
        });
    }

    private static void createCompletable() {
        Completable.fromSingle(Single.just("Hello World")).subscribe(() -> System.out.println("Done"));
    }

    private static void addSeparationLine() {
        System.out.println(" ");
    }
}
