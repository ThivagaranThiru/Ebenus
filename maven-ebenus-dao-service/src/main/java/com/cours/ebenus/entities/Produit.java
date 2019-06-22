package com.cours.ebenus.entities;

public class Produit {
	
	private Integer idProduit;
	private String reference;
	private Double prix;
	private String nom;
	private String description;
	private Integer stock;
	private Boolean actif = true;
	private Boolean marquerEffacer = false;
	private Integer version = 0;
	
	public Produit() {
		
	}
	
	public Produit(Integer idProduit, String reference, Double prix, String nom, String description, Integer stock, Boolean actif, Boolean marquerEffacer, Integer version) {
		this.idProduit = idProduit;
		this.reference = reference;
		this.prix = prix;
		this.nom = nom;
		this.description = description;
		this.stock = stock;
		this.actif = actif;
		this.marquerEffacer = marquerEffacer;
		this.version = version;
	}
	
	public Produit(Integer idProduit, String reference, Double prix, String nom, String description, Integer stock, Boolean actif) {
		this(idProduit, reference, prix, nom, description, stock, actif, false, 0);
	}
	
	public Produit(String reference, Double prix, String nom, String description, Integer stock,Boolean actif) {
		this(null, reference, prix, nom, description, stock, actif, false,0);
	}
	
	public Produit(Integer idProduit) {
		this(idProduit,null,null,null,null,null,null,null,null);
	}
	
	
	public Integer getIdProduit() {
		return idProduit;
	}
	
	public void setIdProduit(Integer idProduit) {
		this.idProduit = idProduit;
	}
	
	public String getReference() {
		return reference;
	}
	
	public void setReference(String reference) {
		this.reference = reference;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Boolean getMarquerEffacer() {
		return marquerEffacer;
	}

	public void setMarquerEffacer(Boolean marquerEffacer) {
		this.marquerEffacer = marquerEffacer;
	}
	
	@Override
        public int hashCode() {
            int hash = 0;
            hash += (idProduit != null ? idProduit.hashCode() : 0);
            return hash;
        }
	
        @Override
        public boolean equals(Object object) {
    	
            if (!(object instanceof Produit)) {
                return false;
            }
        
            Produit other = (Produit) object;
        
            if ((this.idProduit == null && other.idProduit != null) || (this.idProduit != null && !this.idProduit.equals(other.idProduit))) {
                return false;
            }
            
            return true;
        }
    
        @Override
        public String toString() {
    	
            String toString = String.format("\n[idProduit=%s, reference=%s, prix=%s, nom=%s, description=%s, stock=%s, actif=%s, marquerEffacer=%s, version=%s]\n", idProduit, reference, prix, nom, description, stock, actif, marquerEffacer, version);
        
            return toString;
        }	
}
