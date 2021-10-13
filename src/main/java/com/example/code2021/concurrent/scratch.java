package com.example.code2021.concurrent;

class SynchronizeClass {

    public int shareState;

    public static void main(String[] args) throws InterruptedException {
        SynchronizeClass sample = new SynchronizeClass();
        Thread threadA = new Thread(sample::increase);
        Thread threadB = new Thread(sample::increase);
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
    }

    public void increase() {
        while (shareState < 100000) {
            int former = shareState++;
            int latter = shareState;
            if (former != latter - 1) {
                System.out.print("Observed data race, former is " + former + ", " + "latter is " + latter);
            }
        }
    }


}