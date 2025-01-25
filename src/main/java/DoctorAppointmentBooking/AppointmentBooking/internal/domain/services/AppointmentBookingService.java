package DoctorAppointmentBooking.AppointmentBooking.internal.domain.services;

import DoctorAppointmentBooking.AppointmentBooking.internal.domain.exceptions.BusinessRuleException;
import DoctorAppointmentBooking.AppointmentBooking.internal.domain.models.BookedAppointment;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AppointmentBookingService {

    public BookedAppointment bookAppointment(UUID slotId,boolean isSlotReserved, UUID patientId, String patientName) {
        if (!isSlotReserved) {
            throw new BusinessRuleException("Slot is no longer available");
        }

        return new BookedAppointment(slotId, patientId, patientName);
    }
}