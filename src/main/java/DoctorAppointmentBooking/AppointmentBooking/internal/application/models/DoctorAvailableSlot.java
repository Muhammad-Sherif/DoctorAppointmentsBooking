package DoctorAppointmentBooking.AppointmentBooking.internal.application.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record DoctorAvailableSlot(UUID id, UUID doctorId, String doctorName, LocalDate date, LocalTime startTime, LocalTime endTime, double cost) {
}
