package br.com.alura.gerenciador;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/fazTudo")
public class FazTudo extends HttpServlet{

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) res;

        String tarefa = req.getParameter("tarefa");
        if (tarefa == null)
            throw new IllegalArgumentException();

        String nomeClasse = "br.com.alura.gerenciador."+tarefa;
        String pagina;

        try {
            Class type = Class.forName(nomeClasse);
            Tarefa instancia = (Tarefa) type.newInstance();
            pagina = instancia.executa(httpServletRequest, httpServletResponse);
        } catch (Exception e) {
            throw new ServletException();
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(pagina);
        requestDispatcher.forward(req, res);
    }
}
