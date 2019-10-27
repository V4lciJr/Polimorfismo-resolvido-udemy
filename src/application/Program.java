package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner tec = new Scanner(System.in);
		
		Employee emp;
		List<Employee> list = new ArrayList<>();
				
		System.out.print("Enter the number of employees: ");
		int n = tec.nextInt();
		
		for(int i = 1; i <= n; i++)
		{
			System.out.println("Employee #"+ i + " data:");
			System.out.print("Outsourced (y/n)? ");
			char response = tec.next().charAt(0);
			System.out.print("Name: ");
			tec.nextLine();
			String name = tec.nextLine();
			System.out.print("Hours: ");
			int hours = tec.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = tec.nextDouble();
			
			if(response == 'y')
			{
				System.out.print("Additional charge: ");
				double additionalCharge = tec.nextDouble();
				emp = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
				list.add(emp);
			}
			else
			{
				list.add(new Employee(name, hours, valuePerHour));
			}
		}
		
		System.out.println();
		System.out.println("PAYMENTS:");
		
		for(Employee employee : list)
		{
			System.out.println(employee.getName() +" - $ " +String.format("%.2f", employee.payment()));
		}
		
		tec.close();
	}

}
