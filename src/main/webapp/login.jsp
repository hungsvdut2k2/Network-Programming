<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
		<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" />
    </head>
    <body>
        <div class="background"></div>
        <form role="form" action="${pageContext.request.contextPath}/Login" method="post">
            <h1>Login</h1>
            <input name="username" placeholder="Username"  required />
            <br />
            <input type="password" name="password" placeholder="Password" requireds />
            <input class="submit" type="submit" value="Login" />
        </form>
    </body>
</html>
