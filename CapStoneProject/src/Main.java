public class Main implements Runnable {
    private int sum = 0;
    static long total = 0;
    private int threadNum;
    public Main(int threadNum) {
        this.threadNum = threadNum;
        this.sum = 0;
    }
    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.print("Hello and welcome!");
        Thread[] thread = new Thread[1000];
        for(int i = 0; i < thread.length; i++){
            Main obj = new Main(i);
            thread[i] = new Thread(obj);
            thread[i].start();

        }
        for(int i = 0; i < thread.length; i++) {
            try {
                thread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("The final total is " + total);
        long end = System.nanoTime();
        long totalTime = end - start;
        System.out.println("Thread execution time: " + totalTime / 1_000_000.0 + " ms");
    }

    @Override
    public void run() {
        for (int j = 1; j <= 1000000; j++) {
            sum += j;
        }
        total += sum;
        System.out.println("Running thread for i = " + threadNum + ", sum = " + sum);
        System.out.println("The sum so far from thread " + threadNum + " is = " + total);
    }

}