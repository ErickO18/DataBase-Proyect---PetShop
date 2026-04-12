package com.mycompany.petssystem.repository;

import com.mycompany.petssystem.conection.ConectionDB;
import com.mycompany.petssystem.entities.Pet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PetRepository {
    
    public boolean registerPet(Pet pet) throws SQLException{
        final String SQL_QUERY = "Insert INTO pets"
                + "(pet_name,pet_age,pet_status,type_id) VALUES(?,?,?,?)";
        
        try(Connection con = ConectionDB.getConection();
            PreparedStatement preStatement = con.prepareStatement(SQL_QUERY)){
            preStatement.setString(1, pet.getName());
            preStatement.setShort(2, pet.getAge());
            preStatement.setByte(3, pet.getStatus());
            preStatement.setInt(4, pet.getTypeId());
            
            return preStatement.executeUpdate()> 0;
        }catch(SQLException e){
            throw new RuntimeException("Error al insertar una mascota",e);
        }
        
        
    }
    
    public List<Pet> getAllPets(){
        final String SQL = "SELECT * FROM pets WHERE pet_status =1;";
        
        List<Pet> petList = new ArrayList<>();
        
        try(Connection con = ConectionDB.getConection();
            PreparedStatement preStatement = con.prepareStatement(SQL)){
             
            try (ResultSet result = preStatement.executeQuery()){
                while (result.next()){
                    Pet pet = new Pet(
                            result.getInt("pet_id"),
                            result.getString("pet_name"),
                            result.getShort("pet_age"),
                            result.getByte("pet_status"),
                            result.getInt("type_id")
                    );
                    petList.add(pet);
                }
            }
        }catch(SQLException e){
            throw new RuntimeException("Error al consultar una mascota"+e.getMessage());
        }
        return petList; 
    }
    
    public Pet getPet(Pet pet) {
    final String SQL = "SELECT * FROM pets WHERE pet_id = ? AND pet_status = 1";

    try (Connection con = ConectionDB.getConection();
         PreparedStatement preStatement = con.prepareStatement(SQL)) {

        preStatement.setInt(1, pet.getId());

        try (ResultSet result = preStatement.executeQuery()) {
            if (result.next()) {
                return new Pet(
                        result.getInt("pet_id"),
                        result.getString("pet_name"),
                        result.getShort("pet_age"),
                        result.getByte("pet_status"),
                        result.getInt("type_id")
                );
            }
        }

    } catch (SQLException e) {
        throw new RuntimeException("Error al consultar una mascota " + e.getMessage());
    }

    return null;
    }
    
    
    
    public boolean updatePet(Pet pet) {
        final String SQL = "UPDATE pets SET pet_name = ?, pet_age = ?, type_id = ? WHERE pet_id = ? AND pet_status = 1";

        try (Connection con = ConectionDB.getConection();
            PreparedStatement preStatement = con.prepareStatement(SQL)) {

                preStatement.setString(1, pet.getName());
                preStatement.setShort(2, pet.getAge());
                preStatement.setInt(3, pet.getTypeId());
                preStatement.setInt(4, pet.getId());

            return preStatement.executeUpdate() > 0;

        } catch (SQLException e) {
        throw new RuntimeException("Error al actualizar la mascota"+ e.getMessage());
        }
    
    }
    
    public boolean deletePet(Pet pet){
        final String SQL = "UPDATE pets SET pet_status = ? WHERE pet_id = ?";
        
        try (Connection con = ConectionDB.getConection();
            PreparedStatement preStatement = con.prepareStatement(SQL)) {

                preStatement.setByte(1, pet.getStatus());
                preStatement.setInt(2, pet.getId());

            return preStatement.executeUpdate() >0;
        }catch (SQLException e) {
            throw new RuntimeException("Error al eliminar la mascota"+ e.getMessage());

        }
    

    }
    
    
    
}
