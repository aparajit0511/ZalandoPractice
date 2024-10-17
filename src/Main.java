import java.security.cert.CertificateParsingException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

//        Mythread mythread = new Mythread();
        Singleton obj = Singleton.getInstance();
//        Singleton obj1 = Singleton.getInstance();
//        System.out.println(obj);

    }

    public static class Mythread{
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        Thread3 thread3 = new Thread3();
        public Mythread(){
            Thread t1 = new Thread(thread1);
            t1.start();

//            Thread t2 = new Thread(thread2);
//            t2.start();

            Thread t3 = new Thread(thread3);
            t3.start();
        }

    }

    public static class Thread1 implements Runnable{

        public void run(){

            try{
                for(int i=1;i<=5;i++){
                    System.out.println("My first name is Aparajit");
                    Thread.sleep(1000);
                }

            }
            catch(InterruptedException e){
                throw new RuntimeException(e);

            }
        }
        // Thread ends
    }

    public static class Thread3 extends Thread{
        public void run(){
            try{
                for(int i=1;i<=5;i++){
                    System.out.println("Print i"+ i);
                    Thread.sleep(1000);
                }
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }

    public static class Thread2 implements Runnable{
        public void run(){

            try{
                for(int i=1;i<=5;i++){
                    System.out.println("My last name is Chatterjee");
                    Thread.sleep(1000);
                }

            }
            catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }

        // Thread2 ends
    }

    public static class Singleton {
        private static  Singleton obj = new Singleton();

        private Singleton() {
            System.out.println("Singleton was called");
        }

        public static Singleton getInstance() {
            return obj;
        }
    }

    // main
}