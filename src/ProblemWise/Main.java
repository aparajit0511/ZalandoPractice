package ProblemWise;


// Race condition prevention using synchronized
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run(){
                Singleton t1Singleton = Singleton.getInstance();
            }
        });

        Thread t2 = new Thread(new Runnable(){
           @Override
           public void run(){
               Singleton t2Singleton = Singleton.getInstance();
           }
        });
        t1.start();
        t2.start();
    } // main

    public static class Singleton{
        private static Singleton instance;

        private Singleton(){
            System.out.println("Instance is created");
        }

        public synchronized static Singleton getInstance(){
            // without this it will turn into a race conditon
            if (instance == null){
                instance = new Singleton();
            }
//            instance = new Singleton();
            return instance;
        }
    }
}


