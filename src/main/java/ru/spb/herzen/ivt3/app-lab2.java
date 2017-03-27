package ru.spb.herzen.ivt3;


public class App
{
    public static void main( String[] args )
    {
        FirstThread firstThread = new FirstThread(new SecondThread());
        firstThread.start();
    }
}
       class FirstThread extends Thread {
    private SecondThread secondThread;
    public FirstThread(SecondThread secondThread) {
        this.secondThread = secondThread;
        this.secondThread.start();
    }
    @Override
    public void run() {
        while(this.secondThread.isWorks()) {
            System.out.println("SectondThread is alive!");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

class SecondThread extends Thread {
    private boolean completed;

    public SecondThread() {
        this.completed = true;
    }
    public boolean isWorks() {
        return this.completed;
    }
    public void endWorks() {
        this.completed = false;
    }
    @Override
    public void run()
    {
        int rnd = 100000000 + (int) (Math.random() * ((999999999 - 100000000) + 1));
        boolean prime = false;
        for (int i = 1; i < Math.sqrt(rnd); i++) {
            if (rnd % i == 0) {
                prime = true;
            }
            try {
                Thread.sleep(5);
            } catch (Exception e) {

            }
        }
        if(prime)
            System.out.println(rnd + " является простым числом.");
        else
            System.out.println(rnd + " является сложным числом.");
        this.endWorks();
    }
}

