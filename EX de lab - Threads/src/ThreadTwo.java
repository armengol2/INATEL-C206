import java.util.concurrent.TimeUnit;

class ThreadTwo extends Thread {
    public void run() {
        for (int i = 2; i <= 6; i++) {
            System.out.println("contando Thread 2: " + i);
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
