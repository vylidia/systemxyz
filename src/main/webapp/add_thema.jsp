<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Создать тему</title>
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body>
    <div class="headtext"> Вы вошли как ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()" class="alink">Logout</a> </div>
    <div align="center"><h1>SYSTEM <u>XYZ</u>: твой главный помощник при обучении.</h1></div>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
                 <form id="logoutForm" method="POST" action="${contextPath}/logout">
                     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                 </form>
    </c:if>

    <div class="container">

        <form:form method="POST" modelAttribute="themaForm" class="form-signin">
            <h3>Создать свою тему</h3>
            <spring:bind path="thema">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="thema" class="form-control" placeholder="Код темы (английскими буквами)"
                                autofocus="true"></form:input>

                    <form:errors path="thema"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="themaName">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="themaName" class="form-control" placeholder="Название"
                                            autofocus="true"></form:input>
                                <form:errors path="themaName"></form:errors>
                            </div>
                        </spring:bind>

            <spring:bind path="idCourse">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="hidden" path="idCourse" value="${idCourse}" class="form-control"></form:input>
                <form:errors path="idCourse"></form:errors>
                </div>
            </spring:bind>

            <center>
            <button class="btn" type="submit">Создать</button>
            <button type="SUBMIT" class="btn" name="buttonCancel">Отменить</button>
            </center>

            <input type="hidden" name="course" value="${course}"/>
        </form:form>
    </div>
  </body>
</html>
