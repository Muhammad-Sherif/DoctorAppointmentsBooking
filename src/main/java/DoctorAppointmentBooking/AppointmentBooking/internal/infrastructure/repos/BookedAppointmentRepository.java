package DoctorAppointmentBooking.AppointmentBooking.internal.infrastructure.repos;

import DoctorAppointmentBooking.AppointmentBooking.internal.domain.abstraction.IBookedAppointmentRepository;
import DoctorAppointmentBooking.AppointmentBooking.internal.domain.models.BookedAppointment;
import DoctorAppointmentBooking.AppointmentBooking.internal.infrastructure.repos.mappers.BookedAppointmentMapper;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class BookedAppointmentRepository implements IBookedAppointmentRepository {

    private final BookedAppointmentEntityRepository bookedAppointmentEntityRepository;
    private final BookedAppointmentMapper bookedAppointmentMapper;

    public BookedAppointmentRepository(BookedAppointmentEntityRepository bookedAppointmentEntityRepository, BookedAppointmentMapper bookedAppointmentMapper) {
        this.bookedAppointmentEntityRepository = bookedAppointmentEntityRepository;
        this.bookedAppointmentMapper = bookedAppointmentMapper;
    }

    @Override
    public void save(BookedAppointment bookedAppointment) {
        bookedAppointmentEntityRepository.save(bookedAppointmentMapper.mapToEntity(bookedAppointment));
    }

    @Override
    public BookedAppointment findById(UUID id) {
        return null;
    }
}