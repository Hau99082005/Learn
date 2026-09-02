package com.example.learnhub.modules.users.dtos;

public class userDTO {
   private final Long id;
   private final String email;

   public userDTO(Long id, String email) {
    this.id = id;
    this.email = email;
   }
   public Long getId() {
      return id;
   }
   public String getEmail() {
      return email;
   }
}