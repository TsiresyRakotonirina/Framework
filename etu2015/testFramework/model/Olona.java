package etu2015.model;

import etu2015.framework.annotation.*;

public class Olona {

    int id;
    String anarana;
    
    public void setId(int id) throws IllegalArgumentException {
        if (id < 0) throw new IllegalArgumentException("id must be positive");
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setanarana(String anarana) throws IllegalArgumentException {
        if (anarana == null) throw new IllegalArgumentException("argument vide");
        this.anarana = anarana;
    }

    public String getanarana() {
        return anarana;
    }
    
    public Olona() {
    
    }
    
    public Olona(int id, String anarana) {
        setId(id);
        setanarana(anarana);
    }

    @url("mamerina-olona")
    public Olona mitadyOlona(int id){
        return new Olona(id,"anarana");
    }

}