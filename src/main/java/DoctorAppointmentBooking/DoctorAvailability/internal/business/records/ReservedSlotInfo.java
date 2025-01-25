package DoctorAppointmentBooking.DoctorAvailability.internal.business.records;

import DoctorAppointmentBooking.DoctorAvailability.internal.data.models.DoctorAvailabilitySlot;

public record ReservedSlotInfo(boolean isReserved, DoctorAvailabilitySlot slot) {



}
