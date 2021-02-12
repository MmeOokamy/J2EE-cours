<%@ page import="model.Region"%>


<%@ page language="java" import="java.util.*,java.lang.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Region region = (Region) request.getAttribute("region");
List<Region> regions = (List<Region>) request.getAttribute("listRegion");
ResourceBundle lang = (ResourceBundle) request.getAttribute("lang");
%>



<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="public/css/style.css">
<script src="public/js/jquery-3.5.1.min.js"></script>

<meta charset="UTF-8">
<title>Vue region avec langue et autre</title>

<script type="text/javascript">
//function btn(code){ 
	//alert(code);
	//document.getElementById('btn').value=code;
	//document.getElementById('form').submit();
	//}

</script>
</head>
<body>
	<h1><%= lang.getObject("region") %></h1>

	<div id="container">
		<form id="form" method="get" action="region">
		<div id="lang">
			<div>
				<label><%= lang.getObject("choixLangue") %></label>
			</div>
			
			<div class="img">
				<button type="submit" class="imgImg" name="btnFr"><img alt="" src="public/img/lang-fr.png"></button>
				<button type="submit" class="imgImg" name="btnEn"><img alt="" src="public/img/lang-en.png"></button>
				<button type="submit" class="imgImg" name="btnIt"><img alt="" src="public/img/lang-it.png"></button>
				<button type="submit" class="imgImg" name="btnDe"><img alt="" src="public/img/lang-de.png"></button>
			</div>
		</div>

		<hr>
			
		<div class="ligne">
			<label class="pwet"><%= lang.getObject("choixRegion") %></label> 
				<select class="item" id="choixRegion" name="choixRegion" onchange="document.getElementById('form').submit()">
				<option></option>
						
					<!-- avec for -->
						<%for(Region r : regions){ %>
						<% String selected=""; if(r.getNoRegion() ==  region.getNoRegion()){ selected="selected";} %>
						<option value="<%= r.getNoRegion() %>" <%= selected %> > <%= r.getNom() %></option>
						<% } %>
				</select>
		</div>
				
				<hr>
			
		
			<div id=labelInput>

				<div class="ligne">
					<label><%= lang.getObject("noRegion") %></label> 
					<input class="item" name="noRegion" value="<%= region.getNoRegion()%>">
				</div>
				<div class="ligne">
					<label><%= lang.getObject("nomRegion") %></label>
					<input class="item" name="nomRegion" value="<%=region.getNom()%>">
				</div>
				<div class="ligne">
					<label><%= lang.getObject("surfaceRegion") %></label>
					<input class="item" name="surfaceRegion" value="<%=region.getSurface()%>">
				</div>
				<div class="ligne">
					<label><%= lang.getObject("description") %></label>
					<textarea class="item" rows="10" cols="" name="descriptionRegion"><%=region.getDescription()%></textarea>
				</div>
				<div class="ligne">
					<label class="URL"><%= lang.getObject("urlRegion") %></label><input class="item"
						name="wikiRegion" value="<%=region.getUrlWiki()%>">
				</div>



			</div>
			<hr>
			<div id="btn">
				<input class="btn" type="submit" name="btnAdd" value="<%= lang.getObject("btnAdd") %>" onclick="btn('add')">
				<input class="btn" type="submit" name="btnSave" value="<%= lang.getObject("btnSave") %>" onclick="btn('save')">
				<input class="btn" type="submit" name="btnDelete" value="<%= lang.getObject("btnDelete") %>" onclick="btn('delete')">
			</div>
		</form>
	</div>

</body>
</html>