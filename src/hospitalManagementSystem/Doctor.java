package hospitalManagementSystem;

public class Doctor extends Person {
    private String doctorId;
    private String specialization;

    public Doctor(String name, int age, String gender, String doctorId, String specialization) {
        super(name, age, gender);
        this.doctorId = doctorId;
        this.specialization = specialization;
    }
    
    public String getDoctorId() { 
    	return doctorId; 
    	
    }
    
    public String getSpecialization() { 
    	return specialization; 
    	
    }

    @Override
    public void displayInfo() {
        System.out.println("Doctor ID: " + getDoctorId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Specialization: " + getSpecialization());
    }

    public String toFileString() {
        return doctorId + "," + getName() + "," + getAge() + "," + getGender() + "," + specialization;
    }
}
