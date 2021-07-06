package com.example.final_project;
import Main_Model.MainModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalProjectApplication {

    public static void main(String[] args) {
        MainModel.StartSession();
        SpringApplication.run(FinalProjectApplication.class, args);
    }

}
