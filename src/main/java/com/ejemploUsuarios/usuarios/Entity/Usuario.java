package com.ejemploUsuarios.usuarios.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
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

}

