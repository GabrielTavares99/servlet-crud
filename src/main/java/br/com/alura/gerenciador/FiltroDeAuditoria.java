package br.com.alura.gerenciador;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    private String getUsuario(HttpServletRequest httpServletRequest){
        Cookie[] cookies = httpServletRequest.getCookies();
        String cookie_usuario = "[DESLOGADO]";
        if (cookies!=null){
            for (Cookie cookie: cookies) {
                if (cookie.getName().equals(Strings.COOKIE))
                    return cookie_usuario = cookie.getValue();
            }
        }
        return cookie_usuario;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String uri = httpServletRequest.getRequestURI();

        HttpSession session = httpServletRequest.getSession();
        Usuario usuario = (Usuario) session.getAttribute(Strings.COOKIE);

        if (usuario!=null){
            System.out.println("Usuário "+usuario.getEmail()+" acessando URI: "+uri);
        }else {
            System.out.println("Usuário <DESLOGADO> acessando URI: "+uri);
        }
//        String cookie_usuario = getUsuario(httpServletRequest);

//        Cookie[] cookies = httpServletRequest.getCookies();

//        System.out.println("Usuário "+cookie_usuario+" acessando URI: "+uri);
//        Cookie cookie = new CookieUtils(cookies).getCookieUsuarioLogado();
//        if (cookie!=null){
//            cookie.setMaxAge(60 * 10);
//            httpServletResponse.addCookie(cookie);
//        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
