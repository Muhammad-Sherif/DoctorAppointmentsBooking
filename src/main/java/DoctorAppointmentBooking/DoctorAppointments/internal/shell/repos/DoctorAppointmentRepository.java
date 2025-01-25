package DoctorAppointmentBooking.DoctorAppointments.internal.shell.repos;

import DoctorAppointmentBooking.DoctorAppointments.internal.core.abstractions.IDoctorAppointmentRepository;
import DoctorAppointmentBooking.DoctorAppointments.internal.core.models.DoctorAppointment;
import DoctorAppointmentBooking.DoctorAppointments.internal.core.queries.projections.UpComingAppointmentsProjection;
import DoctorAppointmentBooking.DoctorAppointments.internal.shell.db.DoctorAppointmentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class DoctorAppointmentRepository implements IDoctorAppointmentRepository {
    private final DoctorAppointmentEntityRepository doctorAppointmentEntityRepository;


    public DoctorAppointmentRepository(DoctorAppointmentEntityRepository doctorAppointmentEntityRepository) {
        this.doctorAppointmentEntityRepository = doctorAppointmentEntityRepository;
    }

    @Override
    public UpComingAppointmentsProjection getUpcomingAppointments(UUID doctorId) {
        List<DoctorAppointmentEntity> upComingAppointments = doctorAppointmentEntityRepository.getUpcomingAppointments(doctorId);
        return DoctorAppointmentMapper.toUpComingAppointmentsProjection(doctorId,upComingAppointments);
    }

    @Override
    public void save(DoctorAppointment doctorAppointment) {
        doctorAppointmentEntityRepository.save(DoctorAppointmentMapper.toEntity(doctorAppointment));
    }

    @Override
    public Optional<DoctorAppointment> getById(UUID id) {
        Optional<DoctorAppointmentEntity> doctorAppointmentEntity = doctorAppointmentEntityRepository.findById(id);
        return DoctorAppointmentMapper.toDomain(doctorAppointmentEntity);

    }

}
