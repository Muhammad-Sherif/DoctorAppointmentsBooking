package DoctorAppointmentBooking.AppointmentBooking.internal.domain.models;


import DoctorAppointmentBooking.AppointmentBooking.internal.domain.abstraction.IDomainEvent;
import DoctorAppointmentBooking.AppointmentBooking.internal.domain.events.NewBookedAppointmentEvent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookedAppointment {

    private UUID id;

    private UUID slotId;

    private UUID patientId;

    private String patientName;

    private LocalDate reservedAt;

    private List<IDomainEvent> occurredEvents = new ArrayList<>();
    public BookedAppointment(UUID slot, UUID patientId, String patientName) {
        this.id = UUID.randomUUID();
        this.slotId = slot;
        this.patientId = patientId;
        this.patientName = patientName;
        this.reservedAt = LocalDate.now();

        occurredEvents.add(new NewBookedAppointmentEvent(this));
    }

    public UUID getId() {
        return id;
    }

    public UUID getSlotId() {
        return slotId;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public LocalDate getReservedAt() {
        return reservedAt;
    }

    public NewBookedAppointmentEvent getNewAppointmentEvent() {
        return (NewBookedAppointmentEvent) occurredEvents.stream().filter(e -> e instanceof NewBookedAppointmentEvent).findFirst().orElse(null);
    }
}