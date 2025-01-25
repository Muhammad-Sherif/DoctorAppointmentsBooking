package DoctorAppointmentBooking.AppointmentBooking.external.dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;



public record NewBookedAppointmentEventDto(UUID bookId, BookingDetails bookingDetails, SlotDetails slotDetails) {

    public record BookingDetails(UUID patientId, String patientName, UUID doctorId, String doctorName, double cost) {}

    public record SlotDetails(UUID slotId, LocalDate date, LocalTime startTime, LocalTime endTime) {}
}
