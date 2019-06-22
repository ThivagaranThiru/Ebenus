package com.cours.ebenus.entities;

public class Adresse {
	
	private Integer idAdresse;
	private String rue;
	private String codePostal;
	private String ville;
	private String pays;
	private String statut;
	private String typeAdresse;
	private Boolean principale;
	private Integer version;
	private Integer idUtilisateur;
	
	public Adresse() {
		
	}
	
	public Adresse(Integer idAdresse, String rue, String codePostal, String ville, String pays, String statut, String typeAdresse, Boolean principale, Integer version, Integer idUtilisateur){
		this.idAdresse = idAdresse;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
		this.statut = statut;
		this.typeAdresse = typeAdresse;
		this.principale = principale;
		this.version = version;
		this.idUtilisateur = idUtilisateur;
	}
	
	public Adresse(Integer idAdresse, String rue, String codePostal, String ville, String pays, Integer idUtilisateur) {
		this(idAdresse, rue, codePostal, ville, pays, null, null, false, 0, idUtilisateur);
	}
	
	public Adresse(String rue, String codePostal, String ville, String pays, String typeAdresse, Boolean principale, Integer idUtilisateur) {
		this(null, rue, codePostal, ville, pays, null, typeAdresse, principale, 0, idUtilisateur);
	}
        
        public Adresse(String rue, String codePostal, String ville, String pays, Integer idUtilisateur) {
		this(null, rue, codePostal, ville, pays, null, null, false, 0, idUtilisateur);
	}
        
	public Adresse(String rue, String codePostal, String ville, String pays) {
		this(null, rue, codePostal, ville, pays, null, null, false, 0, null);
	}
	
	public Adresse(Integer idAdresse) {
		this(idAdresse, null, null, null, null, null, null, null, null, null);
	}
	
	public Integer getIdAdresse() {
		return idAdresse;
	}
	
	public void setIdAdresse(Integer idAdresse) {
		this.idAdresse = idAdresse;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getTypeAdresse() {
		return typeAdresse;
	}

	public void setTypeAdresse(String typeAdresse) {
		this.typeAdresse = typeAdresse;
	}

	public Boolean getPrincipale() {
		return principale;
	}

	public void setPrincipale(Boolean principale) {
		this.principale = principale;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	
	@Override
        public int hashCode() {
            int hash = 0;
            hash += (idAdresse != null ? idAdresse.hashCode() : 0);
            return hash;
        }
	
        @Override
        public boolean equals(Object object) {
    	
            if (!(object instanceof Adresse)) {
                return false;
            }
        
            Adresse other = (Adresse) object;
        
            if ((this.idAdresse == null && other.idAdresse != null) || (this.idAdresse != null && !this.idAdresse.equals(other.idAdresse))) {
                return false;
            }
        
            return true;
        }
    
        @Override
        public String toString() {
    	
            String toString = String.format("\n[idAdresse=%s, rue=%s, codePostal=%s, ville=%s, pays=%s, statut=%s, typeAdresse=%s, principale=%s, idUtilisateur=%s", idAdresse, rue, codePostal, ville, pays, statut, typeAdresse, principale, idUtilisateur);
        
            toString += String.format(" ,version=%s]\n", version);
        
            return toString;
        }
}
