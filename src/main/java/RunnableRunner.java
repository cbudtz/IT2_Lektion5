public class RunnableRunner {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {

//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("Hello from " + Thread.currentThread().getName());
//                }
//            }).start();
            new Thread(new CustomRunnable()).start();
        }
    }
}
