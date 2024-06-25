package Exception;

public class InvalidDeliveryException extends PackageDeliveryException {
    public InvalidDeliveryException(String message) {
        super(message);
    }
}