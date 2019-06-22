package com.cours.ebenus.entities;

import java.util.Date;

public class ArticleCommande {
	
	private Integer idArticleCommande;
	private Double totalArticleCommande;
	private String reference;
	private Integer quantite;
	private String statut;
	private Date dateModification;
	private Integer version = 0;
	private Commande commande;
	private Utilisateur utilisateur;
	private Adresse adresse;
	private Produit produit;
	
	public ArticleCommande(){
		
	}
	
        public ArticleCommande(Integer idArticleCommande, Double totalArticleCommande, String reference, Integer quantite, String statut, Date dateModification, Integer version, Commande commande, Utilisateur utilisateur, Adresse adresse, Produit produit) {
            this.idArticleCommande = idArticleCommande;
            this.totalArticleCommande = totalArticleCommande;
            this.reference = reference;
            this.quantite = quantite;
            this.statut = statut;
            this.dateModification = dateModification;
            this.version = version;
            this.commande = commande;
            this.utilisateur = utilisateur;
            this.adresse = adresse;
            this.produit = produit;
	}
	
        public ArticleCommande(Integer idArticleCommande, Double totalArticleCommande, String reference, Integer quantite, String statut, Date dateModification, Commande commande, Utilisateur utilisateur, Adresse adresse, Produit produit) {
            this(idArticleCommande, totalArticleCommande, reference, quantite, statut, dateModification,0,commande,utilisateur,adresse,produit);
	}
	
	public ArticleCommande(Integer idArticleCommande, Double totalArticleCommande, String reference, Integer quantite, String statut, Date dateModification) {
		this(idArticleCommande, totalArticleCommande, reference, quantite, statut, dateModification,0,null,null,null,null);
	}
	
	public ArticleCommande(Double totalArticleCommande, String reference, Integer quantite, String statut, Date dateModification, Commande commande, Utilisateur utilisateur, Adresse adresse, Produit produit) {
		this(null, totalArticleCommande, reference, quantite, statut, dateModification,0,commande,utilisateur,adresse,produit);
	}
	
	
	public ArticleCommande(Double totalArticleCommande, String reference, Integer quantite, String statut, Date dateModification) {
		this(null, totalArticleCommande, reference, quantite, statut, dateModification,0,null,null,null,null);
	}
	
	public ArticleCommande(Integer idArticleCommande) {
		this(idArticleCommande,null,null,null,null,null,null,null,null,null,null);
	}
	
	public Integer getIdArticleCommande() {
		return idArticleCommande;
	}
	
	public void setIdArticleCommande(Integer idArticleCommande) {
		this.idArticleCommande = idArticleCommande;
	}

	public Double getTotalArticleCommande() {
		return totalArticleCommande;
	}

	public void setTotalArticleCommande(Double totalArticleCommande) {
		this.totalArticleCommande = totalArticleCommande;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateModification() {
		return dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
        @Override
        public int hashCode() {
            int hash = 0;
            hash += (idArticleCommande != null ? idArticleCommande.hashCode() : 0);
            return hash;
        }
	
        @Override
        public boolean equals(Object object) {
    	
            if (!(object instanceof ArticleCommande)) {
                return false;
            }
        
            ArticleCommande other = (ArticleCommande) object;
        
            if ((this.idArticleCommande == null && other.idArticleCommande != null) || (this.idArticleCommande != null && !this.idArticleCommande.equals(other.idArticleCommande))) {
                return false;
            }
            
            return true;
        }
    
        @Override
        public String toString() {
    	
            String toString = String.format("\n[idArticleCommande=%s, totalArticleCommande=%s, reference=%s, quantite=%s, statut=%s, dateModification=%s", idArticleCommande, totalArticleCommande, reference, quantite, statut, dateModification);
        
            if (commande != null) {
                toString += String.format(" ,commande=%s ", commande);
            }
        
            if (utilisateur != null) {
                toString += String.format(" ,utilisateur=%s ", utilisateur);
            }
        
            if (adresse != null) {
                toString += String.format(" ,adresse=%s ", adresse);
            }
        
            if (produit != null) {
                toString += String.format(" ,produit=%s ", produit);
            }
        
            toString += String.format(" ,version=%s]\n", version);
        
            return toString;
        }
}
