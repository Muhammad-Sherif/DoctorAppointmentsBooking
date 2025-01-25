package DoctorAppointmentBooking.DoctorAppointments.internal.core.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Appointment {
    private UUID patientId;
    private String patientName;
    private UUID slotId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public Appointment(UUID patientId, String patientName, UUID slotId, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.slotId = slotId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public UUID getSlotId() {
        return slotId;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
