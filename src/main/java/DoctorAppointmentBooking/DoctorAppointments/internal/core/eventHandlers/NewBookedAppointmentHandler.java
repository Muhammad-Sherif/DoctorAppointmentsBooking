package DoctorAppointmentBooking.DoctorAppointments.internal.core.eventHandlers;


import DoctorAppointmentBooking.DoctorAppointments.internal.core.abstractions.IDoctorAppointmentRepository;
import DoctorAppointmentBooking.DoctorAppointments.internal.core.models.DoctorAppointment;
import DoctorAppointmentBooking.DoctorAppointments.internal.core.models.NewDoctorAppointmentProb;
import org.springframework.stereotype.Component;

@Component
public class NewBookedAppointmentHandler  {
    IDoctorAppointmentRepository doctorAppointmentRepository;


    public void handle(NewBookedAppointment doctorAppointment) {

        NewDoctorAppointmentProb prob = new NewDoctorAppointmentProb(
                doctorAppointment.bookId(),
                doctorAppointment.bookingDetails().patientId(),
                doctorAppointment.bookingDetails().patientName(),
                doctorAppointment.bookingDetails().doctorId(),
                doctorAppointment.bookingDetails().doctorName(),
                doctorAppointment.slotDetails().slotId(),
                doctorAppointment.slotDetails().date(),
                doctorAppointment.slotDetails().startTime(),
                doctorAppointment.slotDetails().endTime()
        );

        DoctorAppointment newAppointment = DoctorAppointment.newDoctorAppointment(prob);
        doctorAppointmentRepository.save(newAppointment);



    }

}
