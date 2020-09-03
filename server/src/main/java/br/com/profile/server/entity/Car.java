package br.com.profile.server.entity;

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

   @Override public String toString() {
      return "Car{" +
              "name='" + name + '\'' +
              '}';
   }
}
