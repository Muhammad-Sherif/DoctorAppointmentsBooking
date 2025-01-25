package DoctorAppointmentBooking.DoctorAppointments.internal.core.eventHandlers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;


public record NewBookedAppointment(UUID bookId, BookingDetails bookingDetails, SlotDetails slotDetails) {

    public record BookingDetails(UUID patientId, String patientName, UUID doctorId, String doctorName) {}

    public record SlotDetails(UUID slotId, LocalDate date, LocalTime startTime, LocalTime endTime) {}
}
