public class DeadlockSimulation {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {

        // Thread 1 locks lock1 first, then tries to lock lock2
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Locked lock1");

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
            }

                System.out.println("Thread 1: Trying to lock lock2");
                synchronized (lock2) {
                    System.out.println("Thread 1: Locked lock2");
                }

        });

        // Thread 2 locks lock2 first, then tries to lock lock1
        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Locked lock2");

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }

                System.out.println("Thread 2: Trying to lock lock1");
            }
                synchronized (lock1) {
                    System.out.println("Thread 2: Locked lock1");
                }

        });

        t1.start();
        t2.start();
    }
}
