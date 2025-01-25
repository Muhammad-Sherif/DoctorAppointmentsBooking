package DoctorAppointmentBooking.AppointmentBooking.internal.domain.exceptions;

public class BusinessRuleException extends RuntimeException {
    public BusinessRuleException(String description) {
        super(description);
    }
}
