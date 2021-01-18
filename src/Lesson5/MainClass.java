package Lesson5;

public class MainClass {
    private static final int size = 10000000;
    private static final int threadNumbers = 2; // задается число потоков

    public static void main(String[] args) {

        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        long time1 = System.currentTimeMillis();
        MyThread.putNewValue(arr);
        long timeFinish1 = System.currentTimeMillis() - time1;
        System.out.println("время выполнения одним потоком методом putNewValue " + timeFinish1 + " millis");

        long time2 = System.currentTimeMillis();
        MyThread.putNewValueThread(arr);
        long timeFinish2 = System.currentTimeMillis() - time2;
        System.out.println("время выполнения одним потоком  методом putNewValueThread " + timeFinish2 + " millis");

        long time3 = System.currentTimeMillis();
        MyThread.putNewValueThread(arr, threadNumbers);
        long timeFinish3 = System.currentTimeMillis() - time3;
        System.out.println("время выполнения " + threadNumbers + " потоками " + timeFinish3 + " millis");

        long time4 = System.currentTimeMillis();
        MyThread.putNewValueThread(arr, 3);
        long timeFinish4 = System.currentTimeMillis() - time4;
        System.out.println("время выполнения " + 3 + " потоками " + timeFinish4 + " millis");

        }
    }
