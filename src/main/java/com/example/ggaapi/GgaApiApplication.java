package com.example.ggaapi;

import com.example.ggaapi.model.Colaboradores;
import com.example.ggaapi.repository.IColaboradoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class GgaApiApplication implements CommandLineRunner {

    //@Autowired
    //private IColaboradoresRepository repoColaboradores;

    public static void main(String[] args) {
        SpringApplication.run(GgaApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*List<Colaboradores> listColaboradores = repoColaboradores.findAll();

        for(Colaboradores col : listColaboradores){
            System.out.println(col.getIdColaborador());
            System.out.println(col.getNombres());
            System.out.println(col.getCargo().getCargoColaborador());
            System.out.println(col.getEstado().getEstadoColaborador());
        }*/
    }
}
