<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login</title>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet" />
  <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" />
</head>
<body>
<div class="login">
  <div class="background"></div>
  <form role="form" action="${pageContext.request.contextPath}/Register" method="post">
    <h1>Register</h1>
    <input name="username" placeholder="Username" required />
    <br />
    <input type="password" name="password" placeholder="Password" required />
    <input class="submit" type="submit" value="Register" />
    <a href="${pageContext.request.contextPath}/Login">Already have an account, login</a>
  </form>
</div>
</body>
</html>
