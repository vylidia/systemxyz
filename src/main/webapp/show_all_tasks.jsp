<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Задача ${taskName}</title>
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

    <div class="upcontainer">
            <table>
            <tr>
            <td><form NAME="buttonNext" ACTION="${contextPath}/course" METHOD="GET" class="form-common">
                <INPUT TYPE="SUBMIT" VALUE="Выбрать курс" class="btn-redirect">
            </form></td>
            <td><form NAME="buttonNext" ACTION="${contextPath}/${course}/thema" METHOD="GET" class="form-common">
                <INPUT TYPE="SUBMIT" VALUE="Выбрать тему" class="btn-redirect">
            </form></td>
            <td><form NAME="buttonNext" ACTION="${contextPath}/${course}/${thema}/task" METHOD="GET" class="form-common">
                <INPUT TYPE="SUBMIT" VALUE="Выбрать задачу" class="btn-redirect">
            </form></td>
            </tr>
            </table>
        </div>

    <div class="container">
      Ваша тема: ${thema.themaName}
      <br>
       <form id="ansUser" method="GET" action="${contextPath}/${course}/${thema.thema}/allTasks" class="form-common">
             <c:forEach var = "listElement" items ="${listTask}" varStatus="loop">
                      ${listElement.taskName}. ${listElement.taskText}
                      <input name="ansUser" type="text" placeholder="Ответ" value="${answer[loop.index]}" class="btn"
                                                           autofocus="true"/>
                      <input type="hidden" name="taskId" value="${listElement.id}"/>
                      ${messageList[loop.index]}
                      <br>

             </c:forEach>
             <br><button class="btn" type="submit">Проверить</button>
              ${messageResult}
              <input type="hidden" name="thema" value="${thema.thema}"/>
              <input type="hidden" name="course" value="${course}"/>
       </form>
    </div>
  </body>
</html>
