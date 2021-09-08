<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form action="<c:url value='/save?id=${accident.id}'/>" method='POST'>
    <table>
        <thead>
        <tr>
            <th>Имя</th>
            <th>Описание</th>
            <th>Адрес</th>
        </tr>
        </thead>
        <tbody>
            <tr>
            <tr>
                <td>Имя:</td>
                <td><input type='text' name='name' value="<c:out value="${accident.name}"/>"></td>
                <td>Описание:</td>
                <td><input type='text' name='text' value="<c:out value="${accident.text}"/>"></td>
                <td>Адрес:</td>
                <td><input type='text' name='address' value="<c:out value="${accident.address}"/>"></td>
            </tr>
                <td><input name="submit" type="submit" value="Обновить" /></td>
            </tr>

        </tbody>
    </table>
</form>
</body>
</html>