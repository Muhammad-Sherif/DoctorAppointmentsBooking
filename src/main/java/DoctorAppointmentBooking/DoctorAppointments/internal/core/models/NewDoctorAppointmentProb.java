package DoctorAppointmentBooking.DoctorAppointments.internal.core.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record NewDoctorAppointmentProb(
        UUID bookId,
        UUID patientId,
        String patientName,
        UUID doctorId,
        String doctorName,
        UUID slotId,
        LocalDate date,
        LocalTime startTime,
        LocalTime endTime
) { }
