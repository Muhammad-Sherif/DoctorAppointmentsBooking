package DoctorAppointmentBooking.AppointmentBooking.internal.application.command.BookAppointment;

import DoctorAppointmentBooking.shared.abstractions.ICommand;

import java.util.UUID;

public record BookAppointmentCommand(UUID slotId, UUID patientId,String patientName) implements ICommand {
}
