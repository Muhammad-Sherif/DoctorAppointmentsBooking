package DoctorAppointmentBooking.DoctorAvailability.internal.data.repos;

import DoctorAppointmentBooking.DoctorAvailability.internal.data.models.DoctorAvailabilitySlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DoctorAvailabilitySlotRepository extends JpaRepository<DoctorAvailabilitySlot, UUID> {


  @Query(value = "SELECT * FROM doctor_availability_slots WHERE doctor_id = :doctorId" ,nativeQuery = true)
  List<DoctorAvailabilitySlot> getSlotsByDoctorId(UUID doctorId);
  @Query(value = """
    SELECT EXISTS (
        SELECT 1
        FROM doctor_availability_slots
        WHERE doctor_id = :doctorId
          AND date = CAST(:date AS DATE)
          AND start_time = :startTime
          AND end_time = :endTime
    )
    """, nativeQuery = true)
  boolean existsByDateRange(UUID doctorId, LocalDate date, LocalTime startTime, LocalTime endTime);

  @Query(value = "SELECT * FROM doctor_availability_slots WHERE is_reserved = false" ,nativeQuery = true)
  List<DoctorAvailabilitySlot> getAvailableSlots();

  @Modifying
  @Query(value = "UPDATE doctor_availability_slots SET is_reserved = true where id = :slotId", nativeQuery = true)
  void updateSlotAsReserved(UUID slotId);

  @Query(value = "SELECT * FROM doctor_availability_slots WHERE id = :slotId FOR UPDATE", nativeQuery = true)
  Optional<DoctorAvailabilitySlot> findByIdWithLock(UUID slotId);

}