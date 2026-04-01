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

 
/*
        //Probar conexion con DB
        try(Connection con = ConectionDB.getConection()){
            
            if (con != null && !con.isClosed()){
                System.out.println("Hay conexion a la DB");
            }
            
        }catch(SQLException e){
            System.out.println("Error en la conexion: "+e.getMessage());
        }
        
        //Registrar mascota DB
        
        short edad = 3;
        byte status = 1;
        
        Pet pet = new Pet("Juan",edad,status,1);
               
        boolean response = repository.registerPet(pet);

        if(response){
            System.out.println("Se registro");
        }else System.out.println("No se registro");

        
        //Consultar DB
        
       
        try {
            List<Pet> petList = repository.getAllPets();
            
            if(petList.isEmpty()){
                System.out.println("No hay mascotas registradas");
            }else{
                for(Pet p:petList){
                    System.out.println(p);
                }
            }
            
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
        }
        
        
        //Actualizar Mascota
        
        
        short newAge = 5;
       

        Pet petUpdate = new Pet(1, "Max",newAge ,(byte) 1, 2);

        
        try {
            boolean updateResponse = repository.updatePet(petUpdate);
            
            if (updateResponse) {
            System.out.println("Se actualizo la mascota");
            } else {
            System.out.println("No se actualizo la mascota");
            }
            
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
        }
        

        //Eliminar Mascota
        byte deletedStatus = 0;
        
        Pet petDeleted = new Pet(3,"",(short) 0,deletedStatus,0);
        
        
        
        try {
            boolean deleteResponse = repository.deletePet(petDeleted);
            
            if(deleteResponse){
            System.out.println("Se elimino la mascota, nuevo status =0");
            }else System.out.println("No se elimino la mascota :");

            
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
        }
              
 

        //TypePet
        
      
        //Registrar tipo de mascota
        
        TypePet typePet = new TypePet("Pez",(byte)1);
        
        
        try {
            boolean typePetResponse = typePetRepository.registerTypePet(typePet);
            
            if (typePetResponse) {
                System.out.println("Registro de tipo de mascota exitoso");
            }else System.out.println("No se pudo hacer el registro de tipo de mascota: ");
            
        } catch (Exception e) {
            
            System.out.println(""+e.getMessage());
        }
        
     
        
        //Ver tipos de mascotas
        
        
        try {
            List<TypePet> typePetList = typePetRepository.getAllTypePets();
            
            if (typePetList.isEmpty()) {
                System.out.println("La lista esta vacia");
            }else{
                for(TypePet tp:typePetList){
                    System.out.println(tp);
                }
            }
       
        } catch (Exception e) {
            System.out.println("Error en la consulta "+e.getMessage());
        }
          
        //Actualizar tipo de mascota
                
        
        TypePet typePetUpdate = new TypePet(2,"Gato",(byte)1);
        
        try {
            boolean typeUpdateResponse = typePetRepository.updateTypePet(typePetUpdate);
            
            if (typeUpdateResponse) {
                System.out.println("Actualizacion de typePet exitosa");
            }else System.out.println("No se pudo actualizar el typePet");
            
        } catch (Exception e) {
            System.out.println(" "+e.getMessage() );
        }
        
        */

       //Eliminar typePet
             
       byte newTypeStatus = 0;
       TypePet typePetDelete = new TypePet(1,"",newTypeStatus);
       
        try {
            
            boolean typeDeleteResponse = typePetRepository.deleteTypePet(typePetDelete);
            
            if(typeDeleteResponse){
                System.out.println("Eliminacion de typePet exitosa, new status = 0");
            }else System.out.println("No se pudo eliminar el typePet");
        } catch (Exception e) {
            System.out.println(" "+e.getMessage());
        }
  
        
        
        
        

    }
}
