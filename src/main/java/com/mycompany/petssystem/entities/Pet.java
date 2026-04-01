package com.mycompany.petssystem.entities;


public class Pet {
    
    //Attributos
     private int id;
     private String name;
     private short age;
     private byte status;
     private int typeId;
     
     //Constructores sobrecarga

    public Pet() {
    }

    public Pet(int id, String name, short age, byte status, int typeId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.status = status;
        this.typeId = typeId;
    }

    public Pet(String name, short age, byte status, int typeId) {
        this.name = name;
        this.age = age;
        this.status = status;
        this.typeId = typeId;
    }
     
    //metodos acceso

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setType_id(int typeId) {
        this.typeId = typeId;
    }
    
    //to string

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pet{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", age=").append(age);
        sb.append(", status=").append(status);
        sb.append(", type_id=").append(typeId);
        sb.append('}');
        return sb.toString();
    }
    
}
