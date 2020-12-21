package com.tlshzp.utils;

import com.tlshzp.pojo.Acount;
import com.tlshzp.pojo.User;
import com.tlshzp.service.UserService;
import com.tlshzp.service.impl.UserServiceImpl;

import javax.servlet.http.*;

public class CookieUtils {
    //0未登录、1学生、2教师
    public static int checkIdentify(Cookie[] cookies, HttpSession session, HttpServletResponse resp) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("uuid")) {
                    String uuid = cookie.getValue();
                    Acount acount = (Acount) session.getAttribute(uuid);
                    if (acount == null) return 0;
                    setCookie_3(cookie, resp);
                    if (!acount.isIdentify()) return 1;
                    else return 2;
                }
            }
        }
        return 0;
    }

    public static Acount getAcount(Cookie[] cookies, HttpSession session, HttpServletResponse resp) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("uuid")) {
                    String uuid = cookie.getValue();
                    setCookie_3(cookie, resp);
                    Acount acount = (Acount) session.getAttribute(uuid);
                    return acount;
                }
            }
        }
        return null;
    }

    public static User getUser(Cookie[] cookies, HttpSession session, HttpServletResponse resp) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("uuid")) {
                    String uuid = cookie.getValue();
                    Acount acount = (Acount) session.getAttribute(uuid);
                    if (acount == null) {
                        setCookie_0(cookie, resp);
                        return null;
                    }
                    setCookie_3(cookie, resp);
                    User user = new UserServiceImpl().findUserByNumber(acount.getNumber());
                    return user;
                }
            }
        }
        return null;
    }

    public static void logout(HttpServletRequest req, HttpServletResponse resp){
        Cookie[] cookies = req.getCookies();
        HttpSession session = req.getSession();
        if (cookies != null)
            for (Cookie cookie : cookies)
                if (cookie.getName().equals("uuid")){
                    String uuid = cookie.getValue();
                    setCookie_0(cookie, resp);
                    session.invalidate();
                }
        return;
    }

    public static void setCookie_3(Cookie cookie, HttpServletResponse resp) {
        cookie.setMaxAge(60 * 60 * 24 * 3);
        cookie.setPath("/library");
        resp.addCookie(cookie);
        return;
    }

    public static void setCookie_0(Cookie cookie, HttpServletResponse resp) {
        cookie.setMaxAge(0);
        cookie.setPath("/library");
        resp.addCookie(cookie);
        return;
    }
}
