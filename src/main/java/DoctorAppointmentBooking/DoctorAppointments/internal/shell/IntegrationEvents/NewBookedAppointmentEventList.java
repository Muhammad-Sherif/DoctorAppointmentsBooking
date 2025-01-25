package DoctorAppointmentBooking.DoctorAppointments.internal.shell.IntegrationEvents;

import DoctorAppointmentBooking.AppointmentBooking.external.dtos.NewBookedAppointmentEventDto;
import DoctorAppointmentBooking.DoctorAppointments.internal.core.eventHandlers.NewBookedAppointment;
import DoctorAppointmentBooking.DoctorAppointments.internal.core.eventHandlers.NewBookedAppointmentHandler;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
public class NewBookedAppointmentEventList {

    NewBookedAppointmentHandler newBookedAppointmentHandler;
    @ApplicationModuleListener
    public void handleNewBookedAppointmentEvent(NewBookedAppointmentEventDto newBookedAppointmentEventDto) {
        NewBookedAppointment doctorAppointment = EventMapper.toDoctorAppointmentEntity(newBookedAppointmentEventDto);
        newBookedAppointmentHandler.handle(doctorAppointment);


    }


}
