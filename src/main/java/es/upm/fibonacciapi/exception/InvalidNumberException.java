package es.upm.fibonacciapi.exception;

public class InvalidNumberException extends RuntimeException {

    private static final long serialVersionUID = -3247526245777962770L;

    public InvalidNumberException() {
        super("The number must be between 0 and 92");
    }

}
