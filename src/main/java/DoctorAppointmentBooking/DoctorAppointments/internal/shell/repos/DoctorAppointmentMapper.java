package DoctorAppointmentBooking.DoctorAppointments.internal.shell.repos;

import DoctorAppointmentBooking.DoctorAppointments.internal.core.models.DoctorAppointment;
import DoctorAppointmentBooking.DoctorAppointments.internal.core.models.DoctorAppointmentProb;
import DoctorAppointmentBooking.DoctorAppointments.internal.core.models.Status;
import DoctorAppointmentBooking.DoctorAppointments.internal.core.queries.projections.UpComingAppointmentsProjection;
import DoctorAppointmentBooking.DoctorAppointments.internal.shell.db.DoctorAppointmentEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DoctorAppointmentMapper {



    public static DoctorAppointmentEntity toEntity(DoctorAppointment doctorAppointment) {
        DoctorAppointmentEntity entity = new DoctorAppointmentEntity();

        entity.setId(doctorAppointment.getId());
        entity.setAppointmentId(doctorAppointment.getAppointment().getPatientId());
        entity.setSlotId(doctorAppointment.getAppointment().getSlotId());
        entity.setDoctorId(doctorAppointment.getDoctor().getDoctorId());
        entity.setDoctorName(doctorAppointment.getDoctor().getDoctorName());
        entity.setPatientId(doctorAppointment.getAppointment().getPatientId());
        entity.setPatientName(doctorAppointment.getAppointment().getPatientName());
        entity.setDate(doctorAppointment.getAppointment().getDate());
        entity.setStartTime(doctorAppointment.getAppointment().getStartTime());
        entity.setEndTime(doctorAppointment.getAppointment().getEndTime());
        entity.setStatus(doctorAppointment.getStatus().getStatus());

        return entity;
    }

    public static DoctorAppointment toDomain(DoctorAppointmentEntity entity) {
        DoctorAppointmentProb doctorAppointmentProb = new DoctorAppointmentProb(
                entity.getId(),
                entity.getAppointmentId(),
                entity.getPatientId(),
                entity.getPatientName(),
                entity.getDoctorId(),
                entity.getDoctorName(),
                entity.getSlotId(),
                entity.getDate(),
                entity.getStartTime(),
                entity.getEndTime(),
                mapStatus(entity.getStatus())
        );
        return DoctorAppointment.create(doctorAppointmentProb);
    }

    private static Status mapStatus(String status) {
        switch (status) {
            case "booked":
                return Status.booked;
            default:
                throw new IllegalArgumentException("Invalid status");
        }


    }

    public static UpComingAppointmentsProjection toUpComingAppointmentsProjection(UUID doctorId, List<DoctorAppointmentEntity> upComingAppointments) {
        List<UpComingAppointmentsProjection.AppointmentProjection> upComingAppointmentsProjections = upComingAppointments.stream().map(app ->
                new UpComingAppointmentsProjection.AppointmentProjection(
                        app.getPatientId(),
                        app.getPatientName(),
                        app.getDate(),
                        app.getStartTime(),
                        app.getEndTime()
                )
        ).toList();

        return new UpComingAppointmentsProjection(doctorId,upComingAppointmentsProjections);

    }

    public static Optional<DoctorAppointment> toDomain(Optional<DoctorAppointmentEntity> doctorAppointmentEntity) {
        if(doctorAppointmentEntity.isPresent()) {
            DoctorAppointment doctorAppointment = toDomain(doctorAppointmentEntity.get());
            return Optional.of(doctorAppointment);
        }
        return Optional.empty();
    }
}
