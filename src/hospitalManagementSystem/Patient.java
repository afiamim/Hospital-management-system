package hospitalManagementSystem;

public class Patient extends Person {

	 private String patientId;
	    private String disease;

	    public Patient(String name, int age, String gender, String patientId, String disease) {
	        super(name, age, gender);
	        this.patientId = patientId;
	        this.disease = disease;
	    }

	    public String getPatientId() { 
	    	return patientId; 
	    	
	    }
	    
	    public String getDisease() { 
	    	return disease; 
	    	
	    }
	    @Override
	    public void displayInfo() {
	        System.out.println("Patient ID: " + getPatientId());
	        System.out.println("Name: " + getName());
	        System.out.println("Age: " + getAge());
	        System.out.println("Gender: " + getGender());
	        System.out.println("Disease: " + getDisease());
	    }

	    public String toFileString() {
	        return patientId + "," + getName() + "," + getAge() + "," + getGender() + "," + disease;
	    }
}
