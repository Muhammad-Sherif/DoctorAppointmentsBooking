package DoctorAppointmentBooking.shared.abstractions;

public interface IQueryHandler<TQuery extends IQuery,TResult> {

    TResult handle(TQuery query);

}
