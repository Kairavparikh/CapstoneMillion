public class Main implements Runnable {
    private final int i;
    public Main(int i) {
        this.i = i;
    }
    public static void main(String[] args) {
        System.out.print("Hello and welcome!");
        Thread[] thread = new Thread[1000];
        for(int i = 0; i < thread.length; i++){
            Main obj = new Main(i);
            thread[i] = new Thread(obj);
            thread[i].start();

        }
    }

    @Override
    public void run() {
        System.out.println("Running thread for i = " + i);
    }
}