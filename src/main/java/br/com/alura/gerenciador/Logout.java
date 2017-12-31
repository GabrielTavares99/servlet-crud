package br.com.alura.gerenciador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();

//        Cookie cookie = new CookieUtils(cookies).getCookieUsuarioLogado();
        HttpSession session = req.getSession();
        session.removeAttribute(Strings.COOKIE);
//        session.setMaxInactiveInterval(0);
        session.invalidate();

        PrintWriter writer = resp.getWriter();

//        if (cookie == null){
//            writer.println(Strings.ABRE_HTML_BODY);
//            writer.println("VOCÊ nem tá logado");
//            writer.println(Strings.FECHA_HTML_BODY);
//        }else {
//            cookie.setMaxAge(0);
//            resp.addCookie(cookie);
//            writer.println(Strings.ABRE_HTML_BODY);
//            writer.println("Usuário "+cookie.getValue()+" deslogado com sucesso!");
//            writer.println(Strings.FECHA_HTML_BODY);
//        }

        writer.println(Strings.ABRE_HTML_BODY);
        writer.println("Usuário deslogado com sucesso!");
        writer.println(Strings.FECHA_HTML_BODY);
    }
}
