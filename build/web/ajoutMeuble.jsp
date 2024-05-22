<%@page import="metier.Matiere"%>
<%@page import="metier.Style"%>
<%@page import="java.util.Vector"%>
<%
    Vector<Matiere> m = (Vector<Matiere>) request.getAttribute("listeMatiere");;
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Navigation avec Bootstrap</title>
  <link rel="stylesheet" href="bootstrap.min.css">
</head>
<style>
    body{
        padding: 30px;
    }
    .panel{
        padding: 30px;
        margin-top: 20px;
    }
    .cover{
        height: 80vh;
    }
</style>
<body>

    <div class="row">
      <div class="col-md-3">
        <ul class="nav nav-pills nav-stacked">
          <li role="presentation" class="active"><a href="Default">Style</a></li>
          <li role="presentation"><a href="CMeuble">Meuble</a></li>
          <li role="presentation"><a href="#">Categorie</a></li>
          <li role="presentation"><a href="matiere.jsp">Matiere</a></li>
          <li role="presentation"><a href="Getmatiere">Stock</a></li>
          <li role="presentation"><a href="metier.jsp">Metier</a></li>
          <li role="presentation"><a href="AddEmployer">Employer</a></li>
          <li role="presentation"><a href="Client.jsp">Client</a></li>
          <li role="presentation"><a href="Vente">Vente</a></li>
        </ul>
      </div>
      <div class="col-md-9">
          
        <nav class=" navbar-default">
          <ul class="nav nav-tabs">
                <li role="presentation"><a href="CMeuble">Ajouter</a></li>
                <li role="presentation"><a href="Recherche">Rechercher</a></li>
                <li role="presentation"><a href="FiliterForm.jsp">Filtre prix</a></li>
                <li role="presentation"><a href="FilterBenefice.jsp">Filtre benefice</a></li>
                <li role="presentation"><a href="Fabrique">Metier Meuble</a></li>
                <li role="presentation"><a href="FabriqueMeuble">Fabrique</a></li>
          </ul>
        </nav>
          <div class="panel panel-default cover">
              <h1>Configuration Meuble :</h1>
                 <form method="GET" action="AjoutMeuble">
                    <div class="row ">
                        <div class="input-group mb-3  col-lg-12">
                            <label>Nom</label>
                            <input type="text" name="nom" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" required>
                       </div>
                    </div>
                    <div class="row ">
                        <div class="input-group mb-3  col-lg-12">
                            <label>Taille</label>
                            <input type="text" name="taille" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" required>
                       </div>
                    </div>                     
                    <div class="row " id="dd">
                        <div class=" col-lg-6">
                                <label class="input-group-text" for="matiere">Matiere</label>
                                  <select class="form-control" id="diplome" name="matiere">
                                    <% for(int i=0;i<m.size();i++) { %>
                                        <option value=<%= m.get(i).getIdMatiere() %>><%= m.get(i).getNom() %></option>
                                    <% } %>
                                  </select>
                        </div>
                        <div class=" col-lg-6">
                            <div class="input-group mb-3 ">
                                <label class="input-group-text" for="qte">Quantite</label>
                                <input type="number" name="quantite" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" required>
                           </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-group mb-3">
                            <div class="col-lg-6"><button type="button" class="btn btn-outline-success " id="plus">PLUS</button></div>
                            <div class="col-lg-6"><button type="button" class="btn btn-outline-danger " id="moin">MOIN</button></div>
                        </div>
                    </div>
                    <div class="col-12 ">
                        <button type="submit" class="btn btn-primary col-12 mt-2" data-bs-toggle="modal" data-bs-target="#exampleModal">Enregistrer</button>
                    </div>
                </form>
          </div>
</body>
</html>

  <script>
   
        var dd = document.getElementById("dd");
        var btn1 =  document.getElementById("plus");
        var btn2 = document.getElementById("moin");
        var moov = `<div class="row " id="dd">
                        <div class=" col-lg-6">
                            <div class="input-group mb-3 ">
                                <label class="input-group-text" for="matiere">Matiere</label>
                                  <select class="form-control" id="diplome" name="matiere">
                                    <% for(int i=0;i<m.size();i++) { %>
                                        <option value=<%= m.get(i).getIdMatiere() %>><%= m.get(i).getNom() %></option>
                                    <% } %>
                                  </select>
                           </div>
                        </div>
                        <div class=" col-lg-6">
                            <div class="input-group mb-3 ">
                                <label class="input-group-text" for="quantite">Quantite</label>
                                <input type="number" name="quantite" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" required>
                           </div>
                        </div>
                    </div>`;

        btn1.addEventListener('click', () => {
            let po  = document.createElement("div");
            po.innerHTML = moov;
            dd.appendChild(po); 
        });
        btn2.addEventListener('click', () => {
          var remove = dd.lastElementChild;
          if (dd.children.length > 2 ) {
            dd.removeChild(remove);
          }
        });
  </script>
