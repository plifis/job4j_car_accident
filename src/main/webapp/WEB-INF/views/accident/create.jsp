<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form  action="<c:url value='/save'/>" method='POST'>
    <table>
        <tr>
            <td>Имя:</td>
            <td><input type='text' name='name'></td>
            <td>Описание:</td>
            <td><input type='text' name='text'></td>
            <td>Адрес:</td>
            <td><input type='text' name='address'></td>
            <td>Тип:</td>
            <td> <select name="type.id">
                <c:forEach var="type" items="${types}" >
                    <option value="${type.id}">${type.name}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Сохранить" /></td>
        </tr>
    </table>
</form>
</body>
</html>