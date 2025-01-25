package DoctorAppointmentBooking.DoctorAvailability.external;

public record ReservedSlotInfoResponse(boolean isReserved, DoctorSlotResponse slot) {
}
