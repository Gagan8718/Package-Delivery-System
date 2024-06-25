package Exception;

public class DuplicateDeliveryException extends PackageDeliveryException {
    public DuplicateDeliveryException(String message) {
        super(message);
    }
}