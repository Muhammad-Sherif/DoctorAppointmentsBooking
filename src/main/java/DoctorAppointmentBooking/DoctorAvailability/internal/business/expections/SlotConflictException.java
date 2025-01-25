package DoctorAppointmentBooking.DoctorAvailability.internal.business.expections;

public class SlotConflictException extends RuntimeException {
    public SlotConflictException(String message) {
        super(message);
    }

}
