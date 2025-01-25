package DoctorAppointmentBooking;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

class DoctorAppointmentBookingApplicationTests {

    @Test
    void contextLoads() {
        ApplicationModules modules = ApplicationModules.of(DoctorAppointmentBookingApplication.class);
        modules.verify();
    }

}
