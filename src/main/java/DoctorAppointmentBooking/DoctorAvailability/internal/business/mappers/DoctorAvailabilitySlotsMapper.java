package DoctorAppointmentBooking.DoctorAvailability.internal.business.mappers;

import DoctorAppointmentBooking.DoctorAvailability.external.DoctorSlotResponse;
import DoctorAppointmentBooking.DoctorAvailability.external.ReservedSlotInfoResponse;
import DoctorAppointmentBooking.DoctorAvailability.internal.business.records.NewSlot;
import DoctorAppointmentBooking.DoctorAvailability.internal.business.records.ReservedSlotInfo;
import DoctorAppointmentBooking.DoctorAvailability.internal.data.models.DoctorAvailabilitySlot;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ServiceDoctorAvailabilitySlotsMapper")
public class DoctorAvailabilitySlotsMapper {

    public DoctorAvailabilitySlot mapToDoctorAvailabilitySlot(NewSlot newSlot) {

        DoctorAvailabilitySlot doctorAvailabilitySlot=  new DoctorAvailabilitySlot();
        doctorAvailabilitySlot.setDoctorId(newSlot.doctorId());
        doctorAvailabilitySlot.setDoctorName(newSlot.doctorName());
        doctorAvailabilitySlot.setDate(newSlot.date());
        doctorAvailabilitySlot.setStartTime(newSlot.startTime());
        doctorAvailabilitySlot.setEndTime(newSlot.endTime());
        doctorAvailabilitySlot.setCost(newSlot.cost());
        return doctorAvailabilitySlot;

    }

    public List<DoctorSlotResponse> mapToDoctorAvailableSlotResponse(
            List<DoctorAvailabilitySlot> doctorAvailabilitySlotList) {

        return doctorAvailabilitySlotList.stream().map(
                        slot ->
                                new DoctorSlotResponse(
                                        slot.getId(),
                                        slot.getDoctorId(),
                                        slot.getDoctorName(),
                                        slot.getDate(),
                                        slot.getStartTime(),
                                        slot.getEndTime(),
                                        slot.getCost()))
                .toList();


    }

    public ReservedSlotInfoResponse mapToReservedSlotInfoResponse(ReservedSlotInfo reservedSlotInfo) {
            DoctorSlotResponse doctorSlotResponse =
                    new DoctorSlotResponse(
                            reservedSlotInfo.slot().getId(),
                            reservedSlotInfo.slot().getDoctorId(),
                            reservedSlotInfo.slot().getDoctorName(),
                            reservedSlotInfo.slot().getDate(),
                            reservedSlotInfo.slot().getStartTime(),
                            reservedSlotInfo.slot().getEndTime(),
                            reservedSlotInfo.slot().getCost()
                    );
            return new ReservedSlotInfoResponse(reservedSlotInfo.isReserved(), doctorSlotResponse);


    }

    public DoctorSlotResponse mapToDoctorAvailabilitySlot(DoctorAvailabilitySlot doctorAvailabilitySlot) {
        return new DoctorSlotResponse(
                doctorAvailabilitySlot.getId(),
                doctorAvailabilitySlot.getDoctorId(),
                doctorAvailabilitySlot.getDoctorName(),
                doctorAvailabilitySlot.getDate(),
                doctorAvailabilitySlot.getStartTime(),
                doctorAvailabilitySlot.getEndTime(),
                doctorAvailabilitySlot.getCost()
        );
    }
}