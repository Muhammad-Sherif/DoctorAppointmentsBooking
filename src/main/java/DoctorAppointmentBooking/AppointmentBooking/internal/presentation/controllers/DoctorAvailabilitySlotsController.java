package DoctorAppointmentBooking.AppointmentBooking.internal.presentation.controllers;

import DoctorAppointmentBooking.AppointmentBooking.internal.application.queries.GetDoctorsAvailableSlots.GetDoctorsAvailableSlotsHandler;
import DoctorAppointmentBooking.AppointmentBooking.internal.application.queries.GetDoctorsAvailableSlots.GetDoctorsAvailableSlotsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController("AppointmentBookingDoctorAvailabilitySlotsController")
public class DoctorAvailabilitySlotsController {
    private final GetDoctorsAvailableSlotsHandler handler;

    public DoctorAvailabilitySlotsController(GetDoctorsAvailableSlotsHandler handler) {
        this.handler = handler;
    }
    @GetMapping("/v1/doctors/slots/available")
    public ResponseEntity<?> getDoctorsAvailableSlots() {
        GetDoctorsAvailableSlotsResponse doctorsAvailableSlotsResponse = handler.handle();
        return ResponseEntity.status(HttpStatus.OK).body(doctorsAvailableSlotsResponse);
    }
}