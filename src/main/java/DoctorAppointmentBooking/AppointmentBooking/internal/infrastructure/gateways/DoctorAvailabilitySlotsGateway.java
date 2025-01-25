package DoctorAppointmentBooking.AppointmentBooking.internal.infrastructure.gateways;

import DoctorAppointmentBooking.AppointmentBooking.internal.application.abstractions.IDoctorAvailabilitySlotsGateway;
import DoctorAppointmentBooking.AppointmentBooking.internal.application.models.DoctorAvailableSlot;
import DoctorAppointmentBooking.DoctorAvailability.external.IDoctorAvailabilitySlotsApi;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class DoctorAvailabilitySlotsGateway implements IDoctorAvailabilitySlotsGateway {

    private final IDoctorAvailabilitySlotsApi doctorAvailabilitySlotsApi;

    public DoctorAvailabilitySlotsGateway(IDoctorAvailabilitySlotsApi doctorAvailabilitySlotsApi) {
        this.doctorAvailabilitySlotsApi = doctorAvailabilitySlotsApi;
    }

    @Override
    public List<DoctorAvailableSlot> getDoctorsAvailableSlots() {
        return doctorAvailabilitySlotsApi.getDoctorsAvailableSlots()
                .stream().
                map(slot -> new DoctorAvailableSlot(
                        slot.id(),
                        slot.doctorId(),
                        slot.doctorName(),
                        slot.date(),
                        slot.startTime(),
                        slot.endTime(),
                        slot.cost()
                )).toList();

    }

    @Override
    public boolean reserveSlot(UUID slotId) {
        return doctorAvailabilitySlotsApi.reserveSlot(slotId);
    }

    public DoctorAvailableSlot getSlot(UUID slotId) {
        var slot = doctorAvailabilitySlotsApi.getSlot(slotId);
        return new DoctorAvailableSlot(
                slot.id(),
                slot.doctorId(),
                slot.doctorName(),
                slot.date(),
                slot.startTime(),
                slot.endTime(),
                slot.cost()
        );
    }
}
