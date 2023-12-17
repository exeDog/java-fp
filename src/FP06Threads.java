public class FP06Threads {

    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
        };

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i++) {
                    System.out.println("Number: " + i + " - " + Thread.currentThread().getName());
                    Thread.currentThread().threadId();
                }
                System.out.println("Thread: " + Thread.currentThread().getName());
            }
        };

        Thread thread = new Thread(r);
        thread.start();

        Thread thread2 = new Thread(r);
        thread2.start();

        Thread thread3 = new Thread(r);
        thread3.start();
    }
}
