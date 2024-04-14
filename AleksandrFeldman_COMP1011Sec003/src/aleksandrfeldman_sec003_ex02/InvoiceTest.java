package aleksandrfeldman_sec003_ex02;

import java.util.ArrayList;

public class InvoiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Invoice> invoices=new ArrayList<Invoice>();
		invoices.add(new Invoice("87", "Electric Sander", 7, 57.98));
		invoices.add(new Invoice("24", "Power Saw", 18, 99.99));
		invoices.add(new Invoice("7", "Sledge Hammer", 11, 21.50));
		invoices.add(new Invoice("77", "Hammer", 76, 11.99));
		invoices.add(new Invoice("39", "Lawn Mower", 3, 79.50));
		invoices.add(new Invoice("68", "Screw Driver", 106, 6.99));
		invoices.add(new Invoice("56", "Jig saw", 21, 11.00));
		
		System.out.println("a. Sorted by part description:");
		invoices.stream()
		.sorted((i1, i2) ->i1.getPartDescription().compareTo(i2.getPartDescription()))
		.forEach(System.out::println);
		System.out.println();
		
		System.out.println("b. Sorted by price per item");
		invoices.stream()
		.sorted((i1, i2) ->Double.compare(i1.getPricePerItem(), i2.getPricePerItem()))
		.forEach(System.out::println);
		System.out.println();
		
		System.out.println("c. Mapped invoices to partDescription and quantity");
		invoices.stream()
		.sorted((i1, i2)->Integer.compare(i1.getQuantity(), i2.getQuantity()))
		.map(i->i.getPartDescription()+": "+i.getQuantity())
		.forEach(System.out::println);
		System.out.println();
		
		System.out.println("d. Mapped invoices to partDescription and value of the Invoice");
		invoices.stream()
		.sorted((i1, i2)->Double.compare(i1.getInvoiceAmount(), i2.getInvoiceAmount()))
		.map(i->i.getPartDescription()+": "+i.getInvoiceAmount())
		.forEach(System.out::println);
		System.out.println();
		
		System.out.println("e. Mapped invoices to partDescription and value of the Invoice and range from $200 to $500");
		invoices.stream()
		.filter(i -> i.getInvoiceAmount()>=200 && i.getInvoiceAmount()<=500)
		.sorted((i1, i2)->Double.compare(i1.getInvoiceAmount(), i2.getInvoiceAmount()))
		.map(i->i.getPartDescription()+": "+i.getInvoiceAmount())
		.forEach(System.out::println);
		System.out.println();
		
		System.out.println("f. partDescription contains 'saw'");
		invoices.stream()
		.filter(i->i.getPartDescription().toLowerCase().contains("saw"))
		.forEach(System.out::println);
	}

}
