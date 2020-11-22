<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Создать курс</title>
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
        <form:form method="POST" modelAttribute="courseForm" class="form-signin">
            <h3>Создать свой курс</h3>
            <spring:bind path="course">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="course" placeholder="Код курса (английскими буквами)" class="form-control"
                                autofocus="true"></form:input>

                    <form:errors path="course"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="courseName">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="courseName" class="form-control" placeholder="Название курса"
                                            autofocus="true"></form:input>

                                <form:errors path="courseName"></form:errors>
                            </div>
                        </spring:bind>
            <spring:bind path="idUser">
              <form:input type="hidden" path="idUser" value="${idUser}" class="form-control"></form:input>
            </spring:bind>
            <center>
            <button class="btn" type="submit">Создать</button>
            <button type="SUBMIT" class="btn" name="buttonCancel">Отменить</button>
            </center>
        </form:form>


    </div>

  </body>
</html>
