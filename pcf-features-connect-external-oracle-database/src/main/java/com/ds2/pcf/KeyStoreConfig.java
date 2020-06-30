package com.ds2.pcf;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KeyStoreConfig {

    // This is configuration class will add the keystore and truststore
    // configuration in JVM properties to enable secure connection using TLS 1.2 (mutual authentications)

    public KeyStoreConfig() {

        System.setProperty("javax.net.ssl.keyStore", "keystore.jks"); // need to put keystore.jks file in resources folder
        System.setProperty("javax.net.ssl.keyStorePassword", "<empty>"); // specify keystore password
        System.setProperty("javax.net.ssl.trustStore","truststore.jks"); // need to put truststore.jks file in resources folder
        System.setProperty("javax.net.ssl.trustStorePassword","<empty>"); // specify truststore password
        System.setProperty("https.protocols","TLSv1.2");

        //System.setProperty("javax.net.ssl.keyStoreType","JKS");
        // System.setProperty("javax.net.debug","ssl:handshake");///ssl:handshake // for debug
        //System.setProperty("java.security.debug","certpath:x509:ocsp"); // for debug
        //System.setProperty("oracle.net.ssl_cipher_suites", "TLS_RSA_WITH_AES_256_GCM_SHA384(0x009D)"); //specify if required
    }
}
