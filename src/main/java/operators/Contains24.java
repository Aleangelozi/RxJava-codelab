package operators;

import io.reactivex.Observable;

public class Contains24 {
    public static void main(String[] args) {
        //containsWithPrimitive();
        containsWithNonPrimitive();
    }

    private static void containsWithPrimitive() {
        Observable.just(1,2,3,4,5)
                .contains(10)
                .subscribe(System.out::println);
    }

    private static void containsWithNonPrimitive() {
        User user = new User("Alessandro");
        Observable.just(user)
                .contains(user)
                .subscribe(System.out::println);
    }

    private static class User {
        String name;
        User(String name) {
            this.name = name;
        }
    }
}
