package DoctorAppointmentBooking.DoctorAppointments.internal.core.commands.completeAppointment;

import DoctorAppointmentBooking.AppointmentBooking.internal.domain.exceptions.BusinessRuleException;
import DoctorAppointmentBooking.DoctorAppointments.internal.core.abstractions.IDoctorAppointmentRepository;
import DoctorAppointmentBooking.DoctorAppointments.internal.core.models.DoctorAppointment;
import DoctorAppointmentBooking.shared.abstractions.INoReturnCommandHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CompleteAppointmentHandler implements INoReturnCommandHandler<CompleteAppointmentCommand> {
    private final IDoctorAppointmentRepository doctorAppointmentRepository;

    public CompleteAppointmentHandler(IDoctorAppointmentRepository doctorAppointmentRepository) {
        this.doctorAppointmentRepository = doctorAppointmentRepository;
    }

    @Override
    public void handle(CompleteAppointmentCommand command) {
        Optional<DoctorAppointment> optionalDoctorAppointment = doctorAppointmentRepository.getById(command.appointmentId());
        if(optionalDoctorAppointment.isPresent()) {
            DoctorAppointment doctorAppointment = optionalDoctorAppointment.get();
            doctorAppointment.completeAppointment();
        }
        else {
            throw new BusinessRuleException("Appointment not found");
        }

    }
}

