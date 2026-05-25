/*package hospitalManagementSystem;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    public static void writeLineToFile(String filename, String data) throws IOException {
        FileWriter fw = new FileWriter(filename, true);
        fw.write(data + "\n");
        fw.close();
    }

    public static void exportPatient(Patient p) throws IOException {
        String line = p.getPatientId() + "," + p.getName() + "," + p.getAge() + "," + p.getGender() + "," + p.getDisease();
        writeLineToFile("patients.txt", line);
    }

    public static void exportDoctor(Doctor d) throws IOException {
        String line = d.getDoctorId() + "," + d.getName() + "," + d.getAge() + "," + d.getGender() + "," + d.getSpecialization();
        writeLineToFile("doctors.txt", line);
    }

    public static void exportAppointment(Appointment a) throws IOException {
        String line = "Appointment: " + a.patient.getName() + ", Dr. " + a.doctor.getName() + ", Date: " + a.date;
        writeLineToFile("appointments.txt", line);
    }

    public static void exportBill(Patient p, double consultFee, double medFee, double labFee, double total) throws IOException {
        String bill = "Bill for: " + p.getName() + "\nConsultation: $" + consultFee +
                "\nMedicine: $" + medFee + "\nLab: $" + labFee +
                "\nTotal: $" + total + "\n------------------------";
        writeLineToFile("bills.txt", bill);
    }

    public static void exportFullReport(List<Patient> patients, List<Doctor> doctors, List<Appointment> appointments) throws IOException {
        FileWriter fw = new FileWriter("report.txt");
        fw.write("=== SmartCare Hospital Report ===\n\n");

        fw.write("--- Patients ---\n");
        for (Patient p : patients)
            fw.write(p.getPatientId() + ": " + p.getName() + ", " + p.getDisease() + "\n");

        fw.write("\n--- Doctors ---\n");
        for (Doctor d : doctors)
            fw.write(d.getDoctorId() + ": " + d.getName() + ", " + d.getSpecialization() + "\n");

        fw.write("\n--- Appointments ---\n");
        for (Appointment a : appointments)
            fw.write(a.patient.getName() + " with Dr. " + a.doctor.getName() + " on " + a.date + "\n");

        fw.close();
    }
}*/



package hospitalManagementSystem;

import java.io.*;
import java.util.ArrayList;

class FileManager {
    public static void writeToFile(String filename, String content) throws IOException {
        FileWriter fw = new FileWriter(filename, true);
        fw.write(content);
        fw.close();
    }

    public static ArrayList<String> readFromFile(String filename) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        File file = new File(filename);
        if (!file.exists()) return lines;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null)
            lines.add(line);
        br.close();
        return lines;
    }
}
