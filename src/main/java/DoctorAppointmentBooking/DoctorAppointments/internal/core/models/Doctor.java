package DoctorAppointmentBooking.DoctorAppointments.internal.core.models;

import java.util.UUID;

public class Doctor {
    private UUID doctorId;
    private String doctorName;

    public Doctor(UUID doctorId, String doctorName) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }
}
