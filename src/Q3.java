
public class Q3 {
    public static void main(String[] args) throws InterruptedException {

        Thread t1=new Thread(new Pattern());
        Thread t2=new Thread(new Pattern());
        Thread t3=new Thread(new Pattern());

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
    }
}
class Pattern implements Runnable{
    @Override
    public void run() {
        printPattern();
    }

    public synchronized void printPattern(){
        for (int i = 1; i <4 ; i++) {
            System.out.print(i+" ");
        }
    }
}
