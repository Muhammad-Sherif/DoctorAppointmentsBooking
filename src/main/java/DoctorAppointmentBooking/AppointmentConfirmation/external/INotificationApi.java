package DoctorAppointmentBooking.AppointmentConfirmation.external;

public interface INotificationApi {

    void notify(String topic,Object message);
}
