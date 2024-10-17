public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        MyThread myThread = new MyThread();
    }

    public static class MyThread{

        Thread1 th1 = new Thread1();
        Thread2 th2 = new Thread2();

        public MyThread(){
            Thread t1 = new Thread(th1);
            t1.start();

            Thread t2 = new Thread(th2);
            t2.start();
        }

    }

    public static class Thread1 implements Runnable{

        @Override
        public void run(){
            for(int i=1;i<=10;i++){
                System.out.println("thread1 ->" + i);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static class Thread2 implements Runnable{
        @Override
        public void run() {
            for(int i = 1 ;i <= 10 ;i++){
                System.out.println("thread2 ->" + i*2);
                System.out.println("---------------------");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}