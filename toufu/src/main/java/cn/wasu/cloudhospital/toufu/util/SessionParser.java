package cn.wasu.cloudhospital.toufu.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionParser {

  public void setSessionTime(HttpSession session, int time) {
    session.setMaxInactiveInterval(time);
  }

  public String getSession(HttpSession session, String key) {
    if (session == null) return "";
    Object value = session.getAttribute(key);
    return value == null ? "" : (String) value;
  }

  public void setSession(HttpServletRequest request, String key, String value) {
    HttpSession session = request.getSession();
    session.setAttribute(key, value);
  }

  public void remove(HttpServletRequest request, String args) {
    Object object = request.getSession().getAttribute(args);
    if (object != null) {
      try {
        request.getSession().removeAttribute(args);
      } catch (Exception e) {
        object = null;
      }
    }
  }

}
