package loom;

public class ThreadFailure {

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            Thread thread = new Thread(()-> {
                computeValue();
            });

            thread.start();
        }
    }

    private static void computeValue() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
