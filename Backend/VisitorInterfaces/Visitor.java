package Backend.VisitorInterfaces;

import Backend.TIles.EmptyTile;
import Backend.TIles.Unit.Enemy.Enemy;
import Backend.TIles.Unit.Player.Player;
import Backend.TIles.Wall;

public interface Visitor {

    void visit(Wall wall);
    void visit(EmptyTile emptyTile);
    void visit(Player player);
    void visit(Enemy enemy);

}
