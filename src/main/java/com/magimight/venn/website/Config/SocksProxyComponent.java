package com.magimight.venn.website.Config;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.net.Authenticator;


@Component
@Log
public class SocksProxyComponent {

    @Value("${SOCKS_PROXY_HOST}")
    private String pHost;

    @Value("${SOCKS_PROXY_PORT}")
    private int pPort;

    @Value("${SOCKS_PROXY_USER}")
    private String pUser;

    @Value("${SOCKS_PROXY_PASSWORD}")
    private String pPassword;

    @Bean
    @Order(1)
    public CommandLineRunner setupSocksProxy(){
        return  args -> {
            System.setProperty("http.proxyHost", pHost);
            System.setProperty("http.proxyPort", Integer.toString(pPort));

            Authenticator.setDefault(new SocksProxyAuthenitcator(pUser, pPassword));
        };

    }
}
