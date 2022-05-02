import com.google.common.collect.Lists;
import io.reactivex.Observable;
import io.reactivex.schedulers.TestScheduler;
import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class FlatMapVsConcatMap {

    @Test
    public void flatMap() throws Exception {
        final List<String> items = Lists.newArrayList("a", "b", "c", "d", "e", "f");

        final TestScheduler scheduler = new TestScheduler();

        Observable.fromIterable(items)
                .flatMap( s -> {
                    final int delay = new Random().nextInt(10);
                    return Observable.just(s + "x")
                            .delay(delay, TimeUnit.SECONDS, scheduler);
                })
                .toList()
                .doOnSuccess(System.out::println)
                .subscribe();

        scheduler.advanceTimeBy(1, TimeUnit.MINUTES);
    }

    @Test
    public void concatMap() throws Exception {
        final List<String> items = Lists.newArrayList("a", "b", "c", "d", "e", "f");

        final TestScheduler scheduler = new TestScheduler();

        Observable.fromIterable(items)
                .concatMap( s -> {
                    final int delay = new Random().nextInt(10);
                    return Observable.just(s + "x")
                            .delay(delay, TimeUnit.SECONDS, scheduler);
                })
                .toList()
                .doOnSuccess(System.out::println)
                .subscribe();

        scheduler.advanceTimeBy(1, TimeUnit.MINUTES);
    }
}
