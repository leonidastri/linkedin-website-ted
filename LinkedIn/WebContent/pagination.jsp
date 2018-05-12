<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${empty previousPage}">
    <span>previous page</span> |
</c:if>
<c:if test="${not empty previousPage}">
    <a href="${previousPage}">previous page</a> |
</c:if>
<c:if test="${empty nextPage}">
    <span>next page</span>
</c:if>
<c:if test="${not empty nextPage}">
    <a href="${nextPage}">next page</a>
</c:if>