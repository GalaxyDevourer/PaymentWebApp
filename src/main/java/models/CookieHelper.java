package models;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

public class CookieHelper {
    public static Optional<String> readCookie(String key, HttpServletRequest req) {
        return Arrays.stream(req.getCookies())
                .filter(c -> key.equals(c.getName()))
                .map(Cookie::getValue)
                .findAny();
    }
}
