package com.mycompany.petssystem;

import com.mycompany.petssystem.conection.ConectionDB;
import com.mycompany.petssystem.entities.Pet;
import com.mycompany.petssystem.entities.TypePet;
import com.mycompany.petssystem.repository.PetRepository;
import com.mycompany.petssystem.repository.TypePetRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PetsSystem {

    public static void main(String[] args) throws SQLException {
        
        PetRepository repository = new PetRepository();

        TypePetRepository typePetRepository = new TypePetRepository();
        
        

    }
}
