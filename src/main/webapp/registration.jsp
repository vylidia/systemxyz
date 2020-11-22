<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Регистрация</title>
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body>
    <div align="center"><h1>SYSTEM <u>XYZ</u>: твой главный помощник при обучении.</h1></div>
    <div class="container">
        <form:form method="POST" modelAttribute="userForm" class="form-signin">
            <h3>Создать новый аккаунт</h3>
            <spring:bind path="username">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="username" class="form-control" placeholder="Логин"
                                autofocus="true"></form:input>
                    <form:errors path="username"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="password" class="form-control" placeholder="Пароль"></form:input>

                    <form:errors path="password"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="passwordConfirm">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="passwordConfirm" class="form-control"
                                placeholder="Повторите пароль"></form:input>

                    <form:errors path="passwordConfirm"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="roles">
               <div class="form-group ${status.error ? 'has-error' : ''}">
               <p>
                   <c:forEach items="${roleList}" var="listElement">
                       ${listElement.namerus}
                       <form:checkbox path="roles" value="${listElement}"/>
                   </c:forEach>
               </p>
               </div>
            </spring:bind>
            <center>
            <button class="btn" type="submit">Создать</button>
            <button type="SUBMIT" class="btn" name="buttonCancel">Отменить</button>
            </center>
        </form:form>


    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>
