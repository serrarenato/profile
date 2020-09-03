package br.com.profile.Entity;

public class Car {

   private String name="CARRO Teste";

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Car(String car){
      this.name = car;
   }
}
