<%-- 
    Document   : addUser
    Created on : 6 avr. 2019, 01:23:02
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
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${user.nom}  ${user.prenom} <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                    <li>
                      <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                    </li>
                    <!--li>
                      <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                    </li>
                    <li>
                      <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                    </li-->
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
              Nouveau Utilisateur
            </h1>
            <ol class="breadcrumb">
              <li>
                <i class="fa fa-dashboard"></i>  <a href="DashboardServlet">Dashboard</a>
              </li>
              <li class="active">
                <i class="fa fa-edit"></i> Nouveau Utilisateur
              </li>
            </ol>
          </div>
        </div>
        <!-- /.row -->
        <form method="post" action="AddUserServlet" class="form-horizontal">
            <div class="row">
                <div class="well well-lg clearfix text-right"> 
                    <p>${message}</p>
                    <c:remove var="message" scope="session"/>
                    <a href="AllUsersServlet" class="btn btn-lg "><span><i class="fa fa-arrow-left"></i>Retour</span></a>
                    <button type="submit" class="btn btn-default btn-lg pull-right">Enregistrer</button>
                </div>
            </div>
            <div class="row">
                <fieldset>
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="checkboxes">Statut</label>
                        <div class="col-md-3">
                            <div class="checkbox">
                                <input type="checkbox" name="checkboxes" id="user-state">
                                <label for="user-state"></label>
                            </div>
                        </div>
                    </div>
                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="firstName">Prénom</label>
                        <div class="col-md-9"> 
                            <input id="firstName" name="firstName" type="text" placeholder="" class="form-control input-md" required="">
                        </div>  
                    </div>
                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="secondName">Nom</label>
                        <div class="col-md-9">
                             <input id="secondName" name="secondName" type="text" placeholder="" class="form-control input-md" required="">
                        </div>
                    </div>
                    <!-- Text input-->
                    <div class="form-group">
                         <label class="col-md-3 control-label" for="role">Rôle</label>
                         <div class="col-md-9">
                             <div class="sel-container">
                                 <div class="sel">
                                     <select name="select-adress" id="select-year">
                                         <option value="Role" disabled>Rôle</option>
                                         <c:forEach items="${roleList}" var="roleList">
                                             <c:if test="${roleList.identifiant!='RolePoubelle'}">
                                             <option value="${roleList.identifiant}">${roleList.identifiant}</option>
                                             </c:if>
                                         </c:forEach>
                                         <!--option value="Administrateur">Administrateur</option>
                                         <option value="Directeur">Directeur</option>
                                         <option value="Standard">Standard</option>
                                         <option value="Vendeur">Vendeur</option>
                                         <option value="Acheteur">Acheteur</option-->
                                     </select>
                                 </div>
                             </div>
                         </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label civility">Civilité</label>
                        <div class="gender col-md-9">
                            <input type="radio" id="male" name="userSex" checked="checked" value="male">
                            <label for="male">
                                <i class="fa fa-male" aria-hidden="true"></i>
                            </label>
                            <input type="radio" id="female" name="userSex" value="female">
                            <label for="female">
                                <i class="fa fa-female" aria-hidden="true"></i>
                            </label>
                        </div>
                    </div>
                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="adressEmail">Identifiant</label>
                        <div class="col-md-9">
                             <input id="adressEmail" name="adressEmail" type="email" placeholder="" class="form-control input-md" required="">
                        </div>
                    </div>
                    <!-- Birth day-->
                    <div class="form-group">
                        <label class="col-md-3 control-label"> Date de naissance</label>
                        <div class="birth-day col-md-9">
                            <div class="input-wrapper">
                                <input  autocomplete="off" id="dteNaiss" name="dteNaiss" style="width:auto;" data-toggle="datepicker" type="text" value="" name="naissance" class="form-control input-md" required="">
                            </div>
                        </div>
                    </div>
                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="passUser">Mot de passe</label> 
                        <div class="col-md-9">
                            <input id="passUser" name="passUser" type="password" placeholder="" class="form-control input-md" required="">
                        </div>
                    </div>
                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="passUserBis">Confirmer Mot de passe</label>
                        <div class="col-md-9">
                            <input id="passUserBis" name="passUserBis" type="password" placeholder="" class="form-control input-md" required="">
                        </div>
                    </div>
                       <div class="row">
                        <div class="col-md-3"></div>
                        <div class="radio-box col-md-9">
                            <div class="form-group">
                                <div class="form-group">
                                    <h2>Adresse</h2>
                                </div>
                                <span class="adressTypeForm">Ceci est mon :</span>
                                <p>
                                    <input class="chb1" type="checkbox" id="shippingAdress" name="shippingAdress" checked>
                                    <label for="shippingAdress">Adresse de livraison</label>
                                </p>
                                <p>
                                   <input class="chb2" type="checkbox" id="billAdress" name="billAdress">
                                   <label for="billAdress">Adresse de facturation</label>
                                </p>
                                <p>
                                   <input class="chb1 chb2" type="checkbox" id="BillShip" name="BillShip">
                                   <label for="BillShip">Adresse de livraison et de facturation</label>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="adress-box-shipping">
                            <div>
                                <div class="form-group">
                                    <div class="col-md-3"></div>
                                    <h2 class="col-md-9">Adresse de livraison</h2>
                                </div> 
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="street-ship">Rue</label>
                                <div class="col-md-9">
                                     <input class="form-control" name="street-ship" id="street-ship" type="text">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="postalcodeShip">Code Postale</label>
                                <div class="col-md-9">
                                    <input class="form-control" name="postalcodeShip" id="postalcodeShip" type="text">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="cityShip">Ville</label>
                                <div class="col-md-9">
                                    <input class="form-control" name="cityShip" id="cityShip" type="text">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="countryShip">Pays</label>
                                <div class="col-md-9">
                                    <input class="form-control" name="countryShip" id="countryShip" type="text">
                                </div>
                            </div> 
                        </div>
                    </div>
                    <div class="row">
                        <div class="adress-box-billing">
                            <div>
                                <div class="form-group">
                                    <div class="col-md-3"></div>
                                    <h2 class="col-md-9">Adresse de facturation</h2>
                                </div>
                            </div>
                            <div class="form-group">
                                 <label class="col-md-3 control-label" for="streetBill">Rue</label>
                                 <div class="col-md-9">
                                     <input class="form-control" name="streetBill" id="streetBill" type="text">
                                 </div>
                            </div>
                            <div class="form-group">
                                 <label class="col-md-3 control-label" for="postalcodeBill">Code Postale</label>
                                 <div class="col-md-9">
                                      <input class="form-control" name="postalcodeBill" id="postalcodeBill" type="text">
                                 </div>
                            </div>
                            <div class="form-group">
                                 <label class="col-md-3 control-label" for="cityBill">Ville</label>
                                 <div class="col-md-9">
                                      <input class="form-control" name="cityBill" id="cityBill" type="text">
                                 </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="countryBill">Pays</label>
                                <div class="col-md-9">
                                    <input class="form-control" name="countryBill" id="countryBill" type="text">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="adress-box-shipBill">
                            <div>
                                <div class="form-group">
                                    <div class="col-md-3"></div>
                                     <h2 class="col-md-9">Adresse de livraison et de factuartion</h2>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" class="col-md-3" for="street-BillShip">Rue</label>
                                <div class="col-md-9">
                                     <input class="form-control" name="street-BillShip" id="street-BillShip" type="text">
                                </div>
                            </div>
                            <div class="form-group">
                                 <label class="col-md-3 control-label" class="col-md-3" for="postalcodeBillShip">Code Postale</label>
                                 <div class="col-md-9">
                                     <input class="form-control" name="postalcodeBillShip" id="postalcodeBillShip" type="text">
                                 </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" class="col-md-3" for="cityBillShip">Ville</label>
                                <div class="col-md-9">
                                    <input class="form-control" name="cityBillShip" id="cityBillShip" type="text">
                                </div> 
                            </div>
                            <div class="form-group">
                                 <label class="col-md-3 control-label" class="col-md-3" for="countryBillShip">Pays</label>
                                 <div class="col-md-9">
                                      <input class="form-control" name="countryBillShip" id="countryBillShip" type="text">
                                 </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="well well-lg clearfix text-right">
                             <a href="AllUsersServlet" class="btn btn-lg "><span><i class="fa fa-arrow-left"></i>Retour</span></a>
                             <button type="submit" class="btn btn-default btn-lg pull-right">Enregistrer</button>
                        </div>
                    </div>
                </fieldset>
            </div>
        </form>
     </div>
  </div>   
 </div>
 <!-- /#wrapper -->
 <script src="./assets/js/bower.js" type="text/javascript" charset="utf-8"></script>
 <script src="./assets/js/application.js" type="text/javascript" charset="utf-8"></script>        
</body>
</html>

