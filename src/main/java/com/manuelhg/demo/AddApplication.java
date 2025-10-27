package com.manuelhg.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor

public class AddApplication implements CommandLineRunner {
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(AddApplication.class, args);
    }

    public void JdbcApplication(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) {
        System.out.println("Testing JDBC connection...");
        try (Connection conn = dataSource.getConnection()) {
            System.out.println("Connection successful: " + conn.getMetaData().getURL());
            System.out.println("Database: " + conn.getMetaData().getDatabaseProductName());
        } catch (Exception e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }
}
