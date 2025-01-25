package DoctorAppointmentBooking.DoctorAvailability.internal.business.services;


import jakarta.transaction.Transactional;
import DoctorAppointmentBooking.DoctorAvailability.internal.business.expections.SlotConflictException;
import DoctorAppointmentBooking.DoctorAvailability.internal.business.mappers.DoctorAvailabilitySlotsMapper;
import DoctorAppointmentBooking.DoctorAvailability.internal.business.records.NewSlot;
import DoctorAppointmentBooking.DoctorAvailability.internal.data.models.DoctorAvailabilitySlot;
import DoctorAppointmentBooking.DoctorAvailability.internal.data.repos.DoctorAvailabilitySlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class DoctorAvailabilitySlotsService {

    private final DoctorAvailabilitySlotRepository doctorAvailabilitySlotRepository;
    private final DoctorAvailabilitySlotsMapper doctorAvailabilitySlotsMapper;
    private final Logger logger = LoggerFactory.getLogger(DoctorAvailabilitySlotsService.class.getName());
    public DoctorAvailabilitySlotsService(DoctorAvailabilitySlotRepository doctorAvailabilitySlotRepository, DoctorAvailabilitySlotsMapper doctorAvailabilitySlotsMapper) {
        this.doctorAvailabilitySlotRepository = doctorAvailabilitySlotRepository;
        this.doctorAvailabilitySlotsMapper = doctorAvailabilitySlotsMapper;
    }

    public List<DoctorAvailabilitySlot> getSlotsForDoctor(UUID doctorId) {
        logger.info("Getting slots for doctor with id: {}",doctorId);
        return doctorAvailabilitySlotRepository.getSlotsByDoctorId(doctorId);
    }

    public void createNewSlot(NewSlot newSlot) {
        logger.info("Creating new slot for doctor with id: {}",newSlot.doctorId());
        validateSlotTimeIsNotConflictsWithOtherSlots(newSlot);
        DoctorAvailabilitySlot newDoctorAvailabilitySlot = doctorAvailabilitySlotsMapper.mapToDoctorAvailabilitySlot(newSlot);
        doctorAvailabilitySlotRepository.save(newDoctorAvailabilitySlot);
        logger.info("Saved new slot for doctor with id: {}",newSlot.doctorId());
    }

    private void validateSlotTimeIsNotConflictsWithOtherSlots(NewSlot newSlot) {
        boolean isSlotConflictWithOtherSlots = doctorAvailabilitySlotRepository.
                existsByDateRange(newSlot.doctorId(), newSlot.date() , newSlot.startTime(), newSlot.endTime());

        if(isSlotConflictWithOtherSlots) {
            logger.error("Slot Time is conflicting with other slots");
            throw new SlotConflictException("Slot Time is conflicting with other slots");
        }
    }

    public List<DoctorAvailabilitySlot> getAvailableSlotsForAllDoctors() {
        return doctorAvailabilitySlotRepository.getAvailableSlots();

    }

    @Transactional
    public boolean reserveSlot(UUID slotId) {
        Optional<DoctorAvailabilitySlot> slot = doctorAvailabilitySlotRepository.findByIdWithLock(slotId);
        if(slot.isEmpty()) {
            return false;
        }
        DoctorAvailabilitySlot doctorAvailabilitySlot = slot.get();
        if(!doctorAvailabilitySlot.getReserved()) {
            doctorAvailabilitySlot.setReserved(true);
            doctorAvailabilitySlotRepository.save(doctorAvailabilitySlot);
            return true;
        }
        return false;
    }

    public DoctorAvailabilitySlot getSlotById(UUID slotId) {
        return doctorAvailabilitySlotRepository.findById(slotId).orElse(null);
    }
}
