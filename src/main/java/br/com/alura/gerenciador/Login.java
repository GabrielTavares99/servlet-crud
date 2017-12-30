package br.com.alura.gerenciador;

import br.com.alura.gerenciador.dao.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet{


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter(Strings.EMAIL);
        String senha = req.getParameter(Strings.SENHA);
        Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
        if (usuario == null){
            PrintWriter writer = resp.getWriter();
            writer.println(Strings.ABRE_HTML_BODY);
            writer.println("<h2>Usuário não encontrado</h2>");
            writer.println(Strings.FECHA_HTML_BODY);
        }else {
            PrintWriter writer = resp.getWriter();
            writer.println(Strings.ABRE_HTML_BODY);
            writer.println("<h2>Você está logado como:"+usuario.getEmail()+"</h2>");
            writer.println(Strings.FECHA_HTML_BODY);
            Cookie cookie = new Cookie(Strings.COOKIE, usuario.getEmail());
            resp.addCookie(cookie);
        }

    }
}
