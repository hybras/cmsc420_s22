package cmsc420_s22;

public final class EmptyListException extends Exception {

    public EmptyListException() {
        super("Attempt to extract from an empty list");
    }
}
