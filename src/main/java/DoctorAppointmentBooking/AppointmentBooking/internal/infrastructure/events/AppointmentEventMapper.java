package DoctorAppointmentBooking.AppointmentBooking.internal.infrastructure.events;

import DoctorAppointmentBooking.AppointmentBooking.external.dtos.NewBookedAppointmentEventDto;
import DoctorAppointmentBooking.AppointmentBooking.internal.application.models.DoctorAvailableSlot;
import DoctorAppointmentBooking.AppointmentBooking.internal.domain.events.NewBookedAppointmentEvent;
import DoctorAppointmentBooking.AppointmentBooking.internal.domain.models.BookedAppointment;

public class AppointmentEventMapper {

    public static NewBookedAppointmentEventDto toNewBookedAppointmentEventDto(
            NewBookedAppointmentEvent newBookedAppointmentEvent,
            DoctorAvailableSlot appointmentSlotInfo) {


        BookedAppointment bookedAppointment = newBookedAppointmentEvent.BookedAppointment();

        return new NewBookedAppointmentEventDto(
                bookedAppointment.getId(),
                new NewBookedAppointmentEventDto.BookingDetails(
                        bookedAppointment.getPatientId(),
                        bookedAppointment.getPatientName(),
                        appointmentSlotInfo.doctorId(),
                        appointmentSlotInfo.doctorName(),
                        appointmentSlotInfo.cost()
                ),
                new NewBookedAppointmentEventDto.SlotDetails(
                        bookedAppointment.getSlotId(),
                        appointmentSlotInfo.date(),
                        appointmentSlotInfo.startTime(),
                        appointmentSlotInfo.endTime()
                )
        );
    }

}

