package com.parag.banking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class repository {
	
	Connection con=null;
	public repository(){
		String url="jdbc:mysql://localhost:3306/indian_banks";
		String user="root";
		String pass="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pass);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public bank getbank(String ifsc) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM `bank_branches`where ifsc='"+ifsc+"'";
		bank a=new bank();
		
		try{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		System.out.println("called");
		if(rs.next()){
			a.setBranch(rs.getString(3));
			a.setAddress(rs.getString(4));
			a.setCity(rs.getString(5));
			a.setDistrict(rs.getString(6));
			a.setState(rs.getString(7));
			a.setBank_name(rs.getString(8));
			
		}
		
		}
		catch(Exception e){
			System.out.println(e);
		}
		return a;
	}

	public List<bank> getbanks(String city, String name) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM `bank_branches`where city='"+city+"' and bank_name='"+name+"'";
		List <bank> banks=new ArrayList<>();
		
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				bank a=new bank();
				a.setIfsc(rs.getString(1));
				a.setBranch(rs.getString(3));
				a.setAddress(rs.getString(4));
				a.setCity(rs.getString(5));
				a.setDistrict(rs.getString(6));
				a.setState(rs.getString(7));
				a.setBank_name(rs.getString(8));
				banks.add(a);
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return banks;
		
	}
		
	}


