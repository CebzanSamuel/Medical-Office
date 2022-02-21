package Model;

public class Specializare {
	
	protected String cod;
	protected String specializare;
	
	public Specializare(String cod, String spec) {
		super();
		this.cod = cod;
		this.specializare = spec;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getSpecializare() {
		return specializare;
	}

	public void setSpecializare(String specializare) {
		this.specializare = specializare;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
		result = prime * result + ((specializare == null) ? 0 : specializare.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Specializare other = (Specializare) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		if (specializare == null) {
			if (other.specializare != null)
				return false;
		} else if (!specializare.equals(other.specializare))
			return false;
		return true;
	};
	
	
	
	

}
