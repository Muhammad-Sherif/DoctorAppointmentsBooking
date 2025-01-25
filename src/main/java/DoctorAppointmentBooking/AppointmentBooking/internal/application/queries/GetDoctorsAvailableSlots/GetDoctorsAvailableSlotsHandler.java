package DoctorAppointmentBooking.AppointmentBooking.internal.application.queries.GetDoctorsAvailableSlots;


import DoctorAppointmentBooking.AppointmentBooking.internal.application.abstractions.IDoctorAvailabilitySlotsGateway;
import DoctorAppointmentBooking.shared.abstractions.INoInputQueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GetDoctorsAvailableSlotsHandler implements INoInputQueryHandler<GetDoctorsAvailableSlotsResponse> {
    private final IDoctorAvailabilitySlotsGateway doctorAvailabilitySlotsGateway;

    public GetDoctorsAvailableSlotsHandler(IDoctorAvailabilitySlotsGateway doctorAvailabilitySlotsGateway) {
        this.doctorAvailabilitySlotsGateway = doctorAvailabilitySlotsGateway;
    }

    @Override
    public GetDoctorsAvailableSlotsResponse handle() {
        List<GetDoctorsAvailableSlotsResponse.DoctorAvailableSlot> doctorAvailableSlots =
                doctorAvailabilitySlotsGateway.getDoctorsAvailableSlots().
                stream().
                map(slot ->
                        new GetDoctorsAvailableSlotsResponse.DoctorAvailableSlot(
                                slot.id(),
                                slot.doctorId(),
                                slot.doctorName(),
                                slot.date(),
                                slot.startTime(),
                                slot.endTime(),
                                slot.cost())
                ).toList();

        return new GetDoctorsAvailableSlotsResponse(doctorAvailableSlots);
    }
}
