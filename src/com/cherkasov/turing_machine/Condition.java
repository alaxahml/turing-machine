package com.cherkasov.turing_machine;

public class Condition {
    private int point_at;
    private String name;
    Condition(){
        point_at=Cells.current_place;
    }

    public void setPoint_at(int point_at){ this.point_at=point_at; }

    public int getPoint_at() {
        return point_at;
    }

    public String getName(){return name;}

    public void setName(String name) { this.name = name; }
}
