<%@page import="controller.CalculController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String formule = request.getParameter("ecran");
if (formule == null) {
	formule = "0";
}
String result = CalculController.calculer(formule);
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="jquery/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="style/cal.css">
<meta charset="UTF-8">
<title>Calculatrice du Pauvre</title>


<script type="text/javascript">

	function raz() {
		document.getElementById("ecran").value = "0";
	}
	function touche(obj) {
		var ecran = document.getElementById("ecran").value;
		if (parseInt(ecran) == 0) {
			document.getElementById("ecran").value = obj.value;
		} else {
			document.getElementById("ecran").value += obj.value;
			console.log(obj.value);
		}
	}
	function calcul() {
		document.getElementById("formCalcu").submit();
		console.log("click");
	}
</script>


</head>
<body>

	<h1>Calculatrice JSP du FUTUUUUUURR!</h1>

	<div id="calculBox">
	
		<form id="formCalcu" name="formCalcu" method="get" action="">
			<div id="ecranCalculatrice">
				<input id="ecran" name="ecran" type="text" readonly value="<%= result %>" />
			</div>
			<div id="touches">
				<div>
					<input type="button" onclick="raz()" value="C">
				</div>
				<div id="operateur">
					<input type="button" onclick="touche(this)" value="/"> 
					<input type="button" onclick="touche(this)" value="*"> 
					<input type="button" onclick="touche(this)" value="-"> 
					<input type="button" onclick="touche(this)" value="+">
				</div>
				
				<div>
					<input type="button" onclick="touche(this)" value="7">
					<input type="button" onclick="touche(this)" value="8">
					<input type="button" onclick="touche(this)" value="9">
				</div>
				
				<div>
					<input type="button" onclick="touche(this)" value="4">
					<input type="button" onclick="touche(this)" value="5"> 
					<input type="button" onclick="touche(this)" value="6">
				</div>
				
				<div>
					<input type="button" onclick="touche(this)" value="1">
					<input type="button" onclick="touche(this)" value="2">
					<input type="button" onclick="touche(this)" value="3">
				</div>

				<div>
					<input type="button" onclick="touche(this)" value="0">
					<input type="button" onclick="touche(this)" value=".">
					<input type="button" onclick="calcul()" value="=">
				</div>
			</div>
		</form>
	</div>
</body>
</html>