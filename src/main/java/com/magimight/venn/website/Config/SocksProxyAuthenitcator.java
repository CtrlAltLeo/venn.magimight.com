package com.magimight.venn.website.Config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

@Getter
@Setter
@AllArgsConstructor
public class SocksProxyAuthenitcator extends Authenticator {
    private final String username;
    private final String password;

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password.toCharArray());
    }
}
