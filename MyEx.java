public class MyEx extends Exception {
    public MyEx(String message) {
        super(message);
    }

    public MyEx(String message, Throwable cause) {
        super(message, cause);
    }
}
