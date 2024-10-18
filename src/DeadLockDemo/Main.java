package DeadLockDemo;

public class Main {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    System.out.println("Lock1 is locked by Thread1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("thread1 trying to lock Lock2");
                } // close lock1 here to prevent deadlock
                    synchronized (lock2) {
                        System.out.println("Lock2 is locked Thread1");
                    }
                // close lock1 here to create deadlock

            }
        });

        Thread t2 = new Thread(
                ()->{
                    synchronized (lock2) {
                        System.out.println("Lock2 is locked by Thread2");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Thread2 is trying to lock lock1");
                    }// close lock2 here to prevent deadlock
                        synchronized (lock1) {
                            System.out.println("Lock1 is locked by Thread2");
                        }
                    //  close lock2 here to create deadlock
                }
        );

        t1.start();
        t2.start();
    }
}
