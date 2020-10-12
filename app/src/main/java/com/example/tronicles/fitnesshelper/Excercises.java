package com.example.tronicles.fitnesshelper;

/**
 * Created by Andrzej on 4/16/2018.
 */

public class Excercises {
    private int id;
    private String name;
    private int excerciselength;
    private String timetoexcercise;



    public Excercises()
    {
    }
    public Excercises(int id,String name, int excerciselength,String timetoexcercise)
    {
        this.id=id;
        this.name=name;
        this.excerciselength=excerciselength;
        this.timetoexcercise=timetoexcercise;
    }

    public Excercises(String names, int excerciselengths,String timetoexcercise) {
        this.name=names;
        this.excerciselength=excerciselengths;
        this.timetoexcercise=timetoexcercise;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTimetoexcercise(String timetoexcercise) {
        this.timetoexcercise = timetoexcercise;
    }

    public void setExcerciselength(int excerciselength) {
        this.excerciselength = excerciselength;
    }
    public int getId() {
        return id;
    }
    public int getExcerciselength() {
        return excerciselength;
    }
    public String getName() {
        return name;
    }
    public String getTimetoexcercise(){return timetoexcercise;}
}
