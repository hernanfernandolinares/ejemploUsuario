package com.ejemploUsuarios.usuarios.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Usuario {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   Integer id;
   @NotBlank
   String nombre;
   @NotBlank
   String apellido;
   public Usuario(){

   }

   public Usuario(Integer id, String nombre, String apellido) {
      this.id = id;
      this.nombre = nombre;
      this.apellido = apellido;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getApellido() {
      return apellido;
   }

   public void setApellido(String apellido) {
      this.apellido = apellido;
   }

   @Override
   public String toString() {
      return "Usuario{" +
              "id=" + id +
              ", nombre='" + nombre + '\'' +
              ", apellido='" + apellido + '\'' +
              '}';
   }
}

