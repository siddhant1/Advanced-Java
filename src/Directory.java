import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



class CustomerOperations{
	static ArrayList<Customer> customers =  new ArrayList<>();
	static void addCustomer(int id,String name,String city) {
		Customer customer = new Customer(id,name,city);
		customers.add(customer);
	}
	
	static void getCustomers() {
		System.out.println(customers);
	}

	public static void sortCustomers(int sortMech) {
		Collections.sort(customers,new Comparator<Customer>() {

			@Override
			public int compare(Customer o1, Customer o2) {
				return ((Integer)o1.getId()).compareTo(o2.getId());
			}
		});
//		if(sortMech==1) {
//			Collections.sort(customers,(first,second)->first.getCity().compareTo(second.getCity()));
//			getCustomers();
//		}else if(sortMech==2) {
//			Collections.sort(customers,(first,second)->first.getName().compareTo(second.getName()));
//		}
	}
	
	public static String search(int id) {
		Customer c =  new Customer(id,null,null);
		return customers.contains(c)?"Found":"Not found";
	}
	
}

class Customer{
	private int id;
	private String name;
	private String city;
	public Customer(int id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Customer)) {
			return false;
		}
		Customer other = (Customer) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}
	}
	
	
public class Directory {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
		System.out.println("1.Print");
		System.out.println("2.Add a Customer");
		System.out.println("3.Sort Customers");
		System.out.println("4.Search Customers");
		int choice = scanner.nextInt();
		switch(choice) {
		case 1:
			CustomerOperations.getCustomers();
			break;
		case 2:
			int id =scanner.nextInt();
			String name = scanner.next();
			String city = scanner.next();
			CustomerOperations.addCustomer(id, name, city);
			CustomerOperations.getCustomers();
			break;
		case 3:
			CustomerOperations.sortCustomers(1);
			break;
		case 4:
			int id1 = scanner.nextInt();
			System.out.println(CustomerOperations.search(id1));
		  }
	  }
   }
}


