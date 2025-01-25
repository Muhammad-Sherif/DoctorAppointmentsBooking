package DoctorAppointmentBooking.DoctorAppointments.internal.shell.presentation.apis;

import DoctorAppointmentBooking.DoctorAppointments.internal.core.commands.cancelAppointment.CancelAppointmentCommand;
import DoctorAppointmentBooking.DoctorAppointments.internal.core.commands.cancelAppointment.CancelAppointmentHandler;
import DoctorAppointmentBooking.DoctorAppointments.internal.core.commands.completeAppointment.CompleteAppointmentCommand;
import DoctorAppointmentBooking.DoctorAppointments.internal.core.commands.completeAppointment.CompleteAppointmentHandler;
import DoctorAppointmentBooking.DoctorAppointments.internal.core.queries.getUpcommingAppointments.UpComingAppointmentsHandler;
import DoctorAppointmentBooking.DoctorAppointments.internal.core.queries.getUpcommingAppointments.UpComingAppointmentsQuery;
import DoctorAppointmentBooking.DoctorAppointments.internal.core.queries.getUpcommingAppointments.UpComingAppointmentsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DoctorAppointmentController {
    private final CancelAppointmentHandler cancelAppointmentCommand;
    private final CompleteAppointmentHandler completeAppointmentHandler;
    private final UpComingAppointmentsHandler upComingAppointmentsHandler;


    public DoctorAppointmentController(CancelAppointmentHandler cancelAppointmentHandler, CompleteAppointmentHandler completeAppointmentHandler, UpComingAppointmentsHandler upComingAppointmentsHandler) {
        this.cancelAppointmentCommand = cancelAppointmentHandler;
        this.completeAppointmentHandler = completeAppointmentHandler;
        this.upComingAppointmentsHandler = upComingAppointmentsHandler;
    }

    @PatchMapping("doctors/appointments/{appointmentId}/cancel")
    public ResponseEntity<Void> cancel(@PathVariable UUID appointmentId) {
        cancelAppointmentCommand.handle(new CancelAppointmentCommand(appointmentId));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("doctors/appointments/{appointmentId}/complete")
    public ResponseEntity<Void> compelete(@PathVariable UUID appointmentId) {
        completeAppointmentHandler.handle(new CompleteAppointmentCommand(appointmentId));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("doctors/{doctorId}/appointments/up-coming")
    public ResponseEntity<?> getUpCommingAppointments(@PathVariable  UUID doctorId) {
        UpComingAppointmentsResponse upComingAppointmentsResponse = upComingAppointmentsHandler.handle(new UpComingAppointmentsQuery(doctorId));
        return ResponseEntity.ok(upComingAppointmentsHandler);
    }

}
