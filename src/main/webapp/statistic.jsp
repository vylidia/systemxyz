<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Статистика по курсу ${courseName}</title>
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
        </tr>
        </table>
    </div>

    <div class="container">
    Ваш курс ${courseName}
        <form id="stat" method="GET" action="${contextPath}/${course}/statistic" class="form-common">
        <table border="1" cellpadding="10" cellspacing="3" width="100%">
            <tr>
            <th>Студент</th><th>Курс</th><th>Тема</th><th>Результат</th><th>Дата</th>
            </tr>
            <c:forEach var = "listElement" items ="${statList}" varStatus="loop">
            <tr>
            <th>${listElement.username}</th>
            <th>${listElement.courseName}</th>
            <th>${listElement.themaName}</th>
            <th>${listElement.result}</th>
            <th>${listElement.date}</th>
            </tr>
            </c:forEach>
            </table>
            <input type="hidden" name="course" value="${course}"/>
        </form>
    </div>
  </body>
</html>
