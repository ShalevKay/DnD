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


    /****************************   getters & setter    ****************************/

    public char getTile(){
        return tile;
    }

    public void setTile(char tile){
        this.tile = tile;
    }

    public Position getPosition(){
        return position;
    }

    public void setPosition(Position p){
        position = p;
    }

}
