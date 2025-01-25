package DoctorAppointmentBooking.DoctorAppointments.internal.core.queries.getUpcommingAppointments;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public record UpComingAppointmentsResponse(UUID doctorId, List<Appointment> appointments) {
    public record Appointment(UUID patentId, String patientName,LocalDate date, LocalTime startTime, LocalTime endTime) {
    }

}
