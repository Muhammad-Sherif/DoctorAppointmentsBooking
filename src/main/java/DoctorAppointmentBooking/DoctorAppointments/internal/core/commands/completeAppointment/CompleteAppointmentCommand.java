package DoctorAppointmentBooking.DoctorAppointments.internal.core.commands.completeAppointment;

import DoctorAppointmentBooking.shared.abstractions.ICommand;

import java.util.UUID;

public record CompleteAppointmentCommand(UUID appointmentId) implements ICommand {
}
