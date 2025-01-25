# Doctor Appointment Booking System  

## Project Overview  
A **modular monolith backend system** for managing a single doctor's appointment lifecycle:  
- Handles **availability**, **booking**, **confirmation**, and **management** of appointments.  
- Implements **four distinct architectural patterns** across modules to meet business requirements.  

---

## Business Requirements  

### 🩺 Doctor Availability  
- **List/Create Time Slots** with properties:  
  - `Id` (Guid)  
  - `Time` (DateTime, e.g., *22/02/2023 04:30 pm*)  
  - `DoctorId` (Guid)  
  - `DoctorName` (string)  
  - `IsReserved` (bool, default: `false`)  
  - `Cost` (Decimal)  

### 📅 Appointment Booking  
- **View Available Slots** (unreserved only).  
- **Book Appointments** with properties:  
  - `Id` (Guid)  
  - `SlotId` (Guid)  
  - `PatientId` (Guid)  
  - `PatientName` (string)  
  - `ReservedAt` (DateTime)  

### ✅ Appointment Confirmation  
- **Log Confirmation Notifications** with:  
  - Patient name  
  - Appointment time  
  - Doctor name  

### 🗂️ Doctor Appointment Management  
- **View Upcoming Appointments**.  
- **Update Status**: Mark as completed or canceled.  

### 💾 Data Persistence  
- Supports **in-memory storage** or **database engines**.  

---

## Architecture  

| Module                   | Architecture                  | Key Characteristics                              |  
|--------------------------|-------------------------------|--------------------------------------------------|  
| **Doctor Availability**  | Traditional Layered           | Separated into Presentation, Business, Data layers. |  
| **Appointment Booking**  | Clean Architecture            | Domain-centric with decoupled layers (Domain, Application, Infrastructure). |  
| **Appointment Confirmation** | Simplest Architecture     | Single logging service (e.g., `Console.WriteLine`). |  
| **Appointment Management** | Hexagonal (Ports & Adapters) | Core logic isolated via ports (interfaces) and adapters (implementations). |  

---

## Key Features  
- **Modular Monolith**: Independent modules with clear boundaries.  
- **Architectural Diversity**: Demonstrates layered, clean, hexagonal, and minimalistic designs.  
- **Event-Driven Confirmation**: Log-based notifications triggered by booking events.  

