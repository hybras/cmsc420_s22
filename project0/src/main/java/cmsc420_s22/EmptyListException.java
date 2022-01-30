package cmsc420_s22;

/**
 * DualList (skeleton)
 * <p>
 * MODIFY THE FOLLOWING CLASS.
 * <p>
 * You are free to make whatever changes you like or to create additional
 * classes and files.
 */

public final class EmptyListException extends Exception {

    public EmptyListException() {
        super("Attempt to extract from an empty list");
    }
}
