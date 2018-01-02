package br.com.alura.gerenciador;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(urlPatterns = "/logout")
public class Logout implements Tarefa{

//    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
//
//        Cookie[] cookies = httpServletRequest.getCookies();
//
////        Cookie cookie = new CookieUtils(cookies).getCookieUsuarioLogado();
//        HttpSession session = httpServletRequest.getSession();
//        session.removeAttribute(Strings.COOKIE);
////        session.setMaxInactiveInterval(0);
//        session.invalidate();
//
//        PrintWriter writer = httpServletResponse.getWriter();
//
////        if (cookie == null){
////            writer.println(Strings.ABRE_HTML_BODY);
////            writer.println("VOCÊ nem tá logado");
////            writer.println(Strings.FECHA_HTML_BODY);
////        }else {
////            cookie.setMaxAge(0);
////            httpServletResponse.addCookie(cookie);
////            writer.println(Strings.ABRE_HTML_BODY);
////            writer.println("Usuário "+cookie.getValue()+" deslogado com sucesso!");
////            writer.println(Strings.FECHA_HTML_BODY);
////        }
//
////        writer.println(Strings.ABRE_HTML_BODY);
////        writer.println("Usuário deslogado com sucesso!");
////        writer.println(Strings.FECHA_HTML_BODY);
//
////        httpServletResponse.sendRedirect("/logout.html");
////        httpServletResponse.sendRedirect("logout.html");
//        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher(Strings.PAGINAS_HTML+"logout.html");
//        requestDispatcher.forward(httpServletRequest, httpServletResponse);
//    }

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        session.removeAttribute(Strings.COOKIE);
        session.invalidate();

        return (Strings.PAGINAS_HTML+"logout.html");
    }
}
