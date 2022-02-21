package Model;


public class Pacient {
	
	private String numePacient, CNP, localitate,adresa,telefon,email;
	java.sql.Date data_nasterii,data_consultatie;


	
	public Pacient(String numePacient,java.sql.Date data_nasterii,
			String CNP,String localitate,String adresa,String telefon,String email)
			
	{
		this.numePacient	 	=	numePacient;
		this.data_nasterii		=	data_nasterii;
		this.CNP				=	CNP;
		this.localitate			=	localitate;
		this.adresa        	 	=   adresa;
		this.telefon			=	telefon;
		this.email				=	email;
		
	}
	
	
		

	
	public String getNumePacient()
	{
		return numePacient;
	}
	
	public java.sql.Date getDataNasterii()
	{
		return data_nasterii;
	}
	
	public String getCNP()
	{
		return CNP;
	}
	
	public String getLocalitate(){
		return localitate;
	}
	
	public String getAdresa(){
		return adresa;
	}
	
	public String getTelefon(){
		return telefon;
	}
	
	public String getEmail(){
		return email;
	}
	
}

