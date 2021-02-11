<%@page import="model.Departement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%

Departement dept = (Departement) request.getAttribute("dept");
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="jquery/jquery-3.5.1.min.js"></script>

<meta charset="UTF-8">
<title>Servlet View</title>
<script type="text/javascript">
function delete(){


</script>
</head>
<body>
	<h1>Département</h1>
	<hr>
	<div>
<form id="frm" action="" method="post">
		<div>
			<label> Numéro</label> <input value="<%= dept.getNoDept() %>" name="noDept">
		</div>
		<div>
			<label> N Région</label> <input value="<%= dept.getNoRegion() %>" name="noRegion">
		</div>
		<div>
			<label> Region</label> <input value="<%= dept.getRegion().getNom() %>" name="region">
		</div>
		
		<div>
			<label> Nom</label> <input value="<%= dept.getNom() %>" name="nom">
		</div>
		<div>
			<label> Nom Standard</label> <input value="<%= dept.getNomStd() %>" name="nomStd">
		</div>
		<div>
			<label> Surface</label> <input value="<%= dept.getSurface() %>" name="surface">
		</div>
		<div>
			<label> Nb Habitant</label> <input value="<%= dept.getNbHabitants() %>" name="nbHabitants">
		</div>
		<div>
			<label> Url</label> <input value="<%= dept.getUrlWiki() %>" name="url_wiki">
		</div>
		<div id="btn">
			<input type="submit" value="Ajouter" name="btnAdd" />
			<input type="submit" value="Supprimer" name="btnDelete" />
			<input type="submit" value="Enregistrer" name="btnSave" />
		</div>
</form>

	</div>




</body>
</html>