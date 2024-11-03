import java.util.concurrent.TimeUnit;

class ThreadThree extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("contando Thread 3: " + (i * i));
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}