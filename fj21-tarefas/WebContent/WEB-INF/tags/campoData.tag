<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ attribute name="id" required="true" %>
<%@ attribute name="value" required="false" type="java.util.Date" %>

<input id="${id}" type="text" name="${id}" autocomplete="off" value="<fmt:formatDate value="${value}" pattern="dd/MM/yyyy" />"/>
<script>$('#${id}').datepicker({dateFormat: 'dd/mm/yy'})</script>