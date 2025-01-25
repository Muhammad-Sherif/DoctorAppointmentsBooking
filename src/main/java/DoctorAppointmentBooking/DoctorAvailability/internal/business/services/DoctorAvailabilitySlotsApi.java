package DoctorAppointmentBooking.DoctorAvailability.internal.business.services;

import DoctorAppointmentBooking.DoctorAvailability.external.DoctorSlotResponse;
import DoctorAppointmentBooking.DoctorAvailability.external.IDoctorAvailabilitySlotsApi;
import DoctorAppointmentBooking.DoctorAvailability.internal.business.mappers.DoctorAvailabilitySlotsMapper;
import DoctorAppointmentBooking.DoctorAvailability.internal.data.models.DoctorAvailabilitySlot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorAvailabilitySlotsApi implements IDoctorAvailabilitySlotsApi {
    private final DoctorAvailabilitySlotsService doctorAvailabilitySlotsService;
    private final DoctorAvailabilitySlotsMapper doctorAvailabilitySlotsMapper;
    private final Logger logger = LoggerFactory.getLogger(DoctorAvailabilitySlotsApi.class.getName());

    public DoctorAvailabilitySlotsApi(DoctorAvailabilitySlotsService doctorAvailabilitySlotsService, DoctorAvailabilitySlotsMapper doctorAvailabilitySlotsMapper) {
        this.doctorAvailabilitySlotsService = doctorAvailabilitySlotsService;
        this.doctorAvailabilitySlotsMapper = doctorAvailabilitySlotsMapper;
    }

    @Override
    public List<DoctorSlotResponse> getDoctorsAvailableSlots() {
        logger.info("Getting available slots for all doctors");
        List<DoctorAvailabilitySlot> doctorAvailabilitySlotList = doctorAvailabilitySlotsService.getAvailableSlotsForAllDoctors();
        return doctorAvailabilitySlotsMapper.mapToDoctorAvailableSlotResponse(doctorAvailabilitySlotList);
    }

    @Override
    public boolean reserveSlot(UUID slotId) {
        logger.info("Reserving slot with id: {}", slotId);
        boolean isReserved = doctorAvailabilitySlotsService.reserveSlot(slotId);
        if(isReserved) {
            logger.info("Slot with id: {} is reserved", slotId);
        } else {
            logger.error("Slot with id: {} is already reserved", slotId);
        }
        return isReserved;
    }

    @Override
    public DoctorSlotResponse getSlot(UUID slotId) {
        DoctorAvailabilitySlot doctorAvailabilitySlot = doctorAvailabilitySlotsService.getSlotById(slotId);
        return doctorAvailabilitySlotsMapper.mapToDoctorAvailabilitySlot(doctorAvailabilitySlot);
    }
}
