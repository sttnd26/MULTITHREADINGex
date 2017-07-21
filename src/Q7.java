import java.util.UUID;

public class Q7
{
    public static String message = "";

    public static void main(String[] args) {
        Publisher publisher=new Publisher();
        Subscriber subscriber=new Subscriber();
        Publisher publisher1=new Publisher();
        Subscriber subscriber1=new Subscriber();
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

class Subscriber implements Runnable {
        public void subscriber() {
        for(int i = 0; i < 5; i++){
            synchronized (this) {
                try {
                    while(Q7.message.equals("")){
                        this.wait();   // wait for publisher to publish
                    }
                    System.out.println(i+" Message subscribed."+Q7.message);
                    Q7.message="";
                    this.notify(); // notify publisher to publish
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run() {
        subscriber();
    }
}
class Publisher implements Runnable{

    public void publisher() {
        for(int i = 0; i < 5; i++){
            synchronized (this) {
                try {
                    while(!Q7.message.equals("")){
                        this.wait(); // wait for subscriber to consume
                    }
                    Q7.message= UUID.randomUUID().toString();
                    System.out.println(i+". Message published."+Q7.message);
                    this.notify();	// notify subscriber to consume
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run() {
        publisher();
    }
}