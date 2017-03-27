package ru.spb.herzen.three;

import java.util.Random;

public class MainThree extends Thread {

    private Account account = new Account(1000000);
    private Random random = new Random();

    public static void main(String[] args) {
        MainThree r = new MainThree();
        Thread first = new Thread(r);
        Thread second = new Thread(r);
        first.setName("one");
        second.setName("two");
        first.start();
        second.start();
    }
    @Override
    public void run() {
        while (true) {
            takeMoney(random.nextInt(100000));
            if (account.getBalance() <= 0) {
                System.out.println("Try to get money from empty account! You have: " + account.getBalance());
                break;
            }
        }
    }

    private synchronized void takeMoney(int money) {
        if (account.getBalance() >= money) {
            System.out.println(Thread.currentThread().getName() + " have " + account.getBalance() + " and going to get money");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.getMoney(money);
            System.out.println(Thread.currentThread().getName() + " successful getting money");
        } else {
            System.out.println("You try to take more then have. You have: " +	account.getBalance());
        }
    }
}
