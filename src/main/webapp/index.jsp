<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home</title>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" />
</head>
<body>
  <div class="container">
    <form role="form" method="post"
          action="${pageContext.request.contextPath}/Search">
      <select name="value" id="cars">
        <option value="Alpinia Galanga">Alpinia Galanga</option>
        <option value="saab">Saab</option>
        <option value="opel">Opel</option>
        <option value="audi">Audi</option>
      </select>
      <br><br>
      <input type="submit" value="Submit">
      <div>
<%--        ${corpusList}--%>
        <c:forEach items="${corpusList}" var="corpus" varStatus="loop">
          <td>${loop.index+1}</td>
          <br>
          <td>${corpus.getTitle()}</td>
          <br>
        </c:forEach>
      </div>
    </form>
  </div>
</body>
</html>