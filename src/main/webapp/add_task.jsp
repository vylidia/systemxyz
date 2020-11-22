<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Создать задачу</title>
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
        <form:form method="POST" modelAttribute="taskForm" class="form-signin">
            <h3>Создать свою задачу</h3>
            <spring:bind path="taskName">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="taskName" class="form-control" placeholder="Номер задачи"
                                autofocus="true"></form:input>

                    <form:errors path="taskName"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="taskText">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="taskText" class="form-control" placeholder="Текст задачи"
                                            autofocus="true"></form:input>

                                <form:errors path="taskText"></form:errors>
                            </div>
            </spring:bind>

            <spring:bind path="answer">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="answer" class="form-control" placeholder="Ответ"
                                            autofocus="true"></form:input>

                                <form:errors path="answer"></form:errors>
                            </div>
            </spring:bind>

             <spring:bind path="solve">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="solve" class="form-control" placeholder="Решение"
                                            autofocus="true"></form:input>

                                <form:errors path="solve"></form:errors>
                            </div>
              </spring:bind>



            <spring:bind path="idThema">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="hidden" path="idThema" value="${idThema}" class="form-control"></form:input>

                <form:errors path="idThema"></form:errors>
                </div>
            </spring:bind>

            <center>
            <button class="btn" type="submit">Создать</button>
            <button type="SUBMIT" class="btn" name="buttonCancel">Отменить</button>
            </center>
            <input type="hidden" name="course" value="${course}"/>
            <input type="hidden" name="thema" value="${thema}"/>
        </form:form>
    </div>
  </body>
</html>
