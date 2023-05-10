package com.example.networking;

public class Mountain {
    private String name;
    private String location;
    private int size;

    public Mountain(String name, String location, int size) {
        this.name = name;
        this.location = location;
        this.size = size;
    }

    //public String getName() {
      //  return name;
    //}

  //  public void setName(String name) {
      //  this.name = name;
    //}

   // public int getSize() {
     //   return size;
    //}

   // public void setSize(int size) {
   //     this.size = size;
    //}

    @Override
    public String toString() {
        String presentMountains = "Name: " + name + " " + " Size: " + size + " " + " Location: " + location;
        return presentMountains;
    }
}
