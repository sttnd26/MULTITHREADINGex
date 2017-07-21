
public class Q1 {

    public static void main(String[] args) {
        Thread t1=new Thread(new PrintOdd());
        Thread t2=new Thread(new PrintEven());
        t1.start();
        t2.start();
    }

}
class PrintOdd implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 19; i = i + 2) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
class PrintEven implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <= 20; i = i + 2) {
            System.out.print(i+" ");
        }
    }
}