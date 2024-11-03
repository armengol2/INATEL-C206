import java.util.concurrent.TimeUnit;

class ThreadOne extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("contando Thread 1: " + i);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}