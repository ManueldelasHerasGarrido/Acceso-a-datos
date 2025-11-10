package com.manuelhg.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Scanner;

@SpringBootApplication
@Slf4j
public class AddApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AddApplication.class, args);
    }

    public static void mostrarContenidoDirectorio(String ruta) {
        File directorio = new File(ruta); // convertimos la String en un File

        if (!directorio.exists()) {
            System.out.println("La ruta no existe.");
            return;
        }

        if (!directorio.isDirectory()) {
            System.out.println("La ruta no es un directorio.");
            return;
        }
        File[] archivos = directorio.listFiles(); // devuelve todos los ficheros dentro

        if (archivos != null) {
            for (File archivo : archivos) {
                // Aquí procesaremos cada archivo
            }
        }
    }


    @Override
    public void run(String... args) throws Exception {
        log.info("hola");
        System.out.println("Bievenido al explorador de ficheros. Introduzca la ruta del directorio que desea explorar:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la ruta del directorio: ");
        String ruta = scanner.nextLine();
        scanner.close();
        mostrarContenidoDirectorio(ruta);
    }
}
