package hospitalManagementSystem;
import java.io.*;
public class Bill {
	 private Patient patient;
	    private double consultFee, medFee, labFee;

	   public Bill(Patient p, double consultFee, double medFee, double labFee) {
	        patient = p;
	        this.consultFee = consultFee;
	        this.medFee = medFee;
	        this.labFee = labFee;
	    }

	    public double getTotal() {
	        return consultFee + medFee + labFee;
	    }

	    public void printBill() throws IOException {
	        String bill = "Bill for: " + patient.getName() + "\nConsultation: $" + consultFee +
	                      "\nMedicine: $" + medFee + "\nLab: $" + labFee +
	                      "\nTotal: $" + getTotal() + "\n";
	        System.out.println(bill);

	        FileWriter fw = new FileWriter("bills.txt", true);
	        fw.write(bill + "------------------------\n");
	        fw.close();
	    }
}
