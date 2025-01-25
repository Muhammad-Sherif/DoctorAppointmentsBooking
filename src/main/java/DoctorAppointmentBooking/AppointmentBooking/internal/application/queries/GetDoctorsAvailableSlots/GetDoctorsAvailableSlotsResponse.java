package DoctorAppointmentBooking.AppointmentBooking.internal.application.queries.GetDoctorsAvailableSlots;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public record GetDoctorsAvailableSlotsResponse(List<DoctorAvailableSlot> doctorsAvailableSlots) {

    public record DoctorAvailableSlot(
            UUID uuid,
            UUID doctorId,
            String doctorName,
            LocalDate date,
            LocalTime startTime,
            LocalTime endTime,
            double cost) {
    }
}
