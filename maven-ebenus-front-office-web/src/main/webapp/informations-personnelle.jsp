<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        
        <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ebenus</title>
    <link rel="shortcut icon" type="image/x-icon" href="images/logo/favicon.png">
    <!-- CSS files -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800|Oswald:300,400,500,600,700" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="./assets/css/master.css">
    </head>
<body>
    <div class="outer">
        <div class="header-outer" id="header-outer">
	<!-- Header -->
	<header id="header"  class="header">
		<div class="header">
			<a href="Favoris" title="Ebenus Commerce" class="logo"> 
				<img src="./assets/images/logo/logo.png" alt="Ebenus Commerce"> 
			</a>
		    <ul class="main-menu">
		    	<li><a href="Favoris">Accueil</a></li>
		    	<li><a href="product">Produits</a></li>
		    	<li><a href="qui-sommes-nous.html">Qui sommes-nous</a></li>
		    	<li><a href="contact.html">Contactez-nous</a></li>
		    	<li class="last">
		    		<a href="#" class="account-link">Mon Compte</a>
					<ul class="sub-menu">
							<li><a href="UserData">${userModel.monCompte.get(0) }</a></li>
							<li class="guest">
								<a href="Deconnect">${userModel.monCompte.get(1) }</a>
							</li>
							<li class="logged">
								<a href="informations-personnelle.html"><strong>${userModel.monCompte.get(2) }</strong></a>
							</li>
							<li><a href="PanierContent">${userModel.monCompte.get(3) }</a></li>
					</ul>
						</li>
						<li class="header-icon-cart">
    <a class="menu-cart-icon" href="panier.html"><i class="icon-cart"></i></a>
</li>
						</ul>
		    <div class="phone-block">
		    	<i class="icon-phone"></i>
		    	Appelez nous<br>
		    	<b>+33 5678 890</b>
		    </div>
	
		    <div class="search-area">
		    	<a href="javascript:void(0)" class="search-icon">
		    		<!-- <i class="fa fa-search"></i> -->
		    		<i class="icon-search"></i>
		    	</a>
		    	<form id="search_mini_form" action="" method="get">
				    <div class="form-search">
		                <input id="search" placeholder="Rechercher un produit" type="text" name="q" class="input-text" autocomplete="off">
		                <button type="submit" title="Search" class="button"><i class="icon-search"></i></button>
				    </div>
				</form>
		    </div>
		</div>
	</header>
</div>

        <!-- Section -->
        <section>
            <div class="content">
                <div class="customer-acount">
	<h1>Compte Client</h1>
	<div class="account-container row">
		<div class="facet-navigation col-md-3">
	<ul>
		<li><a href="UserData">Information personnelles</a></li>
		<li><a href="adresse-client.jsp">GÃ©rer mon carnet d'adresses</a></li>
		<li><a href="historique-commandes.jsp">Historique des commandes</a></li>
		
	</ul>
</div>
		<div class=" common-form-controls col-md-9">
<div class=" common-form-controls">
		<p>Bienvenue Mr <strong>${modelUserData.user.nom }</strong>,<br/>
			Voici le rÃ©capitulatif de votre compte. Vous pouvez changer vos informations personnelles et gÃ©rer les options de votre compte.</p>
			<img src="./assets/images/banner.jpg" alt="">
		</br>
		</br>
		</div>

		<form id="customer-info-form" method="post" action="#" class="row validate no-gutters">
			<fieldset class="col-md-6">
				<h2>Informations personnelles</h2>
				<label for="firstname">PrÃ©nom</label>
				<input value="${modelUserData.user.nom}" name="firstname" id="firstname" type="text">
				<label for="lastname">Nom</label>
				<input value="${modelUserData.user.prenom }" name="lastname" id="lastname" type="text">
				<label for="email">Identifiant</label>
				<input value="${modelUserData.user.identifiant }" name="email" id="email" type="email">
				<label for="password">Mot de passe</label>
				<input name="password" value="123456" id="password" type="password">
				<label for="password">Confimer mot de psse</label>
				<input name="password" value="123456" id="password-C" type="password"> 
				<label>CivilitÃ©</label>
				<div class="gender">
					<input type="radio" id="male" name="sex" checked="checked"/>
					<label for="male">
					  <i class="fa fa-male" aria-hidden="true"></i>
					</label>
					<input type="radio" id="female" name="sex"/>
					<label for="female">
					  <i class="fa fa-female" aria-hidden="true"></i>
					</label>
				</div>

				<div class="input-wrapper">
            <label style="display: block;"> Date de naissance<em>*</em></label>
            <input  autocomplete="off" id="dteNaiss" name="dteNaiss" style="width:auto;" data-toggle="datepicker" type="text" value="${modelUserData.user.dateNaissance }" name="naissance">
        </div>
				
			</fieldset>
			
			<fieldset class="col-md-6">
				<h2>Adresse de facturation</h2>
				<label for="street">Rue</label>
				<input value="${modelUserData.adresseFacturation.rue }" name="__street" id="street" type="text">
				<label for="postalcode">Code Postale</label>
				<input value="${modelUserData.adresseFacturation.codePostal }" name="__postalcode" id="postalcode" type="text">
				<label for="city">Ville</label>
				<input value="${modelUserData.adresseFacturation.ville }" name="__city" id="city" type="text">
				<label for="country">Pays</label>
				<input value="${modelUserData.adresseFacturation.pays }" name="__country" id="country" type="text">
				</br>
				</br>
			
				<h2>Adresse de livraison Principale</h2>
				<label for="street">Rue</label>
				<input value="${modelUserData.principalAdresse.rue }" name="street" id="street" type="text">
				<label for="postalcode">Code Postale</label>
				<input value="${modelUserData.principalAdresse.codePostal }" name="postalcode" id="postalcode" type="text">
				<label for="city">Ville</label>
				<input value="${modelUserData.principalAdresse.ville }" name="city" id="city" type="text">
				<label for="country">Pays</label>
				<input value="${modelUserData.principalAdresse.pays }" name="country" id="country" type="text">

			</fieldset>
			
			<div class="actions">
			<button type="submit">Modifier</button>
			</div>

		</form>
		</div>
	</div>
</div> 
            </div>
        </section>

        <!-- Footer -->
<footer>
<div class="footer-container ">
<div class="footer">
<div class="footer-middle">
    <div class="footer-container_">
        <div class="row no-gutters"> 
            <div class="col-sm-6 col-md-3">
            <div class="block">
                <div class="block-title"><strong><span>Contactez Nous</span></strong></div>
                <div class="block-content">
                    <ul class="contact-info">
                        <li><i class="icon-location">&nbsp;</i><p><b>Addresse:</b><br>123 Rue la victoire, 75000 Paris, France</p></li>
                        <li><i class="icon-phone">&nbsp;</i><p><b>TÃ©l:</b><br>(123) 456-7890</p></li>
                        <li><i class="icon-mail">&nbsp;</i><p><b>Email:</b><br><a href="mailto:mail@example.com">mail@example.com</a></p></li>
                        <li><i class="icon-clock">&nbsp;</i><p><b>Horaire Jours/Heures:</b><br>Lun - Dim / 9:00AM - 8:00PM</p></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-sm-6 col-md-3"><div class="block">
            <div class="block-title"><strong><span>Mon compte</span></strong></div>
                <div class="block-content">
                    <ul class="links">
                        <li><i class="icon-right-dir theme-color"></i><a href="#" title="About us">Mon compte</a></li>
                        <li><i class="icon-right-dir theme-color"></i><a href="#" title="About us">A props de nous</a></li>
                        <li><i class="icon-right-dir theme-color"></i><a href="#" title="Contact us">Contacez nous</a></li>
                        <li><i class="icon-right-dir theme-color"></i><a href="pannier.html" title="Advanced search">Mon pannier</a></li>
                    </ul>
                </div>
            </div>
        </div>                

        <div class="col-sm-6 col-md-3"><div class="block">
            <div class="block-title"><strong><span>Information</span></strong></div>
            <div class="block-content">
                <ul class="features">
                    <li><i class="icon-ok theme-color"></i><a href="#">Historique des commandes</a></li>
                    <li><i class="icon-ok theme-color"></i><a href="#">Site Map</a></li>
                </ul>
            </div>
            </div>
        </div>

            <div class="col-sm-6 col-md-3">
                <div class="block">
                    <div class="block-title"><strong><span>Nos Services</span></strong></div>
                    <div class="block-content">
                        <ul class="features">
                            <li><i class="icon-ok  theme-color"></i><a href="#">Service Client</a></li>
                            <li><i class="icon-ok theme-color"></i><a href="#">Les Options de Transport</a></li>
                            <li><i class="icon-ok  theme-color"></i><a href="#">Avoir et Change</a></li>
                            <li><i class="icon-ok  theme-color"></i><a href="#">Politique d'Utilisation</a></li>
                        </ul>
                    </div>
                </div>
            </div>              
        </div>
    </div>
    </div>
<div class="footer-bottom">
    <div class="footer-container_">
        <div class="custom-block f-right"><div class="block-bottom">
            <div class="custom-block" >
            <img src="./assets/images/payment-icon.png" alt=""></div>

        </div>
        </div>                
    <address>Â© Ebenus eCommerce. 2018. Tous droit rÃ©servÃ©</address>
    </div>
</div>
</div>
</div>   
</footer>

    </div>


        <!-- JS files -->
    <script src="./assets/js/bower.js" type="text/javascript"></script>
    
    <script src="./assets/js/application.js" type="text/javascript"></script>


















</body>
</html>
