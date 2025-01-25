package DoctorAppointmentBooking.DoctorAvailability.internal.business.records;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record NewSlot(UUID doctorId, String doctorName, LocalDate date, LocalTime startTime, LocalTime endTime, Double cost) {
}
