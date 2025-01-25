package DoctorAppointmentBooking.DoctorAvailability.external;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface IDoctorAvailabilitySlotsApi {

    List<DoctorSlotResponse> getDoctorsAvailableSlots();
    boolean reserveSlot(UUID slotId);

    DoctorSlotResponse getSlot(UUID slotId);
}
