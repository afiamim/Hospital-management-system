package hospitalManagementSystem;
//implements the interface
public class Appointment implements Bookable {
    private Patient patient;
    private Doctor doctor;
    private String date;

    public Appointment(Patient patient, Doctor doctor, String date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    @Override
    public void book() {
        System.out.println("Appointment booked on " + date + " for patient " + patient.getName() + " with Dr. " + doctor.getName());
    }

    public String toFileString() {
        return patient.getName() + "," + doctor.getName() + "," + date;
    }
}

