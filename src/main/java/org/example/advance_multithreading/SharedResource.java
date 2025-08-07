package org.example.advance_multithreading;

public class SharedResource {

    boolean  isItemPresent = false;

    public synchronized void addItem(){
        isItemPresent = true;

        System.out.println("Producer thread calling the notify method");
        notifyAll();
    }

    public synchronized void consumeItem(){
        try {
            System.out.println("Consumer thread inside consumeItem method");
            while(!isItemPresent){
                System.out.println("Consumer thread is waiting ");
                wait(); //reases the all the Monitor Lock
                System.out.println("Consumer thread is completed ");
            }

        }catch (Exception e){
            System.out.println(e);
        }

        isItemPresent = false;
    }

}
