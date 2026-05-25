/*package hospitalManagementSystem;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;


public class HospitalManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Patient> patients = new ArrayList<>();
        ArrayList<Doctor> doctors = new ArrayList<>();
        ArrayList<Appointment> appointments = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. View Appointments");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.print("Name: ");
                        String pname = sc.nextLine();
                        System.out.print("Age: ");
                        int page = sc.nextInt(); sc.nextLine();
                        System.out.print("Gender: ");
                        String pgender = sc.nextLine();
                        System.out.print("Patient ID: ");
                        String pid = sc.nextLine();
                        System.out.print("Disease: ");
                        String disease = sc.nextLine();
                        Patient patient = new Patient(pname, page, pgender, pid, disease);
                        patients.add(patient);
                        FileManager.writeLineToFile("patients.txt", patient.toFileString());
                        System.out.println("Patient added.");
                        break;

                    case 2:
                        System.out.print("Name: ");
                        String dname = sc.nextLine();
                        System.out.print("Age: ");
                        int dage = sc.nextInt(); sc.nextLine();
                        System.out.print("Gender: ");
                        String dgender = sc.nextLine();
                        System.out.print("Doctor ID: ");
                        String did = sc.nextLine();
                        System.out.print("Specialization: ");
                        String spec = sc.nextLine();
                        Doctor doctor = new Doctor(dname, dage, dgender, did, spec);
                        doctors.add(doctor);
                        FileManager.writeLineToFile("doctors.txt", doctor.toFileString());
                        System.out.println("Doctor added.");
                        break;

                    case 3:
                        if (patients.isEmpty() || doctors.isEmpty()) {
                            System.out.println("Add patient and doctor first.");
                            break;
                        }

                        System.out.println("Select Patient:");
                        for (int i = 0; i < patients.size(); i++) {
                            System.out.println(i + ". " + patients.get(i).getName());
                        }
                        int pi = sc.nextInt(); 

                        System.out.println("Select Doctor:");
                        for (int i = 0; i < doctors.size(); i++) {
                            System.out.println(i + ". " + doctors.get(i).getName());
                        }
                        int di = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Date (YYYY-MM-DD): ");
                        String date = sc.nextLine();

                        Appointment appt = new Appointment(patients.get(pi), doctors.get(di), date);
                        appt.book(); 
                        appointments.add(appt);
                        FileManager.writeLineToFile("appointments.txt", appt.toFileString());
                        break;

                    case 4:
                        for (Appointment a : appointments) {
                            a.book(); // display info
                        }
                        break;

                    case 5:
                    	System.out.println("Name: ");
                    	String p = sc.nextLine();
                    	System.out.println("Consult Fee: ");
                    	double consultFee = sc.nextDouble();
                    	System.out.println("Medical Fee: ");
                    	double medFee = sc.nextDouble();
                    	System.out.println("Lab Fee: ");
                    	double labFee = sc.nextDouble();
                    	//Bill b = new Bill(p,consultFee,medFee,labFee);
                        break;
                    	
                    case 6:
                        System.out.println("Exiting system.");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }

            } 
             catch (IOException e) {
                System.out.println("File error: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
*/


package hospitalManagementSystem;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public class HospitalManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        if (!adminLogin()) {
            System.out.println("Login failed. Exiting system.");
            return;
        }

        boolean run = true;
        while (run) {
            System.out.println("\n--- SmartCare Hospital Management ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. Generate Bill");
            System.out.println("5. Search Patient/Doctor");
            System.out.println("6. Export Reports");
            System.out.println("7. Exit");
            System.out.print("Choose: ");

            try {
                int choice = sc.nextInt(); sc.nextLine();
                switch (choice) {
                    case 1 -> addPatient();
                    case 2 -> addDoctor();
                    case 3 -> bookAppointment();
                    case 4 -> generateBill();
                    case 5 -> searchPerson();
                    case 6 -> exportReports();
                    case 7 -> run = false;
                    default -> System.out.println("Invalid option.");
                }
            }  catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    static boolean adminLogin() {
        Admin admin = new Admin();
        System.out.print("Enter admin username: ");
        String user = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        if (admin.login(user, pass)) {
            System.out.println("Login successful. Welcome, Admin!");
            return true;
        } else {
            System.out.println("Invalid credentials.");
            return false;
        }
    }

    static void addPatient() throws IOException {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.println("Age: ");
        int age = sc.nextInt(); sc.nextLine();
        System.out.print("Gender: ");
        String gender = sc.nextLine();
        System.out.print("Disease: ");
        String disease = sc.nextLine();
        Patient p = new Patient( name, age, gender, id, disease);
        patients.add(p);
        FileManager.writeToFile("patients.txt", id + "," + name + "," + age + "," + gender + "," + disease + "\n" );
        System.out.println("Patient added.");
    }

    static void addDoctor() throws IOException {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.println("Age: ");
        int age = sc.nextInt(); sc.nextLine();
        System.out.print("Gender: ");
        String gender = sc.nextLine();
        System.out.print("Specialization: ");
        String spec = sc.nextLine();
        Doctor d = new Doctor( name, age, gender,id, spec);
        doctors.add(d);
        FileManager.writeToFile("doctors.txt", id + "," + name + "," + age + "," + gender + "," + spec + "\n");
        System.out.println("Doctor added.");
    }

    static void bookAppointment() throws Exception {
        if (patients.isEmpty() || doctors.isEmpty()) {
            throw new Exception("Please add both patient and doctor first.");
        }
        System.out.println("Select Patient Index:");
        for (int i = 0; i < patients.size(); i++)
            System.out.println(i + ": " + patients.get(i).getName());

        int pIndex = sc.nextInt();
        System.out.println("Select Doctor Index:");
        for (int i = 0; i < doctors.size(); i++)
            System.out.println(i + ": " + doctors.get(i).getName());

        int dIndex = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Date: ");
        String date = sc.nextLine();
        Appointment appt = new Appointment(patients.get(pIndex), doctors.get(dIndex), date);
        appt.book();
        
        FileManager.writeToFile("appointments.txt", appt.toFileString());

        appointments.add(appt);
    }

    static void generateBill() throws Exception {
        if (patients.isEmpty()) throw new Exception("No patients available.");
        System.out.println("Select Patient Index for Billing:");
        for (int i = 0; i < patients.size(); i++)
            System.out.println(i + ": " + patients.get(i).getName());
        int i = sc.nextInt();
        System.out.print("Consultation Fee: ");
        double cf = sc.nextDouble();
        System.out.print("Medicine Fee: ");
        double mf = sc.nextDouble();
        System.out.print("Lab Fee: ");
        double lf = sc.nextDouble();
        Bill bill = new Bill(patients.get(i), cf, mf, lf);
        bill.printBill();
    }

    static void searchPerson() {
        System.out.print("Search by Name or ID: ");
        String key = sc.nextLine().toLowerCase();
        boolean found = false;

        for (Patient p : patients) {
            if (p.getName().toLowerCase().contains(key) || p.getPatientId().toLowerCase().equals(key)) {
                p.displayInfo();
                found = true;
            }
        }

        for (Doctor d : doctors) {
            if (d.getName().toLowerCase().contains(key) || d.getDoctorId().toLowerCase().equals(key)) {
                d.displayInfo();
                found = true;
            }
        }

        if (!found) System.out.println("No matching record found.");
    }

    static void exportReports() throws IOException {
        System.out.println("--- Report Exported to patients.txt, doctors.txt, appointments.txt ---");
    }
}

