package DoctorAppointmentBooking.AppointmentBooking.internal.presentation.bodies;

import java.util.UUID;

public record BookAppointmentBody(UUID slotId, UUID patientId, String patientName) {
}
