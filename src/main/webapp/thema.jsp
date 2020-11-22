<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Тема</title>
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
        <form id="themaSelectForm" method="POST" action="${contextPath}/redirectToTask" class="form-common">
        Ваш курс ${courseName}
            <table>
                <tr>
                    <td>
                        <form:select path="themaList" name="thema">
                        <form:option value="NONE" label="Выберите тему:"/>
                        <c:forEach var="listElement" items="${themaList}">
                        <form:option value="${listElement.thema}" label="${listElement.themaName}"/>
                        </c:forEach>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><input type="submit" class="btn"/></td>
                </tr>
            </table>
            <input type="hidden" name="course" value="${course}"/>
            <br>
            <c:if test="${showCreate == true}">
                 <a href="${contextPath}/${course}/add_thema">Создать новую тему</a>
                 <a href="${contextPath}/${course}/statistic">Посмотреть статистику по курсу</a>
            </c:if>
            <br>
        </form>
  </div>
  </body>
</html>
