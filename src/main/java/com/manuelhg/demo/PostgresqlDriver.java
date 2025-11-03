package com.manuelhg.demo;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;

@Component
@Slf4j
public class PostgresqlDriver {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    // Si no se define, por defecto usamos el driver de PostgreSQL
    /*@Value("${spring.datasource.driver-class
    name:org.postgresql.Driver}")*/
    private String driverClassName;
    //    @PostConstruct
//    public void init() {
//        try {
//            // Cargar driver explícitamente (seguro y compatible)
//            Class.forName(driverClassName);
//            System.out.println("JDBC driver loaded: " +driverClassName);
//
//
// Prueba rápida de conexión al arrancar (no estricto: solo informa)
//                try (Connection conn = getConnection()) {
//                if (conn != null && !conn.isClosed()) {
//                    log.info("✅ Database connection test successful");
//                }
//            } catch (SQLException ex) {
//
    //        log.error("⚠️ Could not test DB connection at startup:{}", ex.getMessage());
//            }
//        } catch (ClassNotFoundException e) {
//            log.error("❌ JDBC Driver class not found: {}", driverClassName);
//        } catch (Exception e) {
//        log.error("❌ Unexpected error initializing connector: {}",
//                  e.getMessage());
//        }
//    }
    @Value("classpath*:sql/*.sql")
    private Resource[] scripts;

    /**
     * Obtiene una nueva conexión JDBC usando DriverManager.
     * El llamador es responsable de cerrar la conexión (try-with
     * resources recomendado).
     *
     * @return nueva Connection abierta
     * @throws SQLException si falla la conexión
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    @PostConstruct
    public void init() {
        log.info("🛠️ Initializing database...");
        for (Resource script : scripts) {
            executeSql(script);
        }
        log.info("✅ Database initialized successfully!");
    }

    private void executeSql(Resource resource) {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             BufferedReader reader = new BufferedReader(new
                     InputStreamReader(resource.getInputStream()))) {
            String sql = reader.lines().collect(Collectors.joining("\n"));
            stmt.execute(sql);
            log.info("📄 Executed script: {}", resource.getFilename());
        } catch (Exception e) {
            log.error("⚠️ Error executing script {}: {}",
                    resource.getFilename(), e.getMessage());
        }
    }
}

