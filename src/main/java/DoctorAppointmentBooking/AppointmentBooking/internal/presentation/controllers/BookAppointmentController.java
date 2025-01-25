package DoctorAppointmentBooking.AppointmentBooking.internal.presentation.controllers;

import DoctorAppointmentBooking.shared.abstractions.INoInputQueryHandler;
import DoctorAppointmentBooking.AppointmentBooking.internal.application.command.BookAppointment.BookAppointmentCommand;
import DoctorAppointmentBooking.AppointmentBooking.internal.application.command.BookAppointment.BookAppointmentHandler;
import DoctorAppointmentBooking.AppointmentBooking.internal.application.command.BookAppointment.BookAppointmentResponse;
import DoctorAppointmentBooking.AppointmentBooking.internal.presentation.bodies.BookAppointmentBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookAppointmentController {
    private final BookAppointmentHandler bookAppointmentHandler;
    public BookAppointmentController(BookAppointmentHandler bookAppointmentHandler, INoInputQueryHandler iNoInputQueryHandler) {
        this.bookAppointmentHandler = bookAppointmentHandler;
    }

     @PostMapping("/book-appointment")
     public ResponseEntity<?> bookAppointment(@RequestBody BookAppointmentBody bookAppointmentBody) {
         BookAppointmentResponse bookAppointmentResponse = bookAppointmentHandler.handle(new BookAppointmentCommand(
                 bookAppointmentBody.slotId(),
                 bookAppointmentBody.patientId(),
                 bookAppointmentBody.patientName()));

         return ResponseEntity.status(HttpStatus.CREATED).body(bookAppointmentResponse);


     }
}
