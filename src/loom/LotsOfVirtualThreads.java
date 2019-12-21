package loom;

public class LotsOfVirtualThreads {

    public static void main(String[] args) throws InterruptedException {
        int c = 0;
        for (int i = 0; i < 1000000; i++) {
            System.out.println(++c);
            Thread.builder().virtual().task(()-> {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        Thread.sleep(10000L);
    }
}
