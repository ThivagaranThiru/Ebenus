<%-- 
    Document   : allProduits
    Created on : 7 avr. 2019, 22:11:55
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
        <!--li class="dropdown">
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
        </li-->
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
         <!-- Page Heading -->
        <div class="row">
          <div class="col-lg-12">
            <h1 class="page-header">
              Produits
            </h1>
            <ol class="breadcrumb">
              <li>
                <i class="fa fa-dashboard"></i>  <a href="DashboardServlet">Dashboard</a>
              </li>
              <li class="active">
                <i class="fa fa-edit"></i> Produits
              </li>
            </ol>
          </div>
        </div>
        <!-- /.row -->
         <div class="row">
            <div class="well well-lg clearfix">
              <form action="AddProduitServlet">
                <button class="btn btn-default btn-lg pull-right">
                  Ajouter Produit
                </button>
              </form>
            </div>
         </div>
          <!-- /.row -->
          <div class="row">
            <div class="panel panel-default">
              <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-money"></i> Liste des Produits</h3>
              </div>
              <div class="panel-body">
                <div class="row">
                  <div class="well well-sm col-lg-6"> 
                    <form action="#" method="get">
                    <div class="input-group">
                        <!-- USE TWITTER TYPEAHEAD JSON WITH API TO SEARCH -->
                        <input class="form-control" id="system-search" name="q" placeholder="Rechercher un produit" required>
                        <span class="input-group-btn">
                            <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                        </span>
                    </div>
                     </form>
                  </div>
                  <div class="col-lg-6 no-padding">
                       <form action="#" method="post" enctype="multipart/form-data">
                    <!-- Select Basic -->
              <div class="form-group selectexport-box">
         <div class="input-file-box"> 
          <input type="file" name="file-2[]" id="file-2" class="inputfile inputfile-2" data-multiple-caption="{count} files selected" multiple />
          <label for="file-2"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg> <span>Importer des produits à partir d'un fichier CSV</span></label>
        </div>
                <button type="submit" class="btn btn-default">Import</button>
              </div>
                    </form>
                  </div>
                    
                </div>
                <div class="table-responsive listProducts">
                  <table class="table table-bordered table-hover table-striped">
                    <thead>
                      <tr>
                        <th>ID</th>
                        <!--th>Image</th-->
                        <th>Nom</th>
                        <th>Référence</th>
                        <th>Prix</th>
                        <th>Quantité</th>
                        <th>Action</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${produitList}" var="produitList">
                      <tr>
                        <td>${produitList.idProduit}</td>
                        <!--td><img class="admin__control-thumbnail" src="./assets/images\products/360365.350.350.jpg" alt="Lorem ipsum dolor."></td-->
                        <td>${produitList.nom}</td>
                        <td>${produitList.reference}</td>
                        <td>${produitList.prix}</td>
                        <td>${produitList.stock}</td>
                        <td>
                        <a href="UpdateProduitServlet?idProduit=${produitList.idProduit}"><button type="submit"><i class="fa fa-edit"></i></button></a>
                        <a href="AllProduitsServlet?idProduit=${produitList.idProduit}"><button type="submit"><i class="fa fa-trash-o"></i></button></a>
                        </td>
                      </tr>
                       </c:forEach>
                    </tbody>
                  </table>
                </div>
                
              </div>
            </div>
          </div>
      </div>
      <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->
  </div>
  <!-- /#wrapper -->
 <script src="./assets/js/bower.js" type="text/javascript" charset="utf-8"></script>
  <script src="./assets/js/application.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
