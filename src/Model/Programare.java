package Model;

public class Programare {

	private String nume,doctor,specialitatea;
	
	private java.sql.Date data_programare;
    private java.sql.Time ora;
	
	
	public Programare(String nume,
			String doctor,String specialitatea,
			java.sql.Date data_programare,java.sql.Time ora)
	{
		this.nume=nume;
	//	this.telefon=telefon;
	//	this.email=email;
		this.doctor=doctor;
		this.specialitatea=specialitatea;
		this.data_programare=data_programare;
		this.ora=ora;
	}
	
	public String getNume()
	{
		return nume;
	}
	
	public java.sql.Date getDataProgramare()
	{
		return data_programare;
	}
	
	
	public String getDoctor()
	{
		return doctor;
	}
	
	public String getSpecialitatea()
	{
		return specialitatea;
	}
	
	public java.sql.Time getOra()
	{
		return ora;
	}
	
}
