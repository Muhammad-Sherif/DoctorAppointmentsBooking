package DoctorAppointmentBooking.DoctorAppointments.internal.core.models;


import java.util.UUID;

public class DoctorAppointment {

    private UUID id;
    private Doctor doctor;
    private Appointment appointment;
    private DoctorAppointmentStatus status;


    public DoctorAppointment(UUID id, Doctor doctor, Appointment appointment, DoctorAppointmentStatus status) {
        this.id = id;
        this.doctor = doctor;
        this.appointment = appointment;
        this.status = status;
    }

    public static DoctorAppointment newDoctorAppointment(NewDoctorAppointmentProb prob) {


        return new DoctorAppointment(
                UUID.randomUUID(),
                new Doctor(prob.doctorId(),prob.doctorName()),
                new Appointment(prob.patientId(),
                        prob.patientName(),
                        prob.slotId(),
                        prob.date(),
                        prob.startTime(),
                        prob.endTime()
                ),
                DoctorAppointmentStatus.booked()

        );
    }

    public static DoctorAppointment create(DoctorAppointmentProb prob) {


        return new DoctorAppointment(
                UUID.randomUUID(),
                new Doctor(prob.doctorId(),prob.doctorName()),
                new Appointment(prob.patientId(),
                        prob.patientName(),
                        prob.slotId(),
                        prob.date(),
                        prob.startTime(),
                        prob.endTime()
                ),
                DoctorAppointmentStatus.booked()

        );
    }


    public UUID getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public DoctorAppointmentStatus getStatus() {
        return status;
    }

    public void completeAppointment() {
        status.changeToCompleted();
    }
    public void cancelAppointment() {
        status.changeToCancel();
    }

}
