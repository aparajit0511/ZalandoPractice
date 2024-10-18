package ThreadLCDemo;

class SharedResource {
    private boolean isAvailable = false;

    public synchronized void produce() throws InterruptedException {
        while (isAvailable) {
            wait(); // Wait if resource is already available
        }
        // Produce the resource
        System.out.println("Producer:Control comes here "+ isAvailable);
        isAvailable = true;
        System.out.println("Resource produced");
        notifyAll(); // Notify consumers that resource is available
    }

    public synchronized void consume() throws InterruptedException {
        while (!isAvailable) {
            wait(); // Wait until resource is produced
        }
        // Consume the resource
        System.out.println("Consumer:Control comes here "+ isAvailable);
        isAvailable = false;
        System.out.println("Resource consumed");
        notifyAll(); // Notify producers that resource is consumed
    }
}

class Producer extends Thread {
    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            for (int  i =1 ; i<= 5; i++) {
                resource.produce();
                Thread.sleep(1000); // Simulate time to produce
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {
    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            for (int  i =1 ; i<= 5; i++) {
                resource.consume();
                Thread.sleep(1000); // Simulate time to consume
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadCommunicationDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        producer.start();
        consumer.start();
    }
}
