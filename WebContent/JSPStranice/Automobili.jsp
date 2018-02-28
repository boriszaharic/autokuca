<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<jsp:useBean id="vozila" class="beans.SviSlobodniAutomobiliBean" scope="page"></jsp:useBean>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
<link rel="stylesheet" type="text/css" href="/AutoKuca/style.css" media="all" />
<link rel="stylesheet" type="text/css" href="/AutoKuca/demo.css" media="all" />
<title>Pregled Automobila</title>
</head>
<body>
<div class="container">

<br><br><br><br>
			<header>
				<h1><span>AUTO KUCA</span>			
				Boris Zaharic
				</h1>
            </header>  <br><br><br>
<br>
<div  class="form">
<table>
<tr>
		<td><label>Marka:</label></td>
		<td><label>Model:</label></td>
		<td><label>Boja:</label></td>
		<td><label>Cena:</label></td>
		<td><label>Godina proizvodnje:</label></td>
		<td><label>Kategorija:</label></td>
</tr>
<c:forEach items="${vozila.automobili}" var="cars">
		<tr>
		<td><div>${cars.marka}&nbsp;&nbsp;&nbsp;</div></td>
		<td><div>${cars.model}&nbsp;&nbsp;&nbsp;</div></td>
		<td><div>${cars.boja}&nbsp;&nbsp;&nbsp;</div></td>
		<td><div>${cars.cena}&nbsp;&nbsp;&nbsp;</div></td>
		<td><div>${cars.godinaproizvodnje}&nbsp;&nbsp;&nbsp;</div></td>
		<td><div>${cars.kategorija.nazivkategorije}&nbsp;&nbsp;&nbsp;</div></td></tr>
		
		<tr>
		<td><div><a href="/AutoKuca/ProdajAutomobilServlet?idAutomobila=${cars.idvozila}">Prodaj</a></div></td>
		<td><div><a href="/AutoKuca/IzmeniAutomobilServlet?idAutomobila=${cars.idvozila}">Izmeni</a></div></td>
		<td><div><a href="/AutoKuca/IzbrisiAutomobilServlet?idAutomobila=${cars.idvozila}">Izbrisi</a></div></td>
		</tr> <tr></tr>
</c:forEach>


</table>
<br><br>
</div>
<br>
<div align="center">${poruka}</div>
<br>
<div align="center"><a href="/AutoKuca/JSPStranice/Autokuca.jsp"><span><span><span>Meni</span></span></span></a></div> <br><br><br>
</div>
</body>
</html>