package app.authorization.TOTP;

/**
 * Exception modeling when something went wrong during verifying the code in second step.
 */
public class VerificationCodeException extends Exception {

    public VerificationCodeException(String message) {
        super(message);
    }
}
