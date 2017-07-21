
public class Q2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new PrintPrime());
        Thread t2=new Thread(new PrintNonPrime());
        t1.start();
        t1.join() ;
        t2.start();
        t2.join();
    }

}
class PrintPrime implements Runnable{
    @Override
    public void run() {
       int j;
        int n;
        for (int i = 2; i <= 20; i++) {

            Boolean flag=true;
            j=2;
            n=i/2;

            while ( j<n+1) {
                if (i!=j && i%j == 0 ) {flag=false;}
                j++;
            }
            if(flag)
                System.out.print(i+" ");

        }
        System.out.println();
    }
}
class PrintNonPrime implements Runnable{
    @Override
    public void run() {
        int j;
        int n;

        for (int i = 2; i <= 20; i++) {

            Boolean flag=true;
            j=2;
            n=i/2;

            while ( j<n+1) {
                if (i!=j && i%j == 0 ) {flag=false;}
                j++;
            }
            if(!flag)
                System.out.print(i+" ");
        }
        System.out.println();
    }

}