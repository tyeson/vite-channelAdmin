package com.channel.admin.common.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {

  public static Authentication getAuthentication() {
    return SecurityContextHolder.getContext().getAuthentication();
  }

  public static Long getCurrentUserId() {
    Authentication authentication = getAuthentication();
    if (authentication != null && authentication.getPrincipal() instanceof Long) {
      return (Long) authentication.getPrincipal();
    }
    return null;
  }

  public static String getCurrentUsername() {
    Authentication authentication = getAuthentication();
    if (authentication != null) {
      return authentication.getName();
    }
    return null;
  }
}
