import Backend.Tiles.EmptyTile;
import Backend.Tiles.Wall;

public class Factory {
    
    public Factory(){

    }

    public EmptyTile makeEmptyTile(int x, int y){
        return new EmptyTile('.', x, y);
    }

    public Wall makeWall(int x, int y){
        return new Wall('#', x, y);
    }


}
