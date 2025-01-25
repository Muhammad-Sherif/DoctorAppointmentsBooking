package DoctorAppointmentBooking.AppointmentBooking.internal.infrastructure.repos;

import DoctorAppointmentBooking.AppointmentBooking.internal.infrastructure.db.BookedAppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookedAppointmentEntityRepository extends JpaRepository<BookedAppointmentEntity, UUID> {
}