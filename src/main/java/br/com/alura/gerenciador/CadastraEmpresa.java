package br.com.alura.gerenciador;

import br.com.alura.gerenciador.dao.EmpresaDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/cadastraEmpresa")
public class CadastraEmpresa extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomeEmpresa = req.getParameter("nome");
        Empresa empresa = new Empresa(nomeEmpresa);
        new EmpresaDAO().adiciona(empresa);
        PrintWriter writer = resp.getWriter();
//        writer.println("<html><body>Empresa cadastrada com sucesso: "+empresa.getNome()+"</body></html>");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(Strings.PAGINAS_HTML + "novaEmpresa.jsp");
        req.setAttribute("empresa", empresa);
        requestDispatcher.forward(req, resp);

    }
}
