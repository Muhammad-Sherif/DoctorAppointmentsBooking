package DoctorAppointmentBooking.AppointmentBooking.internal.application.abstractions;


import DoctorAppointmentBooking.AppointmentBooking.internal.application.models.DoctorAvailableSlot;

import java.util.List;
import java.util.UUID;

public interface IDoctorAvailabilitySlotsGateway {
    List<DoctorAvailableSlot> getDoctorsAvailableSlots();
    boolean reserveSlot(UUID slotId);
}
