<%@ page import="model.Region"%>

<%@ page language="java" import="java.util.*,java.lang.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Region region = (Region) request.getAttribute("region");
List<Region> regions = (List<Region>) request.getAttribute("listRegion");
%>



<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="public/css/style.css">
<script src="public/js/jquery-3.5.1.min.js"></script>

<meta charset="UTF-8">
<title>Region Vue initial</title>
</head>
<body>
	<h1>Région</h1>

	<div id="container">
		<div id="lang">
			<div>
				<label>Choix de la langue :</label>
			</div>
			<div class="img">
				<img alt="" src="public/img/lang-fr.png">
				<img alt="" src="public/img/lang-en.png">
				<img alt="" src="public/img/lang-it.png">
				<img alt="" src="public/img/lang-de.png">
			</div>
		</div>

		<hr>
		
		<div class="ligne">
			<label class="pwet">Choix d'une Région :</label> 
				<select class="item" id="choixRegion" name="choixRegion">
				<option></option>
					<!-- avec iterator -->
<%-- 						<% Iterator<Region> it = regions.iterator(); --%>
<%-- 						while (it.hasNext()) { %> --%>
<%-- 						<option><%=it.next()%></option> --%>
<%-- 						<%}%> --%>
						
					<!-- avec for -->
						<%for(Region r : regions){ %>
						<option value="<%= r.getNoRegion() %>"> <%= r.getNom() %></option>
						<% } %>
				</select>
		</div>
				
				<hr>
				
		<form method="post" action="region">
			<div id=labelInput>

				<div class="ligne">
					<label>N° de Région :</label> 
					<input class="item" name="noRegion" value="<%= region.getNoRegion()%>">
				</div>
				<div class="ligne">
					<label>Nom :</label>
					<input class="item" name="nomRegion" value="<%=region.getNom()%>">
				</div>
				<div class="ligne">
					<label>Surface :</label>
					<input class="item" name="surfaceRegion" value="<%=region.getSurface()%>">
				</div>
				<div class="ligne">
					<label>Description :</label>
					<textarea class="item" rows="10" cols="" name="descriptionRegion"><%=region.getDescription()%></textarea>
				</div>
				<div class="ligne">
					<label class="URL">URL Wikipédia :</label><input class="item"
						name="wikiRegion" value="<%=region.getUrlWiki()%>">
				</div>



			</div>
			<hr>
			<div id="btn">
				<input class="btn" type="submit" name="btnAdd" value="Ajouter">
				<input class="btn" type="submit" name="btnSave" value="Enregistrer">
				<input class="btn" type="submit" name="btnDelete" value="Supprimer">
			</div>
		</form>
	</div>

</body>
</html>