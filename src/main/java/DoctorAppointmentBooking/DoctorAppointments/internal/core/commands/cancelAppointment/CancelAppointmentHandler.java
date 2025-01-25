package DoctorAppointmentBooking.DoctorAppointments.internal.core.commands.cancelAppointment;

import DoctorAppointmentBooking.AppointmentBooking.internal.domain.exceptions.BusinessRuleException;
import DoctorAppointmentBooking.DoctorAppointments.internal.core.abstractions.IDoctorAppointmentRepository;
import DoctorAppointmentBooking.DoctorAppointments.internal.core.models.DoctorAppointment;
import DoctorAppointmentBooking.shared.abstractions.INoReturnCommandHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CancelAppointmentHandler implements INoReturnCommandHandler<CancelAppointmentCommand> {
    private final IDoctorAppointmentRepository doctorAppointmentRepository;

    public CancelAppointmentHandler(IDoctorAppointmentRepository doctorAppointmentRepository) {
        this.doctorAppointmentRepository = doctorAppointmentRepository;
    }

    @Override
    public void handle(CancelAppointmentCommand command) {
        Optional<DoctorAppointment> optionalDoctorAppointment = doctorAppointmentRepository.getById(command.appointmentId());
        if(optionalDoctorAppointment.isPresent()) {
            DoctorAppointment doctorAppointment = optionalDoctorAppointment.get();
            doctorAppointment.cancelAppointment();
        }
        else {
            throw new BusinessRuleException("Appointment not found");
        }

    }
}

