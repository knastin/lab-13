package herzen.ivt3;


public class App
{
    public static void main(String... args) {
        SyncCounterThread syncFirstThread = new SyncCounterThread();
        SyncCounterThread syncSecondThread = new SyncCounterThread();
        syncFirstThread.start();
        syncSecondThread.start();

        CounterThread firstThread = new CounterThread();
        CounterThread secondThread = new CounterThread();
        firstThread.start();
        secondThread.start();
    }
}

class CounterThread extends Thread {
    public void run(){
        for(Integer i=1; i<=100; i++){
            System.out.println(i + " from " + this.getName());
        }
    }
}

class SyncCounterThread extends Thread {
    synchronized public void run(){
        for(Integer i=1; i<=100; i++){
            System.out.println(i + " from " + this.getName());
        }
    }
}
