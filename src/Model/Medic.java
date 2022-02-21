package Model;

public class Medic {
	
	protected String nume;
	protected String codSpecializare;
	protected String orarLuni;
	protected String orarMarti;
	protected String orarMiercuri;
	protected String orarJoi;
	protected String orarVineri;
	
	public Medic(String nume, String codSpecializare, String orarLuni, String orarMarti, String orarMiercuri,
			String orarJoi, String orarVineri) {
		super();
		this.nume = nume;
		this.codSpecializare = codSpecializare;
		this.orarLuni = orarLuni;
		this.orarMarti = orarMarti;
		this.orarMiercuri = orarMiercuri;
		this.orarJoi = orarJoi;
		this.orarVineri = orarVineri;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getCodSpecializare() {
		return codSpecializare;
	}

	public void setCodSpecializare(String codSpecializare) {
		this.codSpecializare = codSpecializare;
	}

	public String getOrarLuni() {
		return orarLuni;
	}

	public void setOrarLuni(String orarLuni) {
		this.orarLuni = orarLuni;
	}

	public String getOrarMarti() {
		return orarMarti;
	}

	public void setOrarMarti(String orarMarti) {
		this.orarMarti = orarMarti;
	}

	public String getOrarMiercuri() {
		return orarMiercuri;
	}

	public void setOrarMiercuri(String orarMiercuri) {
		this.orarMiercuri = orarMiercuri;
	}

	public String getOrarJoi() {
		return orarJoi;
	}

	public void setOrarJoi(String orarJoi) {
		this.orarJoi = orarJoi;
	}

	public String getOrarVineri() {
		return orarVineri;
	}

	public void setOrarVineri(String orarVineri) {
		this.orarVineri = orarVineri;
	}

	@Override
	public String toString() {
		return "Medic [nume=" + nume + ", codSpecializare=" + codSpecializare + ", orarLuni=" + orarLuni
				+ ", orarMarti=" + orarMarti + ", orarMiercuri=" + orarMiercuri + ", orarJoi=" + orarJoi
				+ ", orarVineri=" + orarVineri + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codSpecializare == null) ? 0 : codSpecializare.hashCode());
		result = prime * result + ((nume == null) ? 0 : nume.hashCode());
		result = prime * result + ((orarJoi == null) ? 0 : orarJoi.hashCode());
		result = prime * result + ((orarLuni == null) ? 0 : orarLuni.hashCode());
		result = prime * result + ((orarMarti == null) ? 0 : orarMarti.hashCode());
		result = prime * result + ((orarMiercuri == null) ? 0 : orarMiercuri.hashCode());
		result = prime * result + ((orarVineri == null) ? 0 : orarVineri.hashCode());
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
		Medic other = (Medic) obj;
		if (codSpecializare == null) {
			if (other.codSpecializare != null)
				return false;
		} else if (!codSpecializare.equals(other.codSpecializare))
			return false;
		if (nume == null) {
			if (other.nume != null)
				return false;
		} else if (!nume.equals(other.nume))
			return false;
		if (orarJoi == null) {
			if (other.orarJoi != null)
				return false;
		} else if (!orarJoi.equals(other.orarJoi))
			return false;
		if (orarLuni == null) {
			if (other.orarLuni != null)
				return false;
		} else if (!orarLuni.equals(other.orarLuni))
			return false;
		if (orarMarti == null) {
			if (other.orarMarti != null)
				return false;
		} else if (!orarMarti.equals(other.orarMarti))
			return false;
		if (orarMiercuri == null) {
			if (other.orarMiercuri != null)
				return false;
		} else if (!orarMiercuri.equals(other.orarMiercuri))
			return false;
		if (orarVineri == null) {
			if (other.orarVineri != null)
				return false;
		} else if (!orarVineri.equals(other.orarVineri))
			return false;
		return true;
	}
	
	

}
