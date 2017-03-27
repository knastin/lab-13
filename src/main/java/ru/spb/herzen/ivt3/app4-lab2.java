package ru.spb.herzen.four;

class MyThread extends Thread{
    private final String objectOne;
    private final String objectTwo;

   MyThread(String objectOne, String objectTwo){
        this.objectOne=objectOne;
        this.objectTwo=objectTwo;
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (objectOne) {
            System.out.println(name + " lock "+objectOne);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (objectTwo) {
                System.out.println(name + " lock "+objectTwo);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(name + " unlock "+objectTwo);
        }
        System.out.println(name + " unlock "+objectOne);
        System.out.println(name + " complete");
    }
}
