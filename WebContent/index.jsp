<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Gerenciador de empresas</title>
    <style>
        <%@ include file="WEB-INF/paginas/estilo.css"%>
    </style>
</head>
<body>
    <c:choose>
        <c:when test="${usuarioLogado==null}">
            <div class="titulo">Bem vindo ao nosso gerenciador de empresas!</div>
        </c:when>
        <c:when test="${usuarioLogado!=null}">
            <div class="titulo">${usuarioLogado.email} bem vindo ao nosso gerenciador de empresas!</div>
        </c:when>
    </c:choose>
<%--<c:if test="${usuarioLogado!=null}">--%>
<%--</c:if>--%>

    <form action="controller?tarefa=CadastraEmpresa" method="post">
        Nome: <input type="text" name="nome">
        <input type="submit" value="Enviar">
    </form>
    </br>
    <form action="controller?tarefa=Login" method="post">
        Email: <input type="text" name="email">
        Senha: <input type="password" name="senha">
        <input type="submit" value="Entrar">
    </form>
    </br>
    <form action="controller?tarefa=Logout" method="post">
        <input type="submit" value="Deslogar">
    </form>
    <br>
    <form action="controller?tarefa=BuscaEmpresa" method="post">
        <input type="submit" value="BUSCA todas">
    </form>
</body>
</html>