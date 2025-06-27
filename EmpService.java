package com.jdbcdemoproject.EmpService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jdbcdemoproject.Employee.employee;

public class EmpService 
{
	private static String url="jdbc:postgresql://localhost:5432/jdbcdemooo";
	private static String user="postgres";
	private static String pswd="123";
	private static Connection con;
	static
	{
		try 
		{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(url,user,pswd);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	Scanner sc=new Scanner(System.in);
	public int add (employee emp) throws SQLException
	{
		int res=0;
		String sql="Insert into employee values(?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, emp.getId());
		pst.setString(2, emp.getName());
		pst.setInt(3, emp.getAge());
		pst.setDouble(4, emp.getSalary());
		return res=pst.executeUpdate();
	}
	public int delete(int id) throws SQLException
	{
		int rem=0;
		String sql="delete from employee where id=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, id);
		return rem=pst.executeUpdate();
	}
	public void fetch(int id) throws SQLException
	{
		String sql="Select * from employee where id=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			System.out.println("Emp id:"+rs.getInt(1)+"-"+"Emp Name:"+rs.getString(2)+"-"+"Emp age:"+rs.getInt(3)+"-"+"Emp Sal:"+rs.getDouble(4));
		}
		else
		{
			System.out.println("id not vaild");
		}
	}
	public int update(employee e) throws SQLException
	{
		String sql="update employee set name=?, age=?, salary=?  where  id=?";
		PreparedStatement stm=con.prepareStatement(sql);
		stm.setString(1, e.getName());
		stm.setInt(2, e.getAge());
		stm.setInt(3, e.getSalary());
		stm.setInt(4, e.getId());
		
		int res=stm.executeUpdate();
		stm.close();
		return res;
	}
	public List<employee> view() throws SQLException 
	{
	     List<employee> emp=new ArrayList<employee>();
	     String	sql="select * from employee";
		 Statement stm=con.createStatement();
		 ResultSet rs=stm.executeQuery(sql);
	
	   while(rs.next())
	   {   
		  emp.add(new employee(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4)));  
	   }
	   return emp;
	}

}