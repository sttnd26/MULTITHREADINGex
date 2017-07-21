
public class Q9 {
    public static void main(String[] args) {
        Print p1=new Print(1);
        Print p2=new Print(2);
        Print p3=new Print(3);
        Print p4=new Print(4);
        Thread thread1=new Thread(p1);
        thread1.start();
        Thread thread2=new Thread(p2);
        thread2.start();
        Thread thread3=new Thread(p3);
        thread3.start();
        Thread thread4=new Thread(p4);
        thread4.start();

    }
}
class Print implements Runnable{

    int startNum;
    @Override
    public void run() {
        print();
    }

    public Print(int startNum) {
        this.startNum = startNum;
    }

    public void print(){
        Thread INSTANCE=Thread.currentThread();

        for (int i = startNum; i <=10 ; i=i+4) {
            System.out.println(INSTANCE.getName()+" : "+i);
        }
    }
}
