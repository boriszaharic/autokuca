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
<title>Dodajte novi automobil</title>
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
<form id="contactform" method="post" action="/AutoKuca/DodajAutomobilServlet" class="login">
<div><p class="contact"><label for="username">Kategorija:</label></p>
<select name="kat">
<c:forEach items="${sveKategorije.kategorije}" var="kat">
		<option value="${kat.idkategorije}">${kat.nazivkategorije} </option>
</c:forEach>
</select></div>
<div><p class="contact"><label for="username">Marka:</label></p><input type="text" name="marka" value=""></div>
<div><p class="contact"><label for="username">Model:</label></p><input type="text" name="model" value=""></div>
<div><p class="contact"><label for="username">Boja:</label></p><input type="text" name="boja" value=""></div>
<div><p class="contact"><label for="username">Godina proizvodnje:</label></p><input type="text" name="godina" value=""></div>
<div><p class="contact"><label for="username">Cena:</label></p><input type="text" name="cena" value=""></div>
<br>
<input type="submit" value="Unesite novi automobil!">
</form>
</div>
<br>
<div align="center">${poruka}</div>
<br>
<div align="center"><a href="/AutoKuca/JSPStranice/Autokuca.jsp"><span><span><span>Meni</span></span></span></a></div>

<br><br>
</div>
</body>
</html>