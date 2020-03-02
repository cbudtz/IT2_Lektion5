public class CustomRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from: " + Thread.currentThread().getName());
    }
}
