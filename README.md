# Ebenus

Ebenus est une application de vente de produits divers et variés qui vend ses produits dans ses magasins physiques et sur son site e-commerce. Il existera plusieurs profils d’utilisateurs sur le site internet. Exemple : vendeurs, acheteurs, directeur 
et administrateurs.  
Ebenus exporte ses commandes (possibilité d’export journalier ou export de telle date à telle date, ou export complet) sous plusieurs formats (CSV,JSON,XML).

L’application sera divisée en deux parties : 

  - Une partie Front Office qui va permettre aux clients du site de passer des commandes avec un catalogue représenté par une liste de produits.
  - Une partie Back Office qui va permettre d’administrer le site (créer des utilisateurs,(vendeurs, etc.), créer /modifier des produits, gérer le stock, export de commandes, etc.). 
  

Les applications Front Office et Back office sont caractérisées par : 

  - Une couche UI (User interface) qui est la porte d’entrée de l’application et qui est un navigateur web pour un client léger. La couche UI est parfois appelée couche IHM (interface homme machine).

  - La couche Dao-Service qui a pour rôle d’accéder aux données de la SGBD. J'ai utilisé une base de données MYSQL avec le driver JDBC et une implémentation DAO en JDBC standard. 
  
  - L’application Back office est une application client Web (Standard Servlet Java).   

  - L’application Front office sera une application Web http Servlet.
  
Technologies utilisées : 

- Web Java EE de type Http Servlet Standard 
- MySQL
- JDBC avec DriverManager
- IDE NetBeans
- Tests unitaires JUnit
- Serveur d’application GlassFish
