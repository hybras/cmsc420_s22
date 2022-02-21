package cmsc420_s22;

public final class EmptyHeapException extends Exception {

    public EmptyHeapException() {
        super("Empty heap");
    }
}
