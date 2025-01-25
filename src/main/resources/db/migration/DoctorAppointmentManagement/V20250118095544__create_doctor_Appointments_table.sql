CREATE TABLE IF NOT EXISTS doctor_appointments (
    id uuid PRIMARY KEY,
    appointmentId uuid NOT NULL,
    slotId UUID UNIQUE NOT NULL,
    doctorId uuid NOT NULL,
    doctorName VARCHAR(255) NOT NULL,
    patientId uuid NOT NULL,
    patientName VARCHAR(255) NOT NULL,
    date DATE NOT NULL,
    startTime TIME NOT NULL,
    endTime TIME NOT NULL,
    status VARCHAR(255) NOT NULL

);