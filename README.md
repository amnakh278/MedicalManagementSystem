MedicalMangementSystem

This Medical Management System is an Android-based application designed to streamline and digitize patient-doctor interactions in a clinical environment. Built using Android Studio and integrated with Firebase Realtime Database, this project enables efficient management of appointments, treatment tracking, billing, and profile access for both doctors and patients.

The app consists of two primary modules: Patient Interface and Doctor Interface, each designed with specific features to simplify their respective workflows.

Patient Module

Patient Creation
Patients can register into the system by creating a unique profile, which includes basic personal and medical information. This data is stored in Firebase for easy access and management.

Patient Home
Upon login, the patient lands on the Patient Home screen where they can view their personal details including name, ID, and other relevant profile information.

Bills History
Patients can browse through their billing history, which lists all previously completed appointments along with generated bills. This provides transparency and helps patients track their medical expenses.

Treatment History
This section allows patients to view a chronological history of treatments, including diagnosis, prescriptions, and any progress updates made by the doctor for completed appointments.

Patient Appointment
Patients can request and manage their appointments with doctors. The system ensures proper logging and status tracking (pending, accepted, rejected) of these appointments.

Doctor Module

Doctor Profile
Doctors can view their profile by entering their unique doctor ID. The profile includes personal details and professional information stored in Firebase.

Pending Appointments
This section displays all pending appointment requests for the doctor based on their ID. Doctors can review appointment details before making a decision.

Today’s Appointments
Here, doctors can view all appointments scheduled for the current day. They can accept or reject appointments in real-time to manage their daily schedule effectively.

History Update
For each completed appointment, doctors can update the patient's treatment history, including:

Prescription

Diagnosis/disease name

Progress or follow-up notes

Generate Bill
After updating the treatment history, doctors can generate and submit a medical bill, which is saved under the patient’s record and made visible in their Bills History.

Patient History
Doctors can access the complete treatment history of all patients they have treated, providing a centralized view of ongoing or past cases.

Tech Stack

Language: Java

IDE: Android Studio

Backend: Firebase Realtime Database

Authentication: Firebase Authentication

UI: XML Layouts

Features

Firebase-powered real-time data syncing

Separate roles and workflows for doctors and patients

Appointment status management

Secure, structured history of treatments and bills

Minimal, user-friendly UI for both parties
