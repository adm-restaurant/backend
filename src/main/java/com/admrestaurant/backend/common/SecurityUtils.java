package com.admrestaurant.backend.common;

import com.admrestaurant.backend.entities.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static User getCurrentUser() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User) {
            return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        }
        throw new RuntimeException("User not found");
    }

    public static String getCurrentUsername() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User) {
            return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        } 
        throw new RuntimeException("User not found");
    }

    public static Long getCurrentUserId() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User) {
            return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        }
        throw new RuntimeException("User not found");
    }
}
