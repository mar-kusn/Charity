<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="../header-register.jsp"%>

</header>

<section class="login-page">
    <sec:authorize access="isAuthenticated()">
        <h2>Wyloguj się</h2>
        <form method="post" action="<c:url value="/logout"/>" >
            <div class="form-group form-group--buttons">
                <button class="btn btn--without-border" type="button" onclick="window.history.back()" >Powrót</button>
                <button class="btn" type="submit">Wyloguj się</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </div>
        </form>
    </sec:authorize>
</section>

<%@include file="../footer.jsp"%>
<script src="<c:url value="resources/js/form.js"/>"></script>