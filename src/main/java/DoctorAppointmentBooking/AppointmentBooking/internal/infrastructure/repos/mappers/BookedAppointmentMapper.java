package DoctorAppointmentBooking.AppointmentBooking.internal.infrastructure.repos.mappers;

import DoctorAppointmentBooking.AppointmentBooking.internal.domain.models.BookedAppointment;
import DoctorAppointmentBooking.AppointmentBooking.internal.infrastructure.db.BookedAppointmentEntity;
import org.springframework.stereotype.Component;

@Component
public class BookedAppointmentMapper {

    public BookedAppointmentEntity mapToEntity(BookedAppointment bookedAppointment) {
        BookedAppointmentEntity entity = new BookedAppointmentEntity();
        entity.setId(bookedAppointment.getId());
        entity.setSlot(bookedAppointment.getSlotId());
        entity.setPatientId(bookedAppointment.getPatientId());
        entity.setPatientName(bookedAppointment.getPatientName());
        entity.setReservedAt(bookedAppointment.getReservedAt());
        return entity;
    }

}
