package DoctorAppointmentBooking.AppointmentBooking.internal.application.abstractions;

import DoctorAppointmentBooking.AppointmentBooking.internal.domain.events.NewBookedAppointmentEvent;

public interface INewAppointmentEventHandler {

    void handleEvent(NewBookedAppointmentEvent newBookedAppointmentEvent);
}
