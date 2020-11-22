<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Вход в system xyz</title>
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>
  <body>
      <div align="center"><h1>SYSTEM <u>XYZ</u>: твой главный помощник при обучении.</h1></div>
      <div class="container">
      <form method="POST" action="${contextPath}/login" class="form-signin">
        <h3>Войдите в аккаунт</h3>
        <div class="form-group ${error != null ? 'has-error' : ''}">
            <c:if test="${message != null}">
                ${message}
                <br>
            </c:if>

            <input name="username" type="text" class="form-control" placeholder="Логин"
                   autofocus="true"/>
            <br><input name="password" type="password" class="form-control" placeholder="Пароль"/>
            <br>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>
            <p><button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
            <a href="${contextPath}/registration">Регистрация</a></p>
        </div>
      </form>
    </div>
  </body>
</html>
