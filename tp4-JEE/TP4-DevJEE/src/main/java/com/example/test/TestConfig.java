package com.example.test;

import org.hibernate.cfg.Configuration;
import java.net.URL;

public class TestConfig {
    public static void main(String[] args) {
        // Vérifier où le fichier est chargé
        URL url = TestConfig.class.getResource("/hibernate.cfg.xml");
        System.out.println("Fichier config trouvé à : " + url);

        // Charger la configuration
        Configuration config = new Configuration().configure();
        String urlJDBC = config.getProperty("hibernate.connection.url");
        System.out.println("URL JDBC configurée : " + urlJDBC);
    }
}