package DoctorAppointmentBooking.DoctorAvailability.internal.presentation.bodies;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record CreateSlotBody(UUID doctorId, String doctorName,LocalDate date, LocalTime startTime, LocalTime endTime, Double cost) {

}
