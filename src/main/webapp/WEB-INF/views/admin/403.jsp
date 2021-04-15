<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="../header-register.jsp"%>

</header>

<section>
    <h2>Dostęp zabroniony!</h2>
    <div class="help--slides active" data-id="1">
        <p>Status Code: 403</p>
        <p>Sorry, your access is refused due to security reasons of our server and also our sensitive data.<br/>
            Please go back to the previous page to continue browsing.</p>

        <div style="margin-left: calc(50% - 60px);">
            <a class="btn btn-danger" href="javascript:history.back()">Go Back</a>
        </div>
    </div>
</section>

<%@include file="../footer.jsp"%>
<script src="<c:url value="resources/js/form.js"/>"></script>