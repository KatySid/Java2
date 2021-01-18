package Lesson5;

public class MyThread {

    private static void putNewValue (float[] arr, int shift){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i+shift) / 5) * Math.cos(0.2f + (i+shift) / 5) * Math.cos(0.4f + (i+shift) / 2));
        }
    }

    public static void putNewValue (float[] arr){
        putNewValue(arr, 0);
    }
    public static void putNewValueThread (float[] arr){
        putNewValueThread( arr, 1);
    }

    public static void putNewValueThread(float[] arr, int threadNumber){
      for (int i = 0; i < arr.length; i++) {
            arr[i] = 1f;
      }

      int step = arr.length/threadNumber;
      int k = threadNumber - 1;
      int ost = arr.length%step;
      float [][] array = new float [arr.length/step][];
      for (int i = 0; i < k; i++) {
            array[i]=new float[step];
            System.arraycopy(arr, i*step, array[i], 0, step);
      }

      array[k]=new float[step+ost];
      System.arraycopy(arr, k*step, array[k], 0, step+ost);

      Thread[] threads = new Thread[threadNumber];

      for (int i = 0; i < threadNumber; i++) {
            int finalI = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    MyThread.putNewValue(array[finalI], finalI*step);
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < threadNumber; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < k; i++) {
            System.arraycopy(array[i], 0, arr, i*step, step);
        }

        System.arraycopy(array[k], 0, arr, k*step, step+ost);
    }

}

