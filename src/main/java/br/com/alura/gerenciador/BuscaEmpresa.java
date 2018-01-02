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
import java.util.Collection;

@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet {

    public BuscaEmpresa(){
        System.out.println("Contruindo Servlet BuscaEmpresa "+this);
    }


    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Inicializando Servlet BuscaEmpresa "+this);
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Destruindo Servlet BuscaEmpresa "+this);
    }

//    String filtro;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String filtro = req.getParameter("filtro");
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        EmpresaDAO empresaDAO = new EmpresaDAO();
        Collection<Empresa> empresas = empresaDAO.buscaPorSimilaridade(filtro);

        req.setAttribute("empresas", empresas);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(Strings.PAGINAS_HTML + "buscaEmpresa.jsp");
        requestDispatcher.forward(req, resp);


//        PrintWriter printWriter = resp.getWriter();
//        printWriter.println("<html><body>");
//        printWriter.println("<h1>Empresas</h1>");
//        printWriter.println("<ul>");
//        for (Empresa empresa: empresas) {
//            printWriter.println("<li>"+empresa.getId()+" "+empresa.getNome()+"</li>");
//        }
//        printWriter.println("</ul>");
//        printWriter.println("</body><html>");

    }
}
