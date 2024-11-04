package Backend.Tiles;

import Backend.VisitorInterfaces.Visited;

public abstract class Tile implements Visited{
    protected char tile;
    protected Position position;


    public double range(Tile other){
        return Position.range(position, other.position);
    }

    public String toString(){
        return "" + tile;
    }

}
