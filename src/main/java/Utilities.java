import static java.lang.Thread.sleep;

public final class Utilities {

    // Private constructor to prevent instantiation
    private Utilities() {
        throw new UnsupportedOperationException();
    }

    public static void pause(int duration) {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
