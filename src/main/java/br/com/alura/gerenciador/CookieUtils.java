package br.com.alura.gerenciador;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtils {

    public Cookie getCookieUsuarioLogado(HttpServletRequest httpServletRequest){

        Cookie[] cookies = httpServletRequest.getCookies();

        if (cookies == null) return null;

        for (Cookie cookie: cookies) {
            if (cookie.getName().equals(Strings.COOKIE)){
                return cookie;
            }
        }

        return null;

    }

}
