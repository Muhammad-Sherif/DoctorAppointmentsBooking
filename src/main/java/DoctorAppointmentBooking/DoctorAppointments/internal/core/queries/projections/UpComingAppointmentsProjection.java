package DoctorAppointmentBooking.DoctorAppointments.internal.core.queries.projections;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public record UpComingAppointmentsProjection(UUID doctorId, List<AppointmentProjection> appointments) {
    public record AppointmentProjection(UUID patentId, String patientName,  LocalDate date, LocalTime startTime, LocalTime endTime) {
    }

}