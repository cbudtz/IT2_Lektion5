public class CustomThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from Thread: " + Thread.currentThread().getName());
    }
}
