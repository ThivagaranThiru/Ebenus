package com.cours.ebenus.entities;

import java.util.Date;

public class Commande {
	
	private Integer idCommande;
	private Double totalCommande;
	private String statut;
	private Date dateCommande;
	private Date dateModification;
	private Integer version = 0;
	private Adresse adresse;
	private Utilisateur utilisateur;

	public Commande() {
		
	}
	
	public Commande(Integer idCommande, Double totalCommande, String statut, Date dateCommande, Date dateModification, Integer version, Adresse adresse, Utilisateur utilisateur) {
		this.idCommande = idCommande;
		this.totalCommande = totalCommande;
		this.statut = statut;
		this.dateCommande = dateCommande;
		this.dateModification = dateModification;
		this.version = version;
		this.adresse = adresse;
		this.utilisateur = utilisateur;
	}
	
	public Commande(Integer idCommande, Double totalCommande, String statut, Date dateCommande, Date dateModification, Adresse adresse, Utilisateur utilisateur) {
		this(idCommande, totalCommande, statut, dateCommande, dateModification, 0, adresse, utilisateur);
	}
	
	public Commande(Double totalCommande, String statut, Date dateCommande, Date dateModification, Adresse adresse, Utilisateur utilisateur) {
		this(null, totalCommande, statut, dateCommande, dateModification, 0, adresse, utilisateur);
	}
	
	public Commande(Double totalCommande, String statut, Date dateCommande, Date dateModification) {
		this(null, totalCommande, statut, dateCommande, dateModification, null,null);
	}
	
	public Commande(Integer idCommande) {
		this(idCommande,null,null,null,null,null,null);
	}
	
	public Integer getIdCommande() {
		return idCommande;
	}
	
	public void setIdCommande(Integer idCommande) {
		this.idCommande = idCommande;
	}

	public Double getTotalCommande() {
		return totalCommande;
	}

	public void setTotalCommande(Double totalCommande) {
		this.totalCommande = totalCommande;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getDateModification() {
		return dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

        public Adresse getAdresse() {
            return adresse;
	}

	public void setAdresse(Adresse adresse) {
            this.adresse = adresse;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	@Override
        public int hashCode() {
            int hash = 0;
            hash += (idCommande != null ? idCommande.hashCode() : 0);
            return hash;
        }

        @Override
        public boolean equals(Object object) {
    	
            if (!(object instanceof Commande)) {
                return false;
            }
        
            Commande other = (Commande) object;
        
            if ((this.idCommande == null && other.idCommande != null) || (this.idCommande != null && !this.idCommande.equals(other.idCommande))) {
                return false;
            }
            return true;
        }
    
        @Override
        public String toString() {
    	
            String toString = String.format("\n[idCommande=%s, totalCommande=%s, statut=%s, dateCommande=%s, dateModification=%s", idCommande, totalCommande, statut, dateCommande, dateModification);
        
            if (adresse != null) {
                toString += String.format(" ,adresse=%s ", adresse);
            }
        
            if (utilisateur != null) {
                toString += String.format(" ,utilisateur=%s ", utilisateur);
            }
        
            toString += String.format(" ,version=%s]\n", version);
        
            return toString;
        }
}
