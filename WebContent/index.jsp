<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
<link rel="stylesheet" type="text/css" href="style.css" media="all" />
<link rel="stylesheet" type="text/css" href="demo.css" media="all" />
<script src="./scripts/jquery-1.11.3.js"></script>
<title>Dobro dosli u AutoKucu</title>
</head>
<body>
<div class="container">

<br><br><br><br>
			<header>
				<h1><span>AUTO KUCA</span>			
				Boris Zaharic
				</h1>
            </header>  
<div  class="form">
<form id="contactform" method="post" action="../AutoKuca/LoginServlet" class="login">
    <p class="contact">
      <label for="username">Username:</label>
      
    </p>
    <input id="username" type="text" name="username" value="">

    <p class="contact">
      <label for="password">Password:</label>
      
    </p>
    <input id="password" type="password" name="password" value="">

    <input type="submit" value="Ulogujte se!">
	<br>
	<div align="center" id="poruka">${poruka}</div><br>
  </form>
  <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
</fb:login-button>
<div id='status'></div>
  </div>
  
  
 
 </div>
</body>
<script>
(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));
  
  window.fbAsyncInit = function() {
  FB.init({
    appId      : '1649281665320108',
    cookie     : true,  // enable cookies to allow the server to access 
                        // the session
    xfbml      : true,  // parse social plugins on this page
    version    : 'v2.5' // use version 2.2
  });	
  }
  
  function checkLoginState() {
	    FB.getLoginStatus(function(response) {
	      statusChangeCallback(response);
	    });
	  }
  
  function statusChangeCallback(response) {
	    // The response object is returned with a status field that lets the
	    // app know the current login status of the person.
	    // Full docs on the response object can be found in the documentation
	    // for FB.getLoginStatus().
	    if (response.status === 'connected') {
	      // Logged into your app and Facebook.
	      var accessToken = response.authResponse.accessToken;
	      $.ajax({
	    	  url:'LoginServlet',
	    	  data: {'access-token': accessToken},
	    	  success: function(){
	    		  window.location = 'JSPStranice/Autokuca.jsp';
	    	  }
	      })
	     	console.log(accessToken)
	    } else if (response.status === 'not_authorized') {
	      // The person is logged into Facebook, but not your app.
	      document.getElementById('status').innerHTML = 'Please log ' +
	        'into this app.';
	    } else {
	      // The person is not logged into Facebook, so we're not sure if
	      // they are logged into this app or not.
	      document.getElementById('status').innerHTML = 'Please log ' +
	        'into Facebook.';
	    }
	  }
  </script>
</html>