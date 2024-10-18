package ThreadLifeCycle;

public class ThreadLifeCycleDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        producer.start();
        consumer.start();

    }
}

class Producer extends Thread{
    private SharedResource resource;

    public Producer(SharedResource resource){
        this.resource = resource;
    }

    @Override
    public void run(){
        for(int i=1;i<=5;i++){
            try {
                resource.Producer();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer extends Thread{

    private SharedResource resource;

    public Consumer(SharedResource resource){
        this.resource = resource;
    }

    @Override
    public void run(){
        for(int i=1;i<=5;i++){
            try {
                resource.Consumer();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class SharedResource{
    private boolean isAvailable = false;

    public synchronized void Producer() throws InterruptedException{
        while(isAvailable){
            wait();
        }

        isAvailable = true;
        System.out.println("Producer called");
        notify();
    }

    public synchronized void Consumer() throws InterruptedException{
        while(!isAvailable){
            wait();
        }
        isAvailable = false;
        System.out.println("Consumer called");
        notify();
    }
}
