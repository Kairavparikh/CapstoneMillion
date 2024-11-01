public class Main implements Runnable {
    private int sum = 0;//used to count each threads sum
    static long total = 0;//used to count the total of all the threads
    private int threadNum; //tracks which out of the 1000 thread we are on
    public Main(int threadNum) {//constructor to initialize thread and sum
        this.threadNum = threadNum;
        this.sum = 0;
    }
    public static void main(String[] args) {//main method
        long start = System.nanoTime(); // tracks initial time
        System.out.print("Hello and welcome!");
        Thread[] thread = new Thread[1000]; // main thread
        for(int i = 0; i < thread.length; i++){
            Main obj = new Main(i); // creates main object for thread
            thread[i] = new Thread(obj); // initializes the threads
            thread[i].start(); // starts all the thread

        }
        for(int i = 0; i < thread.length; i++) {
            try {
                thread[i].join(); // join them after they have finished executing the threads
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("The final total is " + total);
        long end = System.nanoTime(); // end time
        long totalTime = end - start; // delta t
        System.out.println("Thread execution time: " + totalTime / 1_000_000.0 + " ms");
    }

    @Override
    public void run() {
        for (int j = 1; j <= 1000000; j++) {
            sum += j; //sums the values from 1 - 1M
        }
        total += sum; // final total of all the threads
        System.out.println("Running thread for i = " + threadNum + ", sum = " + sum);
        System.out.println("The sum so far from thread " + threadNum + " is = " + total);
    }

}