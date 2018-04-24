package com.example.sam.grocerylist;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Sam on 4/23/18.
 */

public class Grocery extends RealmObject {
    @Required
    @PrimaryKey
    private String id;
    private String item;
    private boolean bought;

    public String getID(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getItem(){
        return item;
    }
    public void setItem(String item){
        this.item = item;
    }
    public Boolean isBought(){
        return bought;
    }
    public void setBought(boolean done){
        this.bought = done;
    }
}
