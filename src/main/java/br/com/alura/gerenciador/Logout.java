package br.com.alura.gerenciador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new CookieUtils().getCookieUsuarioLogado(req);
        PrintWriter writer = resp.getWriter();

        if (cookie == null){
            writer.println(Strings.ABRE_HTML_BODY);
            writer.println("VOCÊ nem tá logado");
            writer.println(Strings.FECHA_HTML_BODY);
        }else {
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
            writer.println(Strings.ABRE_HTML_BODY);
            writer.println("Usuário "+cookie.getValue()+" deslogado com sucesso!");
            writer.println(Strings.FECHA_HTML_BODY);
        }
    }
}
