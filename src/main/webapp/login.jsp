
<!DOCTYPE html>
<html>
<head>
	 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">		
	 <title>Login Page</title>
</head>
<body>
<center>
	 <div id="mystyle" class="myform">
		 <form id="form" name="form" method="post" action="LoginServlet">
			 <h1>Login</h1>
			 <p>Please enter your login information
				 <br/></p>
			 <label>username
				 <span class="small">Enter your username</span>
			 </label>
			 <input type="text" name="username" id="username" />

			 <label>Password
				 <span class="small"></span>
			 </label>
			 <input type="password" name="passwd" id="passwd" />

			 <button type="submit">Log-in</button>
			 <div class="spacer"></div>
		 </form>
	 </div>
</center>
</body>
</html>