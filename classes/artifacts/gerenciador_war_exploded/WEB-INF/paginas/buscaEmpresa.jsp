<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Busca Empresa</title>
</head>
<body>
Resultado da busca:
<%--${usuarioLogado.email}--%>
<ul>
    <c:forEach var="empresa" items="${empresas}">
        <li>${empresa.id}: ${empresa.nome}</li>
    </c:forEach>
</ul>

</body>
</html>
