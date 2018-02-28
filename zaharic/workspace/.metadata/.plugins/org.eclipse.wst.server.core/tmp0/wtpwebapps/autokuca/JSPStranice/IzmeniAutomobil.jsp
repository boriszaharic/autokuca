<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<jsp:useBean id="sveKategorije" class="beans.SveKategorijeBean" scope="page"></jsp:useBean>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
<link rel="stylesheet" type="text/css" href="/AutoKuca/style.css" media="all" />
<link rel="stylesheet" type="text/css" href="/AutoKuca/demo.css" media="all" />
<title>Izmenite automobil</title>
</head>
<body>
<div class="container">

<br><br><br><br>
			<header>
				<h1><span>AUTO KUCA</span>			
				Boris Zaharic
				</h1>
            </header>  
            <br><br><br>
<div  class="form">
<form method="post" action="/AutoKuca/IzmeniAutomobilServlet" class="login">
<div><label>Kategorija:</label><select name="kat">
<c:forEach items="${sveKategorije.kategorije}" var="kat">
		<c:choose>
     	 	<c:when test="${vozilo.kategorija.idkategorije == kat.idkategorije}">
				<option selected="selected" value="${kat.idkategorije}">${kat.nazivkategorije} </option>
     		 </c:when>
      		<c:otherwise>
      			<option value="${kat.idkategorije}">${kat.nazivkategorije} </option>
      		</c:otherwise>
		</c:choose>
</c:forEach>
</select></div>
<div><label>Marka:</label><input type="text" name="marka" value="${vozilo.marka}"></div>
<div><label>Model:</label><input type="text" name="model" value="${vozilo.model}"></div>
<div><label>Boja:</label><input type="text" name="boja" value="${vozilo.boja}"></div>
<div><label>Godina proizvodnje:</label><input type="text" name="godina" value="${vozilo.godinaproizvodnje}"></div>
<div><label>Cena:</label><input type="text" name="cena" value="${vozilo.cena}"></div>

<input type="submit" value="Izmenite automobil!">
</form>
</div>
<br>
<div>${poruka}</div>
<br>
<div align="center"><a href="/AutoKuca/JSPStranice/Autokuca.jsp">Meni</a></div>
</div>
</body>
</html>