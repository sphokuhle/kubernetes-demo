package com.example.kubernetesproject.config;

import com.example.kubernetesproject.service.KeycloakKeyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;

@Component
@Slf4j
public class KeyGeneratorConfig {

    private static final Logger logger = LoggerFactory.getLogger(KeyGeneratorConfig.class.getCanonicalName());
//    @Value("${app.security.jwtPublicKey}")
//    private String certificateKey;
    @Autowired
    private KeycloakKeyService keycloakKeyService;

    public RSAPublicKey getParsedPublicKey() {
        try {
            byte[] encodedCert = keycloakKeyService.getPublicKeys().get("publicKey").getBytes("UTF-8");
            byte[] decodedCert = Base64.decodeBase64(encodedCert);
            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
            InputStream in = new ByteArrayInputStream(decodedCert);
            X509Certificate certificate = (X509Certificate)certFactory.generateCertificate(in);
            RSAPublicKey pubKey = (RSAPublicKey) certificate.getPublicKey();
            log.info("Public key: {}", pubKey);
            return pubKey;

        } catch (IOException | CertificateException e) {
            e.printStackTrace();
            return null;
        }
    }
}
