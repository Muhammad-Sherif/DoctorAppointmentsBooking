package DoctorAppointmentBooking.shared.abstractions;

public interface ICommandHandler<TCommand extends ICommand,TResponse>  {
    TResponse handle(TCommand command);
}
