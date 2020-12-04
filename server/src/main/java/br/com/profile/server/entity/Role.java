package br.com.profile.server.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority, Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   private String role;

   @Override public String getAuthority() {
      return role;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getRole() {
      return role;
   }

   public void setRole(String role) {
      this.role = role;
   }
}
