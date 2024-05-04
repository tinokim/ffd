package com.ffd.userservice.common.security.role;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private String authorize;

    Role(String authorize) {
        this.authorize = authorize;
    }

}
