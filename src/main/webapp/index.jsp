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
                <select name="value" id="cars">
                    <option value="Alpinia Galanga">Alpinia Galanga</option>
                    <option value="Aramanthus Viridis">Aramanthus Viridis</option>
                    <option value="Jasminum">Jasminum</option>
                    <option value="Mentha">Mentha</option>
                </select>
                <br /><br />
                <input type="submit" value="Submit" />
            </form>
            <div class="result">
                <c:forEach items="${corpusList}" var="corpus" varStatus="loop">
                    <div class="card">
                        <div class="categories">Article #${corpus.getCorpusId}</div>
                        <div class="title">${corpus.getTitle()}</div>
                        <div class="content">${corpus.getContent}</div>
                        <div class="details">
                            <button>Read more</button>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
