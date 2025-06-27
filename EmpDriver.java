package com.jdbcdemoproject.EmpDriverclass;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.jdbcdemoproject.EmpService.EmpService;
import com.jdbcdemoproject.Employee.employee;

public class EmpDriver 
{
	public static void main(String[] args) throws SQLException 
	{
		EmpService e1=new EmpService();
		while(true)
		{
			System.out.println("Welcome to employee management system");
			System.out.println("Enter 1 to add employee data");
			System.out.println("Enter 2 to update employee data");
			System.out.println("Enter 3 to fetch employee data");
			System.out.println("Enter 4 to delete employee data");
			System.out.println("Enter 5 to view employee data");
			System.out.println("Enter 6 to exit");
			System.out.println("Enter your choice");
			
			Scanner sc=new Scanner(System.in);
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
			{
				System.out.println("How many employee details you have enter");
				int num=sc.nextInt();
				for(int i=1;i<=num;i++)
				{
					System.out.println("Enter employee ID");
					int id=sc.nextInt();
					System.out.println("Enter name");
					String name=sc.next();
					System.out.println("Enter age");
					int age=sc.nextInt();
					System.out.println("Enter salary");
					double sal=sc.nextDouble();
					employee e=new employee(id, name, age, sal);
					if(e1.add(e)!=0)
					{
						System.out.println("your data is stored");
					}
					else
					{
						System.out.println("your data is not stored");
					}
				}
				break;
			}
				case 2:
				{
					System.out.println("Enter employee ID");
					int id=sc.nextInt();
					System.out.println("Enter name");
					String name=sc.next();
					System.out.println("Enter age");
					int age=sc.nextInt();
					System.out.println("Enter salary");
					double sal=sc.nextDouble();
					employee e=new employee(id, name, age, sal);
					int level=e1.update(e);
					if(level!=0)
					{
						System.out.println("Data successfully update");
					}
					else
					{
						System.out.println("Data not Update");
					}
				}
				break;
				case 3:
				{
					System.out.println("Enter employee ID");
					int id=sc.nextInt();
					e1.fetch(id);
				}
				break;
				case 4:
				{
					System.out.println("Enter Employee ID");
					int id=sc.nextInt();
					int level=e1.delete(id);
					if(level!=0)
					{
						System.out.println("Successfully deleted");
					}
					else
					{
						System.out.println("Id not found to deleted");
					}
				}
				break;
				case 5:
				{
					List<employee> emp=e1.view();
					System.out.println(emp);
				}
				break;
				case 6:
				{
					System.out.println("Thank you for using ❤️");
					return;
				}
			 }
			}
		}
	}


