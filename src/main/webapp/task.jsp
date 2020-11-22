<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Задачи</title>
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
         <td><form ACTION="${contextPath}/course" METHOD="GET" class="form-common">
             <INPUT TYPE="SUBMIT" VALUE="Выбрать курс" class="btn-redirect">
         </form></td>
         <td><form ACTION="${contextPath}/${course}/thema" METHOD="GET" class="form-common">
             <INPUT TYPE="SUBMIT" VALUE="Выбрать тему" class="btn-redirect">
         </form></td>
         </tr>
         </table>
    </div>

    <div class="container">
        <form id="taskSelectForm" method="POST" action="${contextPath}/redirectToCurrentTask" class="form-common">
        Ваша тема: ${themaName}
            <table>
                <tr>
                    <td>
                        <form:select path="taskList" name="taskId">
                        <form:option value="NONE" label="Выберите задачу:"/>
                        <c:forEach var="listElement" items="${taskList}">
                        <form:option label="${listElement.taskName}" value="${listElement.id}"/>
                        </c:forEach>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><input type="submit" class="btn"/></td>
                </tr>
            </table>
            <input type="hidden" name="course" value="${course}"/>
            <input type="hidden" name="thema" value="${thema}"/>
            <a href="${contextPath}/${course}/${thema}/allTasks">Показать все задачи по теме</a>
            <br>
            <c:if test="${showCreate == true}">
                <a href="${contextPath}/${course}/${thema}/add_task">Создать новую задачу</a>
            </c:if>
            <br>
        </form>
  </div>
</body>
</html>
