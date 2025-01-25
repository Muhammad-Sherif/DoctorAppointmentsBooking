

CREATE TABLE doctor_availability_slots (
    id uuid PRIMARY KEY,
    doctor_id uuid NOT NULL,
    doctor_name varchar(255) NOT NULL,
    date date NOT NULL,
    start_time time NOT NULL,
    end_time time NOT NULL,
    is_reserved boolean NOT NULL,
    cost double precision NOT NULL
);