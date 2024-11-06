package Backend.Tiles;

import Backend.VisitorInterfaces.Visitor;

public class Wall extends Tile {

    public Wall(char tile, int x, int y){
        super(tile, x, y);
    }



    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }



}
