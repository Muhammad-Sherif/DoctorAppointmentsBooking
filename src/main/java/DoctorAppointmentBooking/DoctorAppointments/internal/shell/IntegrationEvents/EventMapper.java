package DoctorAppointmentBooking.DoctorAppointments.internal.shell.IntegrationEvents;

import DoctorAppointmentBooking.AppointmentBooking.external.dtos.NewBookedAppointmentEventDto;
import DoctorAppointmentBooking.DoctorAppointments.internal.core.eventHandlers.NewBookedAppointment;


public class EventMapper {

    public static NewBookedAppointment toDoctorAppointmentEntity(NewBookedAppointmentEventDto eventDto) {
        return new NewBookedAppointment(
                eventDto.bookId(),
                new NewBookedAppointment.BookingDetails(
                        eventDto.bookingDetails().patientId(),
                        eventDto.bookingDetails().patientName(),
                        eventDto.bookingDetails().doctorId(),
                        eventDto.bookingDetails().doctorName()
                ),
                new NewBookedAppointment.SlotDetails(
                        eventDto.slotDetails().slotId(),
                        eventDto.slotDetails().date(),
                        eventDto.slotDetails().startTime(),
                        eventDto.slotDetails().endTime()
                )
        );
    }

}
