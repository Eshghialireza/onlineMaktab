package com.onlineMaktab.util;

import com.onlineMaktab.domain.User;

public class CurrentUser {
    private User currentUser=null;

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void logout() {
        this.currentUser = null;
    }
}
