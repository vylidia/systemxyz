<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="eng">
<head>
    <meta charset="utf-8">
    <title>Курс</title>
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>
  <div class="headtext"> Вы вошли как ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()" class="alink">Logout</a> </div>
  <div align="center"><h1>SYSTEM <u>XYZ</u>: твой главный помощник при обучении.</h1></div>
  <div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </c:if>
        Вы можете ознакомиться с предлагаемыми курсами и выбрать любой из них для обучения.
        <form id="courSelectForm" method="POST" action="${contextPath}/redirectToThema" class="form-common">
            <table>
                <tr>
                    <td>
                        <form:select path="courseList" name="course">
                        <form:option value="NONE" label="Выберите курс:"/>
                        <c:forEach var="listElement" items="${courseList}">
                        <form:option value="${listElement.course}" label="${listElement.courseName}"/>
                        </c:forEach>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><input type="submit" class="btn"/></td>
                </tr>
            </table>
            <c:if test="${showCreate == true}">
                 <a href="${contextPath}/add_course">Создать новый курс</a>
            </c:if>
        </form>
  </div>
</body>
</html>
