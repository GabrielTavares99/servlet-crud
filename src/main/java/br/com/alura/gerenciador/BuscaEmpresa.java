package br.com.alura.gerenciador;

import br.com.alura.gerenciador.dao.EmpresaDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String filtro = req.getParameter("filtro");
        EmpresaDAO empresaDAO = new EmpresaDAO();
        Collection<Empresa> empresas = empresaDAO.buscaPorSimilaridade(filtro);

        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html><body>");
        printWriter.println("<h1>Empresas</h1>");
        printWriter.println("<ul>");
        for (Empresa empresa: empresas) {
            printWriter.println("<li>"+empresa.getId()+" "+empresa.getNome()+"</li>");
        }
        printWriter.println("</ul>");
        printWriter.println("</body><html>");

    }
}
