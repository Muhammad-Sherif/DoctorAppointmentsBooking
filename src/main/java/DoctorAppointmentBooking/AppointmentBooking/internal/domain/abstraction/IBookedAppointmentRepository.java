package DoctorAppointmentBooking.AppointmentBooking.internal.domain.abstraction;

import DoctorAppointmentBooking.AppointmentBooking.internal.domain.models.BookedAppointment;

import java.util.UUID;

public interface IBookedAppointmentRepository {

    void save(BookedAppointment bookedAppointment);
    BookedAppointment findById(UUID id);


}
