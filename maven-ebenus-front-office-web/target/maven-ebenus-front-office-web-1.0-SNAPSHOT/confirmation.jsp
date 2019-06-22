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
    <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
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
							<li><a href="informations-personnelle">${userModel.monCompte.get(0) }</a></li>
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
                <h1>Confirmation</h1>
<div class="confirmation-form-wrap">
   
<div class="confirmation-list-products"> 
	<div class="column-labels">
	    <label class="product-image">Image</label>
	    <label class="product-details">Produit</label>
	    <label class="product-price">Prix</label>
	    <label class="product-quantity">QuantitÃ©</label>
	    <label class="product-line-price">Total</label>
	  </div>
	  <c:forEach items="${modelPanier.articleCommande}" var="p">
	   <div class="product">
	    <div class="product-image">
	      <img src="https://media.ldlc.com/ld/products/00/03/82/84/LD0003828453_2_0003828545_0003828620.jpg">  
	    </div>
	   <div class="product-details">
        <h2 class="product-title">
          <a href="detail-produit-1.html">
          ${p.produit.nom }
          </a>
        </h2>
        <a href="detail-produit-1.html">
        <div class="product-description">
          <ul>
            <li>Couleur : Or</li>
            <li>OS (type) : iOS</li>
            <li>Robuste : CertifiÃ© IP67</li>
            <li>Batterie : 1960 mAh</li>
            <li>Taille Ã©cran : 4,7"</li>
            <li>Processeur : Apple A10 64 bits</li>
          </ul>
        </div>
      </a>
    </div>
    <div class="product-price">${p.produit.prix } €</div>
	    <div class="product-quantity">
	      <span>${p.quantite }</span>
	    </div>
	    
	    <div class="product-line-price">${p.totalArticleCommande } €</div>
	  </div>
	</c:forEach>
	  <div class="totals">
	    
	    <div class="totals-item totals-item-total">
	      <label>Grand Total</label>
	      <div class="totals-value" id="cart-total">${modelPanier.total }</div>
	    </div>
	  </div>
	
	            
	        
	    
	    
	    <!-- <div class="buttons-set">
	        <button type="button" class="button" title="Continue Shopping">
	        	Continuer Achat
	        </button>
	    </div> -->
</div>
</div>

<div class="row  mb-5">

        <h4 class="mb-3 col-md-12">DÃ©tails de livraisons</h4>

        <div class="col-md-3 mb-3">
          <label for="country">Modes de livraisons</label>
          <select class="custom-select d-block w-100" id="country" required="">
            <option value="">SÃ©lectionnez...</option>
            <option>Chronopost - 15 euros - 1 jours</option>
            <option>Fedex - 10 euros - 2 jours</option>
            <option>DHL - 5 euros - 3 jours</option>
          </select>
          
        </div>

        <div class="col-md-4 mb-3">
          <label for="state">Adresses de livraisons</label>
          <select class="custom-select d-block w-100" id="state" required="">
          <option value="">SÃ©lectionnez...</option>
           <c:forEach items="${modelUserData.adresseLivraison}" var="p">
           <option>${p.rue} -  ${p.codePostal} -  ${p.ville} - ${p.pays}</option>
           </c:forEach>
          </select>
          
        </div>
        
      </div>

<div class="row">

    
<aside class="col-sm-10">



<div class="tab-pane fade show active" id="nav-tab-card">
    <form role="form" action="finalisation.html">
       <div class="form-group text-right">

        <button style="float: right" class="subscribe btn btn-primary btn-block col-md-4" type="submit"> Valider  </button>
        </div>
    </form>
</div> <!-- tab-pane.// -->

 </aside> <!-- col.// -->
    
</div> <!-- row.// -->

                     
                
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
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="./assets/js/application.js" type="text/javascript"></script>


















</body>
</html>
