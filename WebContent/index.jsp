<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Gerenciador de empresas</title>
</head>
<body>
    <c:choose>
        <c:when test="${usuarioLogado==null}">
            Bem vindo ao nosso gerenciador de empresas!<br/>
        </c:when>
        <c:when test="${usuarioLogado!=null}">
            ${usuarioLogado.email} bem vindo ao nosso gerenciador de empresas!<br/>
        </c:when>
    </c:choose>
<%--<c:if test="${usuarioLogado!=null}">--%>
<%--</c:if>--%>

    <form action="fazTudo?tarefa=CadastraEmpresa" method="post">
        Nome: <input type="text" name="nome">
        <input type="submit" value="Enviar">
    </form>
    </br>
    <form action="login" method="post">
        Email: <input type="text" name="email">
        Senha: <input type="password" name="senha">
        <input type="submit" value="Entrar">
    </form>
    </br>
    <form action="fazTudo?tarefa=Logout" method="post">
        <input type="submit" value="Deslogar">
    </form>
    <br>
    <form action="fazTudo?tarefa=BuscaEmpresa" method="post">
        <input type="submit" value="BUSCA todas">
    </form>
</body>
</html>