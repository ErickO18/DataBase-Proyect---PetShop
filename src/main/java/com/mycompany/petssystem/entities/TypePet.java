package com.mycompany.petssystem.entities;


public class TypePet {
    
    //atributos
    private int typeId;
    private String description;
    private byte typeStatus;

    public TypePet() {
    }

    public TypePet(int typeId, String description,byte typeStatus) {
        this.typeId = typeId;
        this.description = description;
        this.typeStatus = typeStatus;
    }

    public TypePet(String description,byte typeStatus) {
        this.description = description;
        this.typeStatus = typeStatus;
    }
    
    

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte getTypeStatus() {
        return typeStatus;
    }

    public void setTypeStatus(byte typeStatus) {
        this.typeStatus = typeStatus;
    }
    

    @Override
    public String toString() {
        return "TypePet{" + "typeId=" + typeId + ", description=" + description + ", type_status= "+typeStatus + '}';
    }
    
    
}
