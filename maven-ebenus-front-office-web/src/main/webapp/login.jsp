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
		    	<li><a href="products.html">product</a></li>
		    	<li><a href="qui-sommes-nous.html">Qui sommes-nous</a></li>
		    	<li><a href="contact.html">Contactez-nous</a></li>
		   
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
                <div class="account-login">
    <div class="page-title">
        <h1>Identifiez vous ou créez un compte</h1>
    </div>
            <form action="LoginController" method="post" id="login-form">
    	<input name="form_key" type="hidden" value="HAtrCPk787XUz3um">
        <div class="row">
            
            <div class="col-md-5 registered-users">
                <div>
                    <h2>CONNECTEZ-VOUS</h2>
                    <p>On se connait déjà ?</p>
                    <p>Connectez-vous avec votre <strong>adresse e-mail</strong> et votre <strong>mot de passe</strong> pour accéder à votre espace client.</p>
                    <ul class="form-list">
                        <li>
                            <label for="__email" class="required">Email<em>*</em></label>
                            <div class="input-box">
                                <input type="text" name="__email" value="" id="__email" class="input-text" title="Email">
                            </div>
                        </li>
                        <li>
                            <label for="pass" class="required">Mot de passe<em>*</em></label>
                            <div class="input-box">
                                <input type="password" name="password" class="input-text" id="pass" title="Password">
                            </div>
                        </li>
                       </ul>
                    <p class="required-msg">* champs obligatoires</p>
                    <input type ="submit" value ="Connexion"/>
                </div>
            </div>
		</form>
            <div class="offset-md-2">
                
            </div>

            <div class="col-md-5 new-users">
                <div>
                    <h2>NOUVEAU CLIENT ?</h2>
                    <p>C’est votre première visite ?</p>
                    <p>Pour commander et accéder à nos différents services, nous vous convions à créer un compte client. C’est simple, rapide et il vous apportera de nombreux avantages.</p>
                </div>
                <label for="email" class="required">Email<em>*</em></label>
                <div class="input-box">
                    <input type="text" name="email" value="" id="email" class="input-text" title="Email">
                </div>
            </div>
            <button type="submit" title="Create an Account" class="button" >Créer le compte</button>
         </form>  
        </div>
        <div class="row actions">
           
            <div class="col-md-5 registered-users">
                <div class="buttons-set_">
                    <a href="mot-de-passe-oublie.html" class="f-left">Mot de passe oublié ?</a>
                     <!-- <form action="index.html" method="get">
                        <button type="submit" title="Connexion" class="button" >Connexion</button>
                    </form> -->
                    
                </div>
            </div>
            <div class="offset-md-2"></div>
             <div class="col-md-5 new-users">
                
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
                        <li><i class="icon-phone">&nbsp;</i><p><b>Tél:</b><br>(123) 456-7890</p></li>
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
    <address>© Ebenus eCommerce. 2018. Tous droit réservé</address>
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
