package DoctorAppointmentBooking.AppointmentBooking.internal.infrastructure.events;

import DoctorAppointmentBooking.AppointmentBooking.external.dtos.NewBookedAppointmentEventDto;
import DoctorAppointmentBooking.AppointmentBooking.internal.application.abstractions.INewAppointmentEventHandler;
import DoctorAppointmentBooking.AppointmentBooking.internal.application.models.DoctorAvailableSlot;
import DoctorAppointmentBooking.AppointmentBooking.internal.domain.events.NewBookedAppointmentEvent;
import DoctorAppointmentBooking.AppointmentBooking.internal.infrastructure.gateways.DoctorAvailabilitySlotsGateway;
import DoctorAppointmentBooking.AppointmentConfirmation.external.INotificationApi;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class NewAppointmentEventHandler implements INewAppointmentEventHandler {
    private final ApplicationEventPublisher eventPublisher;
    private final DoctorAvailabilitySlotsGateway doctorAvailabilitySlotsGateway;
    private final INotificationApi notificationApi;
    private final String NEW_BOOKED_APPOINTMENT_TOPIC = "NewBookedAppointmentEvent";
    public NewAppointmentEventHandler(ApplicationEventPublisher eventPublisher, DoctorAvailabilitySlotsGateway doctorAvailabilitySlotsGateway, INotificationApi notificationApi) {
        this.eventPublisher = eventPublisher;
        this.doctorAvailabilitySlotsGateway = doctorAvailabilitySlotsGateway;
        this.notificationApi = notificationApi;
    }

    @Override
    public void handleEvent(NewBookedAppointmentEvent newBookedAppointmentEvent) {
        DoctorAvailableSlot appointmentSlotInfo = doctorAvailabilitySlotsGateway.getSlot(newBookedAppointmentEvent.BookedAppointment().getSlotId());
        NewBookedAppointmentEventDto newBookedAppointmentEventDto = AppointmentEventMapper.toNewBookedAppointmentEventDto(newBookedAppointmentEvent, appointmentSlotInfo);
        eventPublisher.publishEvent(newBookedAppointmentEventDto);
        notificationApi.notify(NEW_BOOKED_APPOINTMENT_TOPIC, newBookedAppointmentEventDto.toString());
    }
}
