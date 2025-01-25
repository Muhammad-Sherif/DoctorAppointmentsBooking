package DoctorAppointmentBooking.AppointmentBooking.internal.application.command.BookAppointment;

import DoctorAppointmentBooking.AppointmentBooking.internal.application.abstractions.INewAppointmentEventHandler;
import DoctorAppointmentBooking.shared.abstractions.ICommandHandler;
import DoctorAppointmentBooking.AppointmentBooking.internal.application.abstractions.IDoctorAvailabilitySlotsGateway;
import DoctorAppointmentBooking.AppointmentBooking.internal.domain.abstraction.IBookedAppointmentRepository;
import DoctorAppointmentBooking.AppointmentBooking.internal.domain.events.NewBookedAppointmentEvent;
import DoctorAppointmentBooking.AppointmentBooking.internal.domain.models.BookedAppointment;
import DoctorAppointmentBooking.AppointmentBooking.internal.domain.services.AppointmentBookingService;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class BookAppointmentHandler implements ICommandHandler<BookAppointmentCommand, BookAppointmentResponse> {
    private final IDoctorAvailabilitySlotsGateway doctorAvailabilitySlotsGateway;
    private final IBookedAppointmentRepository bookedAppointmentEntityRepository;
    private final AppointmentBookingService appointmentBookingService;
    private final INewAppointmentEventHandler appointmentEventsPublisher;
    public BookAppointmentHandler(IDoctorAvailabilitySlotsGateway doctorAvailabilitySlotsGateway,
                                  IBookedAppointmentRepository bookedAppointmentEntityRepository,
                                  AppointmentBookingService appointmentBookingService, INewAppointmentEventHandler appointmentEventsPublisher) {
        this.doctorAvailabilitySlotsGateway = doctorAvailabilitySlotsGateway;
        this.bookedAppointmentEntityRepository = bookedAppointmentEntityRepository;
        this.appointmentBookingService = appointmentBookingService;
        this.appointmentEventsPublisher = appointmentEventsPublisher;
    }

    @Override
    @Transactional
    public BookAppointmentResponse handle(BookAppointmentCommand command) {
        boolean isReserved = doctorAvailabilitySlotsGateway.reserveSlot(command.slotId());

        BookedAppointment bookedAppointment = appointmentBookingService.bookAppointment(
                command.slotId(),
                isReserved,
                command.patientId(),
                command.patientName()
        );

        bookedAppointmentEntityRepository.save(bookedAppointment);
        NewBookedAppointmentEvent newAppointmentEvent = bookedAppointment.getNewAppointmentEvent();
        appointmentEventsPublisher.handleEvent(newAppointmentEvent);
        return new BookAppointmentResponse(bookedAppointment.getId());
    }
}
