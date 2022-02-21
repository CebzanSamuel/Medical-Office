package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Model.Consultatie;
import Model.Medic;
import Model.Pacient;
import Model.Programare;
import Model.ResultSetTable;
import Model.Specializare;

public class Operatii {

	private Connection con;
	

	public Operatii() 
	{
	}

	public ResultSetTable afisareListaPacienti() throws SQLException
	{ 

	
	   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world_clinic","root","");
	  	  
	   Statement st=con.createStatement();
	   ResultSet result = st.executeQuery("SELECT nume,data_nastere,CNP,Localitate,Adresa,Telefon FROM pacienti"); 
	   
	    
	   return  new ResultSetTable(result);
	
	}
	
	
	public boolean inserarePacientNou(Pacient pacient) throws Exception //merge UI
	{
		boolean exista=false; 
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world_clinic","root","");
	    	
		 String sql="INSERT INTO pacienti " + "VALUES (?,?,?,?,?,?,?)";
		 String sql1 ="SELECT cnp FROM pacienti WHERE cnp=?";


		 PreparedStatement ps = con.prepareStatement(sql);
		 PreparedStatement ps1 = con.prepareStatement(sql1);
		 
		 ps1.setString(1,pacient.getCNP());
		 ResultSet rset = ps1.executeQuery();
		 if (rset.next()) {
			 
			   exista=true;
			   rset.close();
		 }
		 else{	
		
		 ps.setString(1,pacient.getNumePacient());	
		 ps.setDate(2,pacient.getDataNasterii()); 		 
		 ps.setString(3,pacient.getCNP());		 
		 ps.setString(4, pacient.getLocalitate());
		 ps.setString(5,pacient.getAdresa());
		 ps.setString(6,pacient.getTelefon());
		 ps.setString(7, pacient.getEmail());
		 
		 ps.executeUpdate();
		 
		 con.close();
		 
		
		 }

		 return exista;
	}
	
	public void stergePacient(String cnp) throws Exception { //merge UI-sterge toti cuacelasi nume
			 
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world_clinic","root","");
		
		try {
			String sql = "DELETE FROM Pacienti WHERE cnp = ?";
	
			PreparedStatement ps = con.prepareStatement(sql);
		
			ps.setString(1, cnp);

			ps.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println("Nu s-a putut sterge!");
		}
		
	}   

	public ResultSetTable cautaPacient(String nume_pacient) throws SQLException
	{
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world_clinic","root","");
	  	  
		   Statement st=con.createStatement();
		   ResultSet result = st.executeQuery("SELECT nume,data_nastere,CNP,Localitate,Adresa,Telefon FROM pacienti WHERE nume='"+nume_pacient+"'"); 
		   
		    
		   return  new ResultSetTable(result);
	}
	
	public ResultSetTable afisareSpecializari(String cod) throws SQLException
	{
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world_clinic","root","");
		Statement st=con.createStatement();	
						
		ResultSet	 result=st.executeQuery("SELECT Medic, Luni,Miercuri,Joi,Vineri	FROM medici_speci WHERE cod_specialitate='"+cod+"' "); 
				
		return  new ResultSetTable(result);
	
	}
	
	public ResultSetTable afisareServicii(String cod) throws SQLException
	{
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world_clinic","root","");
		Statement st=con.createStatement();	
						
		ResultSet	 result=st.executeQuery("SELECT Servicii,Valoare FROM servicii WHERE cod_specialitate='"+cod+"' "); 
				
		return  new ResultSetTable(result);
	
	}
	
	public  ResultSet getSpecializari() throws SQLException{
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world_clinic","root","");
		Statement st=con.createStatement();				
		ResultSet	 result=st.executeQuery("SELECT * FROM `specializari`"); 	
		
		return result;
	}
	
	public boolean memoreazaConsult(Consultatie c) throws SQLException
	{
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world_clinic","root","");
	    	
		 	boolean exista= false;	
			 String sql="INSERT INTO consultatii " + "VALUES (?,?,?,?,?)";
			 String sql2="SELECT cnp FROM pacienti WHERE cnp=?";
			 
			 PreparedStatement ps = con.prepareStatement(sql);
			 PreparedStatement ps2 = con.prepareStatement(sql2);
					 	
			 ps2.setString(1,c.getCNP());
			 ResultSet rset = ps2.executeQuery();
			 if (rset.next()) {
				 
				   exista=true;//exista in bd CNP
				   
				   ps.setString(1,c.getCNP());
				   ps.setDate(2,c.getDataconsultatie());
				   ps.setString(3,c.getMedic());
				   ps.setString(4,c.getDiagnostic());
				   ps.setString(5,c.getMedicatie());
				 
				   ps.executeUpdate();
				   rset.close();
			 }
			 else{	
			 
				 exista=false;
				 rset.close();
			 
			 }
		
			 return exista;
	}
	
	public void efectueaza_programare(Programare p) throws SQLException
	{
		
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world_clinic","root","");
	  
		 
		 String sql="INSERT INTO programari " + "VALUES (?,?,?,?,?)";
		
		
		 PreparedStatement ps = con.prepareStatement(sql);
		

			 	ps.setString(1, p.getNume());
			 	ps.setString(2,p.getDoctor());
			 	ps.setString(3,p.getSpecialitatea());
			 	ps.setDate(4, p.getDataProgramare());
			 	ps.setTime(5, p.getOra());
		
			 	ps.executeUpdate();
		
	}
	
	public void addMedic(Medic medic) throws SQLException
	{
		
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world_clinic","root","");
	  
		 
		 String sql="INSERT INTO medici_speci " + "VALUES (?,?,?,?,?,?,?)";
		
		
		 PreparedStatement ps = con.prepareStatement(sql);
		
		 ps.setString(1, medic.getCodSpecializare());
		 ps.setString(2, medic.getNume());
		 ps.setString(3, medic.getOrarLuni());
		 ps.setString(4, medic.getOrarMarti());
		 ps.setString(5, medic.getOrarMiercuri());
		 ps.setString(6, medic.getOrarJoi());
		 ps.setString(7, medic.getOrarVineri());
		
		 ps.executeUpdate();
		
	}
	
	public void addSpecializare(Specializare spec) throws SQLException
	{
		
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world_clinic","root","");
	  
		 
		 String sql="INSERT INTO specializari " + "VALUES (?,?)";
		
		
		 PreparedStatement ps = con.prepareStatement(sql);
		
		 ps.setString(1, spec.getCod());
		 ps.setString(2,spec.getSpecializare());
		
		
		 ps.executeUpdate();
		
	}
	
}

