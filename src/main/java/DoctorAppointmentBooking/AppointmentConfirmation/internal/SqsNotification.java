package DoctorAppointmentBooking.AppointmentConfirmation.internal;

import DoctorAppointmentBooking.AppointmentConfirmation.external.INotificationApi;
import org.springframework.stereotype.Component;

@Component
public class SqsNotification implements INotificationApi {

    @Override
    public void notify(String topic, Object message) {
        // Send message to SQS
    }
}
