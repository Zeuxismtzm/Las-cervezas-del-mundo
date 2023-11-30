package br.com.map.cervezas.domain;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class News {

    //modelo de datos
    @PrimaryKey

    public int id;
    public String name;
    public String tagline;
    public String description;
    public String image_url;
    public String first_brewed;
    public String brewers_tips;
    public String contributed_by;
    public boolean favorite;

}