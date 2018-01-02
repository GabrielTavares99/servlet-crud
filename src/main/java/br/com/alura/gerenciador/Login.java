package br.com.alura.gerenciador;

import br.com.alura.gerenciador.dao.UsuarioDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/login")
public class Login implements Tarefa{

//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String email = req.getParameter(Strings.EMAIL);
//        String senha = req.getParameter(Strings.SENHA);
//
//        Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
//
//        if (usuario == null){
//            PrintWriter writer = resp.getWriter();
//            writer.println(Strings.ABRE_HTML_BODY);
//            writer.println("<h2>Usuário não encontrado</h2>");
//            writer.println(Strings.FECHA_HTML_BODY);
//        }else {
//            PrintWriter writer = resp.getWriter();
//            writer.println(Strings.ABRE_HTML_BODY);
//            writer.println("<h2>Você está logado como:"+usuario.getEmail()+"</h2>");
//            writer.println(Strings.FECHA_HTML_BODY);
////            Cookie cookie = new Cookie(Strings.COOKIE, usuario.getEmail());
//            HttpSession session = req.getSession();
//            session.setAttribute(Strings.COOKIE, usuario);
////            resp.addCookie(cookie);
//        }
//
//    }

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter(Strings.EMAIL);
        String senha = request.getParameter(Strings.SENHA);

        Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
        request.setAttribute(Strings.COOKIE, usuario);

        return ("index.jsp");
    }
}
