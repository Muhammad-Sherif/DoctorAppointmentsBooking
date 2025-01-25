package DoctorAppointmentBooking.DoctorAvailability.internal.presentation.controllers;

import DoctorAppointmentBooking.DoctorAvailability.internal.business.records.NewSlot;
import DoctorAppointmentBooking.DoctorAvailability.internal.business.services.DoctorAvailabilitySlotsService;
import DoctorAppointmentBooking.DoctorAvailability.internal.data.models.DoctorAvailabilitySlot;
import DoctorAppointmentBooking.DoctorAvailability.internal.presentation.bodies.CreateSlotBody;
import DoctorAppointmentBooking.DoctorAvailability.internal.presentation.mappers.DoctorAvailabilitySlotsMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class DoctorAvailabilitySlotsController {
    private final DoctorAvailabilitySlotsService doctorAvailabilitySlotsService;
    private final DoctorAvailabilitySlotsMapper doctorAvailabilitySlotsMapper;
    public DoctorAvailabilitySlotsController(DoctorAvailabilitySlotsService slotService, DoctorAvailabilitySlotsMapper doctorAvailabilitySlotsMapper) {
        this.doctorAvailabilitySlotsService = slotService;
        this.doctorAvailabilitySlotsMapper = doctorAvailabilitySlotsMapper;
    }

    @GetMapping("/v1/doctors/{id}/slots")
    public ResponseEntity<List<DoctorAvailabilitySlot>> getAvailableSlotsForDoctor(@PathVariable("id") UUID doctorId) {
        List<DoctorAvailabilitySlot> doctorAvailabilitySlotList = doctorAvailabilitySlotsService.getSlotsForDoctor(doctorId);
        return ResponseEntity.ok(doctorAvailabilitySlotList);

    }

    @PostMapping("/v1/doctors/slots")
    public ResponseEntity<Void> createSlot(@RequestBody CreateSlotBody createSlotBody) {
        NewSlot createSlot = doctorAvailabilitySlotsMapper.mapToCreateSlot(createSlotBody);
        doctorAvailabilitySlotsService.createNewSlot(createSlot);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
