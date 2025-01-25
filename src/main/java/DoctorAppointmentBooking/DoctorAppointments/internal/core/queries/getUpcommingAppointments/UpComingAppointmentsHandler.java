package DoctorAppointmentBooking.DoctorAppointments.internal.core.queries.getUpcommingAppointments;

import DoctorAppointmentBooking.DoctorAppointments.internal.core.abstractions.IDoctorAppointmentRepository;
import DoctorAppointmentBooking.DoctorAppointments.internal.core.queries.projections.UpComingAppointmentsProjection;
import DoctorAppointmentBooking.shared.abstractions.IQueryHandler;
import org.springframework.stereotype.Component;


@Component
public class UpComingAppointmentsHandler implements IQueryHandler<UpComingAppointmentsQuery, UpComingAppointmentsResponse> {
    private final IDoctorAppointmentRepository doctorAppointmentRepository;

    public UpComingAppointmentsHandler(IDoctorAppointmentRepository doctorAppointmentRepository) {
        this.doctorAppointmentRepository = doctorAppointmentRepository;
    }

    @Override
    public UpComingAppointmentsResponse handle(UpComingAppointmentsQuery query) {
        UpComingAppointmentsProjection upComingAppointmentsProjection
                = doctorAppointmentRepository.getUpcomingAppointments(query.doctorId());

        upComingAppointmentsProjection.appointments().stream().map(
                app-> new UpComingAppointmentsResponse.Appointment(
                        app.patentId(),
                        app.patientName(),
                        app.date(),
                        app.startTime(),
                        app.endTime())
        );

        return new UpComingAppointmentsResponse(
                upComingAppointmentsProjection.doctorId()
                , upComingAppointmentsProjection.appointments().stream()
                .map(app -> new UpComingAppointmentsResponse.Appointment(
                        app.patentId(),
                        app.patientName(),
                        app.date(),
                        app.startTime(),
                        app.endTime())).toList()

        );

    }
}
