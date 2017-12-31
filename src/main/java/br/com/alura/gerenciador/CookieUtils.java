package br.com.alura.gerenciador;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtils {

    private Cookie[] cookies;

    public CookieUtils(Cookie[] cookies){
        this.cookies = cookies;
    }

    public Cookie getCookieUsuarioLogado(){

        Cookie[] cookies = this.cookies;

        if (cookies == null) return null;

        for (Cookie cookie: cookies) {
            if (cookie.getName().equals(Strings.COOKIE)){
                return cookie;
            }
        }

        return null;

    }

}
