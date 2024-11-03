public class main {
    public static void main(String[] args) {

        Thread thread1 = new ThreadOne();
        Thread thread2 = new ThreadTwo();
        Thread thread3 = new ThreadThree();

        thread1.start();
        thread2.start();
        thread3.start();
    }
}