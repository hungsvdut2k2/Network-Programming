<%@ taglib prefix="c" uri="jakarta.tags.core" %> <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Home</title>
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <form class="filter" role="form" method="post" action="${pageContext.request.contextPath}/Search">
                <input id="username" type="hidden" name="username" value="${username}">
                <select name="value" id="cars">
                    <option value="Alpinia Galanga">Alpinia Galanga</option>
                    <option value="Aramanthus Viridis">Aramanthus Viridis</option>
                    <option value="Jasminum">Jasminum</option>
                    <option value="Mentha">Mentha</option>
                </select>
                <br /><br />
                <input type="submit" value="Submit" />
                <button class="logout" onclick="Logout()">Log out</button>
            </form>
            <div class="result">
                <c:forEach items="${corpusList}" var="corpus" varStatus="loop">
                    <div class="card">
                        <div class="categories">Article #${corpus.getCorpusId()}</div>
                        <div class="title">${corpus.getTitle()}</div>
                        <div class="content">${corpus.getContent()}</div>
                        <div class="details">
                            <button>Read more</button>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    <script>
        let username = '<%= request.getAttribute("username") %>'
        if (username !== "null") {
            localStorage.setItem('username', username)
        } else {
            localStorage.setItem('username', "Guest")
        }
        if (localStorage.getItem("username") === "Guest") {
            location.replace("http://localhost:8080/NetworkProgramming_war_exploded/Login?username=Guest");
        }
        document.getElementById("username").value = localStorage.getItem("username")
        function Logout() {
            localStorage.setItem('username', 'Guest')
            let loginURL = location.href.substring(0, location.href.lastIndexOf('/'))+ "/Login";
            location.replace(loginURL);
        }
    </script>
    </body>
</html>
