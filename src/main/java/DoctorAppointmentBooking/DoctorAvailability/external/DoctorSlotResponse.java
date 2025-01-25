package DoctorAppointmentBooking.DoctorAvailability.external;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record DoctorSlotResponse(UUID id, UUID doctorId, String doctorName, LocalDate date, LocalTime startTime, LocalTime endTime, double cost) {
}
