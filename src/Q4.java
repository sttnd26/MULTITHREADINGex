
public class Q4 {
}
class ReverseHello{
    public static void main(String[] args) {

            HelloThread h1=new HelloThread();
            HelloThread h2=new HelloThread();
            HelloThread h3=new HelloThread();
            HelloThread h4=new HelloThread();
            HelloThread h5=new HelloThread();
            HelloThread h6=new HelloThread();
            HelloThread h7=new HelloThread();
            HelloThread h8=new HelloThread();
            HelloThread h9=new HelloThread();
            HelloThread h10=new HelloThread();

            h1.setThread(h2);
            h2.setThread(h3);
            h3.setThread(h4);
            h4.setThread(h5);
            h5.setThread(h6);
            h6.setThread(h7);
            h7.setThread(h8);
            h8.setThread(h9);
            h9.setThread(h10);

            Thread t1=new Thread(h1);

            t1.start();



    }
}
class HelloThread implements Runnable{

    HelloThread thread;

    @Override
    public void run() {
        Thread thread=new Thread(this.thread);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello from "+Thread.currentThread().getName()+"!");
    }

    public void setThread(HelloThread thread) {
        this.thread = thread;
    }
}