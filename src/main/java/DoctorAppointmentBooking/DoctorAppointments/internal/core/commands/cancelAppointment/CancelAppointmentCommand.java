package DoctorAppointmentBooking.DoctorAppointments.internal.core.commands.cancelAppointment;

import DoctorAppointmentBooking.shared.abstractions.ICommand;

import java.util.UUID;

public record CancelAppointmentCommand(UUID appointmentId) implements ICommand {
}
