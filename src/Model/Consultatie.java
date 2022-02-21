package Model;

public class Consultatie {
	
	private String diagnostic, medicatie, medic, CNP;
	java.sql.Date data_consultatie;
	
	public Consultatie(String CNP,java.sql.Date data_consultatie,String medic,
			String diagnostic,
			String medicatie)
	{
		this.CNP          		=  CNP;
		this.data_consultatie	=  data_consultatie;
		this.diagnostic			=  diagnostic;
		this.medicatie			=  medicatie;
		this.medic		 	    =  medic;
	
	}
	
	public String getCNP()
	{
		return CNP;
	}
	
	public java.sql.Date getDataconsultatie()
	{
		return data_consultatie;
	}
	
	public String getDiagnostic()
	{
		return diagnostic;
	}
	
	public String getMedicatie()
	{
		return medicatie;
	}
	
	public String getMedic()
	{
		return medic;
	}
}
