<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Accident</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <link href="../../styles/style.css">
</head>
<body>

<div class="container">
    <table class="table" id="accidents">
        <thead class="thead-dark">
        <tr>
            <th>Идентифкатор нарушения</th>
            <th>Имя</th>
            <th>Описание</th>
            <th>Адрес</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="accident" items="${accidents}">
            <tr>
                <td><label class="form-check-label" id="id"><c:out value="${accident.id}"/></label></td>
                <td><label class="form-check-label" id="name"><c:out value="${accident.name}"/></label></td>
                <td><label class="form-check-label" id="description"><c:out value="${accident.text}"/></label></td>
                <td><label class="form-check-label" id="address"><c:out value="${accident.address}"/></label></td>
                <td><a href="<c:url value='/update?id=${accident.id}'/>">Обновить</a></td>
            </tr>
        </c:forEach>
        <a href="<c:url value='/create'/>">Добавить инцидент</a>

        </tbody>
    </table>
</div>
</body>
</html>


<%--SPRING DATA--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Accident</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<c:forEach items="${accidents}" var="accident">--%>
<%--    <c:out value="${accident.name}"/></br>--%>
<%--</c:forEach>--%>
<%--</body>--%>
<%--</html>--%>