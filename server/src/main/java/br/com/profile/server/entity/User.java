package br.com.profile.server.entity;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "user")
public class User implements UserDetails, Serializable {


   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @NotEmpty
   @Column(unique = true)
   private String login;
   @NotEmpty
   private String password;
   @NotEmpty
   private String fullname;

   @OneToMany(fetch=FetchType.EAGER)
   @JoinColumn(name="user_id")
   List<Role> listRoles;

   public List<Role> getListRoles() {
      return listRoles;
   }

   public void setListRoles(List<Role> listRoles) {
      this.listRoles = listRoles;
   }

   public User(){
   }
   public User(String login,String password, String fullname){
      this.login=login;
      this.password=password;
      this.fullname=fullname;

   }

   @Override public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      User user = (User) o;
      return Objects.equals(id, user.id) &&
              Objects.equals(login, user.login) &&
              Objects.equals(password, user.password) &&
              Objects.equals(fullname, user.fullname);
   }

   @Override public int hashCode() {
      return Objects.hash(id, login, password, fullname);
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getLogin() {
      return login;
   }

   public void setLogin(String login) {
      this.login = login;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getFullname() {
      return fullname;
   }

   public void setFullname(String fullname) {
      this.fullname = fullname;
   }

   @Override public Collection<? extends GrantedAuthority> getAuthorities() {
       return (Collection<? extends GrantedAuthority>) listRoles;
   }

   public String getPassword() {
      return password;
   }

   @Override public String getUsername() {
      return login;
   }

   @Override public boolean isAccountNonExpired() {
      return true;
   }

   @Override public boolean isAccountNonLocked() {
      return true;
   }

   @Override public boolean isCredentialsNonExpired() {
      return true;
   }

   @Override public boolean isEnabled() {
      return true;
   }


}
