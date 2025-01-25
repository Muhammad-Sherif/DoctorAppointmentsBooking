package DoctorAppointmentBooking.shared.abstractions;

public interface INoReturnCommandHandler<TCommand>  {
    void handle(TCommand command);
}
