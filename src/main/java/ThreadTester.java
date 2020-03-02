public class ThreadTester {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new CustomThread().start();
        }
    }
}
