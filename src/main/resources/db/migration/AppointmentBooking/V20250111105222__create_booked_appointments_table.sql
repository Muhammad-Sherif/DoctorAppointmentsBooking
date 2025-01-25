CREATE SEQUENCE IF NOT EXISTS booked_appointments_id_seq;

CREATE TABLE IF NOT EXISTS booked_appointments (
    id uuid PRIMARY KEY,
    slot UUID UNIQUE NOT NULL,
    patient_id uuid NOT NULL,
    patient_name varchar(255) NOT NULL,
    reserved_at date NOT NULL
);