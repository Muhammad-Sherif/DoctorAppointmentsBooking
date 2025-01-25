package DoctorAppointmentBooking.DoctorAppointments.internal.core.models;

import DoctorAppointmentBooking.AppointmentBooking.internal.domain.exceptions.BusinessRuleException;

public class DoctorAppointmentStatus {
    private Status status;

    public DoctorAppointmentStatus(Status status) {
        this.status = status;
    }

    public static DoctorAppointmentStatus booked() {
      return new DoctorAppointmentStatus(Status.booked);
    }
    public String getStatus() {
        return status.name();
    }
    public void changeToCompleted() {
        changeStatusValidation();
        status = Status.completed;
    }

    public void changeToCancel() {
        changeStatusValidation();
        status = Status.cancelled;
    }

    private void changeStatusValidation() {
        if(!status.equals(Status.booked)) {
            throw new BusinessRuleException("Can't change status to cancel because it's current status not booked");
        }
    }
}
