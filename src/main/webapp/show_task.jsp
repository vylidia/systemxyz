<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Задание ${taskName}</title>
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
    Ваша тема ${thema}
       <form id="ansUser" method="POST" action="${contextPath}/redirectToCurrentTask" class="form-common">
       Задача № ${taskName}. ${taskText}
       <br>Ответ:
                <br><input name="ansUser" type="text" placeholder="Введите ответ" value="${answer}" class="btn"
                                     autofocus="true"/>
                ${message}
                <br><br><button class="btn" type="submit">Проверить</button>
                <input type="hidden" name="taskId" value="${taskId}"/>
                <input type="hidden" name="thema" value="${thema}"/>
                <input type="hidden" name="course" value="${course}"/>

                <br>

       </form>
       </div>

        <table class="prev-next-table">
        <tr>
        <td>
        <form NAME="buttonNext" ACTION="${contextPath}/redirectPreviousTask" METHOD="POST" class="form-common">
          <INPUT TYPE="SUBMIT" VALUE="Предыдущая задача" class="btn-prev-next">
          <input type="hidden" name="taskName" value="${taskName}"/>
          <input type="hidden" name="thema" value="${thema}"/>
          <input type="hidden" name="course" value="${course}"/>
        </FORM>
       </td>
       <td>
      <form NAME="buttonNext" ACTION="${contextPath}/redirectNextTask" METHOD="POST" class="form-common">
             <INPUT TYPE="SUBMIT" VALUE="Следующая задача" class="btn-prev-next">
             <input type="hidden" name="taskName" value="${taskName}"/>
             <input type="hidden" name="thema" value="${thema}"/>
             <input type="hidden" name="course" value="${course}"/>
       </FORM>
        </td>
        </tr>
        </table>
    </body>
</html>
