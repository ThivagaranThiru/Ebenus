<%-- 
    Document   : updateAdresseLivraison
    Created on : 7 avr. 2019, 15:41:45
    Author     : thiva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png">
  <title>Ebenus Admin</title>
  <!-- Custom Fonts -->
  <!-- <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"> -->

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
  <link rel="stylesheet" href="./assets/css/master.css">
  
</head>
<body>
  <div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="DashboardServlet">Ebenus Admin</a>
      </div>
      <!-- Top Menu Items -->
      <ul class="nav navbar-right top-nav">
        <!-- li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b class="caret"></b></a>
          <ul class="dropdown-menu message-dropdown">
            <li class="message-preview">
              <a href="#">
                <div class="media">
                  <span class="pull-left">
                    <img class="media-object" src="http://placehold.it/50x50" alt="">
                  </span>
                  <div class="media-body">
                    <h5 class="media-heading">
                      <strong>John Smith</strong>
                    </h5>
                    <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                    <p>Lorem ipsum dolor sit amet, consectetur...</p>
                  </div>
                </div>
              </a>
            </li>
            <li class="message-preview">
              <a href="#">
                <div class="media">
                  <span class="pull-left">
                    <img class="media-object" src="http://placehold.it/50x50" alt="">
                  </span>
                  <div class="media-body">
                    <h5 class="media-heading">
                      <strong>John Smith</strong>
                    </h5>
                    <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                    <p>Lorem ipsum dolor sit amet, consectetur...</p>
                  </div>
                </div>
              </a>
            </li>
            <li class="message-preview">
              <a href="#">
                <div class="media">
                  <span class="pull-left">
                    <img class="media-object" src="http://placehold.it/50x50" alt="">
                  </span>
                  <div class="media-body">
                    <h5 class="media-heading">
                      <strong>John Smith</strong>
                    </h5>
                    <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                    <p>Lorem ipsum dolor sit amet, consectetur...</p>
                  </div>
                </div>
              </a>
            </li>
            <li class="message-footer">
              <a href="#">Read All New Messages</a>
            </li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
          <ul class="dropdown-menu alert-dropdown">
            <li>
              <a href="#">Alert Name <span class="label label-default">Alert Badge</span></a>
            </li>
            <li>
              <a href="#">Alert Name <span class="label label-primary">Alert Badge</span></a>
            </li>
            <li>
              <a href="#">Alert Name <span class="label label-success">Alert Badge</span></a>
            </li>
            <li>
              <a href="#">Alert Name <span class="label label-info">Alert Badge</span></a>
            </li>
            <li>
              <a href="#">Alert Name <span class="label label-warning">Alert Badge</span></a>
            </li>
            <li>
              <a href="#">Alert Name <span class="label label-danger">Alert Badge</span></a>
            </li>
            <li class="divider"></li>
            <li>
              <a href="#">View All</a>
            </li>
          </ul>
        </li -->
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${user.nom}  ${user.prenom}<b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li>
              <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
            </li>
            <!--li>
              <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
            </li>
            <li>
              <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
            </li -->
            <li class="divider"></li>
            <li>
              <a href="LoginServlet"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
            </li>
          </ul>
        </li>
      </ul>
      <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
      <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav side-nav">
          <li class="active">
            <a href="DashboardServlet"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
          </li>
          <li>
            <a href="AllUsersServlet"><i class="fa fa-users"></i> Utilisateurs</a>
          </li>
          <li>
            <a href="AllRolesServlet"><i class="fa fa-user"></i> Rôles</a>
          </li>
          <li>
            <a href="AllProduitsServlet"><i class="fa fa-money"></i> Produits</a>
          </li>
          
          <li>
            <a href="AllCommandesServlet"><i class="fa fa-shopping-cart"></i> Commandes</a>
          </li>
          
          <!-- <li>
            <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i> Contenu <i class="fa fa-fw fa-caret-down"></i></a>
            <ul id="demo" class="collapse">
              <li>
                <a href="slider.html">Slider</a>
              </li>
                           
            </ul>
          </li> -->

        </ul>
      </div>
    <!-- /.navbar-collapse -->
    </nav>
    <div id="page-wrapper">
      <div class="container-fluid">
        
        <div class="row">
          <div class="col-lg-12">
            <h1 class="page-header">
              Editer Adresse de Livraison
            </h1>
            <ol class="breadcrumb">
              <li>
                <i class="fa fa-dashboard"></i>  <a href="DashboardServlet">Dashboard</a>
              </li>
              <li class="active">
                <i class="fa fa-edit"></i>Editer Adresse de Livraison
              </li>
            </ol>
          </div>
        </div>
        <!-- /.row -->
      <form class="form-horizontal" method="post" action="UpdateAdresseLivraison">
         <div class="row">
            <div class="well well-lg clearfix text-right">
            <p>${message}</p>
            <c:remove var="message" scope="session"/>
              <a href="UpdateUserServlet?idUser=${adresse.idUtilisateur}" class="btn btn-lg "><span><i class="fa fa-arrow-left"></i>Retour</span></a>
              <button type="submit" class="btn btn-default btn-lg pull-right">
                Enregistrer
              </button>
            </div>
         </div>

         <div class="row">
              <fieldset>

              

              <!-- 
/*=====================================
=            Adress System            =
=====================================*/
 -->
             
<div class="row">
<div class="userAdress">
            
<div class="form-group">
  <div class="col-md-3"></div>
  <h2 class="col-md-9">Adresse de Livraison</h2>
</div>

 <div class="form-group">
   <label class="col-md-3 control-label" for="street-ship">Rue</label>
   
   <div class="col-md-9">
    <input class="form-control" value="${adresse.rue}" name="street-ship" id="street-Bill" type="text" required="">
   </div>
 </div>

 <div class="form-group">
   <label class="col-md-3 control-label" for="postalcodeShip">Code Postale</label>
   
   <div class="col-md-9">
    <input class="form-control" value="${adresse.codePostal}" name="postalcodeShip" id="postalcodeBill" type="text" required="">
    </div>
 </div>

<div class="form-group">
  <label class="col-md-3 control-label" for="cityShip">Ville</label>
  <div class="col-md-9">
    <input class="form-control" value="${adresse.ville}" name="cityShip" id="cityBill" type="text" required="">
    </div>
</div>

             <div class="form-group">
                <label class="col-md-3 control-label" for="countryShip">Pays</label>
               <div class="col-md-9">
                   <input value="${adresse.pays}" class="form-control" name="countryShip" id="countryBill" type="text" required="">
                   </div>
             </div>

             

        </div>
        </div>

 <!-- /.row -->
         <div class="row">
            <div class="well well-lg clearfix text-right">
              <a href="UpdateUserServlet?idUser=${adresse.idUtilisateur}" class="btn btn-lg "><span><i class="fa fa-arrow-left"></i>Retour</span></a>
              <button class="btn btn-default btn-lg pull-right">
                Enregistrer
              </button>
            </div>
         </div>
         </fieldset>
        </div>
  </form>
      <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->
  </div>
</div>
  <!-- /#wrapper -->
 <script src="./assets/js/bower.js" type="text/javascript" charset="utf-8"></script>
  <script src="./assets/js/application.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
