package com.mycompany.petssystem.repository;

import com.mycompany.petssystem.conection.ConectionDB;
import com.mycompany.petssystem.entities.TypePet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TypePetRepository {
    
    public boolean registerTypePet (TypePet typePet){
        
        final String SQL_QUERY = "INSERT into types_pet"+"(type_description) VALUES(?)";
        
        try (Connection con = ConectionDB.getConection()){
            
            PreparedStatement preStatement = con.prepareStatement(SQL_QUERY);
            preStatement.setString(1,typePet.getDescription());
            
            return preStatement.executeUpdate()>0;
            
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar un tipo de nascota"+e.getMessage());
        }
        
    }
    
    public List<TypePet> getAllTypePets (){
        final String SQL = "SELECT * FROM types_pet";
        
        List<TypePet> typePetList = new ArrayList<>();
                
        try(Connection con = ConectionDB.getConection();
                PreparedStatement preStatement = con.prepareStatement(SQL)){
                

            try (ResultSet result = preStatement.executeQuery()){
                while(result.next()){
                    TypePet typePet = new TypePet (
                            result.getInt("type_id"),
                            result.getString("type_description"),
                            result.getByte("type_pet_status")

                    );
                    typePetList.add(typePet);  
                    
                }
                
            } 
            
        }catch (SQLException e){
            throw new RuntimeException("Error al consultar tipo de mascotas "+e.getMessage());
        }
        
        return typePetList;
    }
    
    public boolean updateTypePet (TypePet typePet){
        final String SQL = "UPDATE types_pet SET type_description = ? WHERE type_id = ?";
        
        try(Connection con = ConectionDB.getConection();
            PreparedStatement preStatement = con.prepareStatement(SQL)){
                
            preStatement.setString(1,typePet.getDescription());
            preStatement.setInt(2, typePet.getTypeId());
            
            return preStatement.executeUpdate() >0;
  
        }catch(SQLException e){
            throw new RuntimeException("Error al actualizar tipo de mascota "+e.getMessage());
        }
    }
        
    public boolean deleteTypePet(TypePet typePet){
        final String SQL = "UPDATE types_pet SET type_pet_status = ? WHERE type_id = ?";
        
        try (Connection con = ConectionDB.getConection();
                PreparedStatement preStatement = con.prepareStatement(SQL)){
            
                preStatement.setByte(1,typePet.getTypeStatus());
                preStatement.setInt(2, typePet.getTypeId());
                
                return preStatement.executeUpdate()>0;
            
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar tipo de mascota "+e.getMessage());
        }
    }   
        
}
    
 
