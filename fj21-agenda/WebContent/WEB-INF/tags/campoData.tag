<%@ attribute name="id" required="true" %>

<input id="${id}" type="text" name="${id}" autocomplete="off" />
<script>$('#${id}').datepicker({dateFormat: 'dd/mm/yy'})</script>