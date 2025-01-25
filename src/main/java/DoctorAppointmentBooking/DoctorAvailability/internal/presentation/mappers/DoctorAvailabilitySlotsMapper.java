package DoctorAppointmentBooking.DoctorAvailability.internal.presentation.mappers;

import DoctorAppointmentBooking.DoctorAvailability.internal.business.records.NewSlot;
import DoctorAppointmentBooking.DoctorAvailability.internal.presentation.bodies.CreateSlotBody;
import org.springframework.stereotype.Component;

@Component
public class DoctorAvailabilitySlotsMapper {

    public NewSlot mapToCreateSlot(CreateSlotBody createSlotBody) {
        return new NewSlot(
                createSlotBody.doctorId(),
                createSlotBody.doctorName(),
                createSlotBody.date(),
                createSlotBody.startTime(),
                createSlotBody.endTime(),
                createSlotBody.cost());


    }
}
