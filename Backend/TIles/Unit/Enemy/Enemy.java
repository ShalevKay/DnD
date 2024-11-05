package Backend.Tiles.Unit.Enemy;

import Backend.Tiles.Unit.Unit;
import Backend.Tiles.Unit.Player.Player;
import Backend.VisitorInterfaces.Visitor;

public class Enemy extends Unit{

    @Override
    public void visit(Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Enemy enemy) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }
}
