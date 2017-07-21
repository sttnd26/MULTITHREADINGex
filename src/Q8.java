import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Q8
{
    public static BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);

    public static void main(String[] args) {
        Publisher1 publisher=new Publisher1();
        Subscriber1 subscriber=new Subscriber1();
        Publisher1 publisher1=new Publisher1();
        Subscriber1 subscriber1=new Subscriber1();

        Thread thread=new Thread(subscriber);
        Thread thread1=new Thread(publisher);
        Thread thread2=new Thread(subscriber1);
        Thread thread3=new Thread(publisher1);

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Subscriber1 implements Runnable {
    public void subscriber() throws InterruptedException {
        for(int i = 0; i < 5; i++){
           String message="";
                    message= Q8.queue.take();

                    System.out.println(i+" Message subscribed."+message);
        }



    }

    @Override
    public void run() {
        try {
            subscriber();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Publisher1 implements Runnable{

    public void publisher() throws InterruptedException {
        for(int i = 0; i < 5; i++){

                    Q8.queue.put(UUID.randomUUID().toString());
                    String msg=UUID.randomUUID().toString();
                    System.out.println(i+" Message published."+msg);
        }
    }

    @Override
    public void run() {
        try {
            publisher();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}