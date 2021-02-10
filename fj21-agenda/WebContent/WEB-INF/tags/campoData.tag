<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ attribute name="id" required="true" %>
<%@ attribute name="value" required="false" %>

<input id="${id}" type="text" name="${id}" autocomplete="off" value="<fmt:formatDate value='${contato.dataNascimento.time}' pattern='dd/MM/yyyy' />"/>
<script>$('#${id}').datepicker({dateFormat: 'dd/mm/yy'})</script>