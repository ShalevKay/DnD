package Backend.VisitorInterfaces;

import Backend.Tiles.EmptyTile;
import Backend.Tiles.Wall;
import Backend.Tiles.Unit.Enemy.Enemy;
import Backend.Tiles.Unit.Player.Player;

public interface Visitor {

    void visit(Wall wall);
    void visit(EmptyTile emptyTile);
    void visit(Player player);
    void visit(Enemy enemy);

}
