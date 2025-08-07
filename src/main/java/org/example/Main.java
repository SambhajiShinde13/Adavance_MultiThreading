package org.example;

import org.example.advance_multithreading.SharedResource;

public class Main {
    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Thread produceThread = new Thread(() -> {
          try {
              Thread.sleep(20000);
          }catch (Exception e){

          }
            sharedResource.addItem();
        });



        Thread consumerThread = new Thread(() -> {
            sharedResource.consumeItem();
        });

        produceThread.start();
        consumerThread.start();
    }
}