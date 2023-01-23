package org.example;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        Thread thread0 = new Thread(() -> {
            consumer c0 = new consumer(0);
        });

        Thread thread1 = new Thread(() -> {
            consumer c1 = new consumer(1);
        });

        Thread thread2 = new Thread(() -> {
            consumer c2 = new consumer(2);
        });

        Thread thread3 = new Thread(() -> {
            consumer c3 = new consumer(3);
        });

        Thread thread4 = new Thread(() -> {
            consumer c4 = new consumer(4);
        });

        Thread thread5 = new Thread(() -> {
            consumer c5 = new consumer(5);
        });

        Thread thread6 = new Thread(() -> {
            consumer c6 = new consumer(6);
        });

        Thread thread7 = new Thread(() -> {
            consumer c7 = new consumer(7);
        });

        Thread thread8 = new Thread(() -> {
            consumer c8 = new consumer(8);
        });

        Thread thread9 = new Thread(() -> {
            consumer c9 = new consumer(9);
        });

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();


    }
}
