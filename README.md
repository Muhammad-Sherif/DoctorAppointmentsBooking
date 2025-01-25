📋 Project Overview
This project is a modular monolith backend system for a doctor appointment booking application, designed to manage a single doctor's availability, patient bookings, appointment confirmations, and appointment management. The system emphasizes modular architecture by implementing four distinct architectural patterns across its modules, as per the business requirements.

🎯 Business Requirements Summary
Doctor Availability
List and add time slots with properties:
Id, Time, DoctorId, DoctorName, IsReserved, Cost.

Slots are non-reserved by default.

Appointment Booking
Patients can view all available slots (unreserved).

Book appointments with properties:
Id, SlotId, PatientId, PatientName, ReservedAt.

Appointment Confirmation
Send confirmation notifications (via log messages) containing:
Patient name, appointment time, and doctor name.

Doctor Appointment Management
View upcoming appointments.

Mark appointments as completed or cancel them.

Data Persistence
Flexible storage (in-memory or database).

🏗️ Architectural Approach
The system is divided into four modules, each adhering to a specific architecture:

Module	Architecture	Key Focus
Doctor Availability	Traditional Layered	Separation of concerns (Presentation, Business, Data layers).
Appointment Booking	Clean Architecture	Decoupled layers with dependency inversion (Domain, Application, Infrastructure).
Appointment Confirmation	Simplest Architecture	Minimalist design (single module/service for logging).
Appointment Management	Hexagonal (Ports & Adapters)	Isolation of business logic from external systems (APIs, DB).
🧩
