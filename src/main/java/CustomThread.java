public class CustomThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10 ; i++) {
                Thread.sleep((int) (Math.random() * 5000));
                System.out.println("Hello no." + i + " from Thread: " + Thread.currentThread().getName());
            }
            System.out.println(Thread.currentThread().getName() + " is done!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
