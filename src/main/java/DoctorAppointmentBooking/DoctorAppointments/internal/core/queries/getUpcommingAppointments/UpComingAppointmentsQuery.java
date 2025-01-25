package DoctorAppointmentBooking.DoctorAppointments.internal.core.queries.getUpcommingAppointments;

import DoctorAppointmentBooking.shared.abstractions.IQuery;

import java.util.UUID;

public record UpComingAppointmentsQuery(UUID doctorId) implements IQuery {
}
