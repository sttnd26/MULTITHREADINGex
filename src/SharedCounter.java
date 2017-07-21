import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedCounter {
    public static Integer sharedCounter=0;
    public static Integer temp=0;

    public static boolean lockAvailable = true;

    public static void main(String[] args) throws InterruptedException {
       /* SharedVariableThread sharedVariableThread=new SharedVariableThread();
        Thread thread=new Thread(sharedVariableThread);
        thread.start();

        SharedVariableThread sharedVariableThread1=new SharedVariableThread();
        Thread thread1=new Thread(sharedVariableThread1);
        thread1.start();

        SharedVariableThread sharedVariableThread2=new SharedVariableThread();
        Thread thread2=new Thread(sharedVariableThread2);
        thread2.start();

        SharedVariableThread sharedVariableThread3=new SharedVariableThread();
        Thread thread3=new Thread(sharedVariableThread3);
        thread3.start();

        SharedVariableThread sharedVariableThread4=new SharedVariableThread();
        Thread thread4=new Thread(sharedVariableThread4);
        thread4.start();

        thread.join();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();*/

        ExecutorService service = Executors.newFixedThreadPool(2);

        for(int i=0;i<5;i++){
            Runnable t = new SharedVariableThread();
            service.execute(t);
        }
        service.shutdown();

        while(!service.isTerminated()){

        }

        System.out.println("Counter: "+SharedCounter.sharedCounter);

    }
}
class SharedVariableThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            increment();
        }
        System.out.println(Thread.currentThread().getName()+" : "+SharedCounter.sharedCounter);
    }
     void increment(){
        synchronized (SharedCounter.temp){
        while(SharedCounter.lockAvailable!=true){
            try {
                SharedCounter.temp.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        SharedCounter.lockAvailable = false;

        SharedCounter.sharedCounter=SharedCounter.sharedCounter+1;
        SharedCounter.lockAvailable = true;
        SharedCounter.temp.notify();

      }

    }

}
