package DoctorAppointmentBooking.AppointmentBooking.internal.domain.events;

import DoctorAppointmentBooking.AppointmentBooking.internal.domain.abstraction.IDomainEvent;
import DoctorAppointmentBooking.AppointmentBooking.internal.domain.models.BookedAppointment;

public record NewBookedAppointmentEvent(BookedAppointment BookedAppointment) implements IDomainEvent {


}
