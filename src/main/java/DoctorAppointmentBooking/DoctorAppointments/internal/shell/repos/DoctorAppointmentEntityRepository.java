package DoctorAppointmentBooking.DoctorAppointments.internal.shell.repos;

import DoctorAppointmentBooking.DoctorAppointments.internal.shell.db.DoctorAppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DoctorAppointmentEntityRepository extends JpaRepository<DoctorAppointmentEntity, UUID> {
    @Query(value = "SELECT * FROM doctor_appointments WHERE doctorId = :doctorId AND DATE >= CURRENT_DATE",nativeQuery = true)
    List<DoctorAppointmentEntity> getUpcomingAppointments(UUID doctorId);
}