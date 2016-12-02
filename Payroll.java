
//Permanent employee provided hra,pf etc
//Temperory Employee no hra,pf only basic and special allowance

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

abstract class Employee{
	
private int empId;
private String empName;
private double basic;
int total=0;
public double getBasic() {
	return basic;
}
public void setBasic(double basic) {
	this.basic = basic;
}
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}


Employee()
{
	
}
Employee(int Id,String name,double basic)
{
	this.empId=Id;
	this.empName=name;
	this.basic=basic;
}
public abstract void calculate_balance_leaves();
public abstract boolean avail_leave(int no_of_leaves, char type_of_leave);
public abstract void calculate_salary();
public void display()
{
	System.out.println("Id of employee:" +getEmpId());
	System.out.println("Name of employee:" +getEmpName());
	System.out.println("Basic of employee:" +getBasic());
}
}
class PermanentEmp extends Employee{

	
	private int paidleave,sickleave,casualleave;
	private  int paid_leaves=0,sick_leaves=0,casual_leaves=0;
	private   double totalsalary=0.0;
	
	public int getPaidleave() {
		return paidleave;
	}
	public void setPaidleave(int paidleave) {
		this.paidleave = paidleave;
	}
	public int getSickleave() {
		return sickleave;
	}
	public void setSickleave(int sickleave) {
		this.sickleave = sickleave;
	}
	public int getCasualleave() {
		return casualleave;
	}
	public void setCasualleave(int casualleave) {
		this.casualleave = casualleave;
	}
	
	
	PermanentEmp(int Id,String name,double basic,int paid,int sick,int casual)
	{
	super(Id,name,basic)	; 
	this.paidleave=paid;
	this.sickleave=sick;
	this.casualleave=casual;
	paid_leaves=paid;
	casual_leaves=casual;
	sick_leaves=sick;
	}
	PermanentEmp()
	{
	
	
	}
	public void display()
	{
		System.out.println("Id of employee:" +getEmpId());
		System.out.println("Name of employee:" +getEmpName());
		System.out.println("Basic of employee:" +getBasic());
		System.out.println("Paid Leave:" +paid_leaves);
		System.out.println("Sick Leave:" +sick_leaves);
		System.out.println("Casual Leave:" +casual_leaves);
	}

	@Override
	public void calculate_balance_leaves() {
		// TODO Auto-generated method stub
		 total=paid_leaves+sick_leaves+casual_leaves;
		 System.out.println("Current PaidLeaves:"+paid_leaves);
		 System.out.println("Current SickLeave:"+sick_leaves);
		 System.out.println("Current CasualLeaves:"+casual_leaves);
		System.out.println("CurrentLeave:"+total);
	
	}

	@Override
	public boolean avail_leave(int no_of_leaves, char type_of_leave) {
		// TODO Auto-generated method stub
		boolean avail=false;
		if(type_of_leave=='P')
		{
			System.out.println("No of paid Leaves currently available:"+paid_leaves);
			System.out.println("No of  leaves applied:"+no_of_leaves);
			
			if(no_of_leaves>paid_leaves)
			{
				
				avail=false;
			}
			else
			{
				avail=true;
				
			}
			
		}else if(type_of_leave=='S')
		{
			System.out.println("No of sick Leaves currently available:"+sick_leaves);
			System.out.println("No of  leaves applied:"+no_of_leaves);
			if(no_of_leaves>sick_leaves)
			{
				
				avail=false;
			}
			else
			{
				avail=true;
				
			}
		}	
		else
		{
			System.out.println("No of casual Leaves currently available:"+casual_leaves);
			System.out.println("No of  leaves applied:"+no_of_leaves);
			if(no_of_leaves>casual_leaves)
			{
				avail=false;
				
			}
			else
			{
				avail=true;
				
			}
		}
		return avail;
	}

	@Override
	public void calculate_salary() {
		// TODO Auto-generated method stub
		double pf=(.12*getBasic());
		double hra=(.50*getBasic());
		totalsalary=pf+hra+getBasic();
		System.out.println("PermanentEmployee Salary Details ");
		System.out.println("Basic of employee: " +getBasic());
		System.out.println("NetSalary of employee: " +totalsalary);
		
	}
	
	public void applyForLeave(int no,char a)
	{
		
		 
		 if(a=='P')
		 {
			 System.out.println("No of Paid Leaves currently available:"+paid_leaves);
			 if(no > paid_leaves)
			 {
				 System.out.println("You cannot apply") ;
			 }
			 else
			 {
			paid_leaves-=no;
			System.out.println("Count of paid leaves now:"+paid_leaves);
			 }
		 }
		 else if(a=='S')
		 {
			 System.out.println("No of sick leaves currently available"+sick_leaves);
			 
			 if(no>sick_leaves)
			 {
				 System.out.println("You cannot apply") ;
			 }
			 else
			 {
				 sick_leaves-=no;
			 System.out.println("Count of sick leaves now:"+sick_leaves);
			 }
		 }
		 else
		 {
			 System.out.println("No of casual leaves currently available:"+casual_leaves);
			 if(no>casual_leaves)
			 {
				 System.out.println("You cannot apply") ;
			 }
			 else
			 {
			 casual_leaves-=no;
			 System.out.println("Count of casual leaves now:"+casual_leaves);
			 }
		 }
	}
	
	

}

class TemporaryEmp extends Employee
{
	private int allowance;//Special feature for Temporary Employee
						//No paid,sick,casual leaves 
	double totalsalary=0.0;
	public int getAllowance() {
		return allowance;
	}
	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}
	TemporaryEmp()
	{
		
	}
	TemporaryEmp(int Id,String name,double basic,int allowance)
	{
	super(Id,name,basic)	; 
	this.allowance=allowance;
	}
	@Override
	public void calculate_balance_leaves() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean avail_leave(int no_of_leaves, char type_of_leave) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void calculate_salary() {
		// TODO Auto-generated method stub
		
		 totalsalary=getAllowance()+getBasic();
		System.out.println("Temperory Salary Details ");
		System.out.println("Basic of employee: " +getBasic());
		System.out.println("NetSalary of employee: " +totalsalary);
		
	}
	public void display()
	{
		System.out.println("Id of employee:" +getEmpId());
		System.out.println("Name of employee:" +getEmpName());
		System.out.println("Basic of employee:" +getBasic());
		System.out.println("Total Salary"+totalsalary);
	}

}
public class Payroll {
	public static void main(String[] args)  throws IOException{
		String choice,c,chc;
		int id;
		String name;
		float basic;
		Scanner sc;
		int paid,casual,sick;
		int allowance;
		BufferedReader br;
		do{
			System.out.println("View and Add EmployeeDetails");
			System.out.println("----------------");
			System.out.println("1.PermanentEmployee  2.TemporaryEmployee 3.Exit");
			System.out.println("Enter your choice");
			 sc=new Scanner(System.in);
			int a=sc.nextInt();
			 br = new BufferedReader(new InputStreamReader(System.in));
			switch(a)
			{
			case 1:
				System.out.println ("Enter Employee id "+"\n");
				id = Integer.parseInt(br.readLine());
				System.out.println ("Enter Employee Name"+"\n");
				 name = br.readLine();
				 System.out.println ("Enter basic salary "+"\n");
				basic = Float.parseFloat(br.readLine());
				 System.out.println ("Enter no: of paid leaves"+"\n");
				 paid= Integer.parseInt(br.readLine());
				 System.out.println ("Enter no: of sick leaves "+"\n");
				 sick= Integer.parseInt(br.readLine());
				System.out.println ("Enter no:of casual leaves"+"\n");
				casual= Integer.parseInt(br.readLine());
				PermanentEmp p=new PermanentEmp(id,name,basic,paid,sick,casual);
				do
				{
			
				System.out.println("Permanent Employee Operations");
				System.out.println("\n1.Calculate Salary\n2.Apply for Leave\n"
						+ "Type P-Paid C-Casual S-Sick"
						+ "\n3. Availability of Leave\n4.Balance Leave\n 5.Display Details \n6.Exit");
				 System.out.print("\nEnter the serial no. of the operation you would like to perform : "+"\n");
				int ch=sc.nextInt();
				
				switch(ch)
				{
				case 1:
					p.calculate_salary();
					break;
				
				case 2:
					System.out.println ("Enter no: of leaves required"+"\n");
					 int n= sc.nextInt();
					 System.out.println ("Enter type of Leave "+"\n");
					 char t= (char)br.read();
					p.applyForLeave(n,t);
					break;
				case 3:
					System.out.println ("Enter no: of leaves required"+"\n");
					 int no= sc.nextInt();
					 System.out.println ("Enter type of Leave "+"\n");
					 char type= (char)br.read();
					boolean available=p.avail_leave(no, type);
					if(available)
						System.out.println("You can take leave");
					else
						System.out.println("You cannot take leave");
					break;
				case 4:
					p.calculate_balance_leaves();
					break;
				case 5:
					p.display();
					break;
				case 6:
					break;
				
				default:
					System.out.println("Enter the correct no.");break;		
					
					
				}
				System.out.println("Continue(Y/N) for Permanent Employee");
		         c = sc.next();
				}while(c.equals("Y")	);
				break;
			case 2:
				System.out.println ("Enter Employee Id "+"\n");
				id = Integer.parseInt(br.readLine());
				System.out.println ("Enter Employee Name"+"\n");
				 name = br.readLine();
				 System.out.println ("Enter basic salary "+"\n");
				basic = Float.parseFloat(br.readLine());
				System.out.println ("Enter special allowance"+"\n");
				 allowance= Integer.parseInt(br.readLine());
				TemporaryEmp t=new TemporaryEmp(id,name,basic,allowance);
				do
				{
				System.out.println("Temporary Employee Operations");
				System.out.println("\n\n\n1.Calculate Salary\n"
						+ "2.Display Details"
						+ " 3.Exit");
				System.out.print("\nEnter the serial no. of the operation you would like to perform : "+"\n");
				int ch=sc.nextInt();
				switch(ch)
				{
				case 1:
					t.calculate_salary();
					
					break;
				case 2:
					t.display();
					break;
				case 3:
					break;
				
				default:
					System.out.println("Enter the correct no.");break;		
					
					
				}
				System.out.println("Temporary Employee Continue(Y/N)");
		         chc = sc.next();
				}while(chc.equals("Y")	);
				break;
			case 3:
				break;
				default:
					System.out.println("Enter the correct no.");break;	
				
			}
			System.out.println("Main Continue(Y/N)");
	         choice = sc.next();
			}while(choice.equals("Y")	);
		
	}
}

