package DoctorAppointmentBooking.DoctorAppointments.internal.core.abstractions;

import DoctorAppointmentBooking.DoctorAppointments.internal.core.models.DoctorAppointment;
import DoctorAppointmentBooking.DoctorAppointments.internal.core.queries.projections.UpComingAppointmentsProjection;

import java.util.Optional;
import java.util.UUID;


public interface IDoctorAppointmentRepository {
    UpComingAppointmentsProjection getUpcomingAppointments(UUID doctorId);
    void save(DoctorAppointment doctorAppointment);

    Optional<DoctorAppointment> getById(UUID id);

    void update(DoctorAppointment doctorAppointment);

}
