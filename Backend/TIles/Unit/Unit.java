package Backend.Tiles.Unit;

import Backend.Tiles.EmptyTile;
import Backend.Tiles.Position;
import Backend.Tiles.Tile;
import Backend.Tiles.Wall;
import Backend.VisitorInterfaces.Visitor;

public abstract class Unit extends Tile implements Visitor{
    protected String name;
    protected int healthPool;
    protected int currentHealth;
    protected int attackPoints;
    protected int defensePoints;


    public void interact(Tile tile){
        tile.accept(this);
    }

    @Override
    public void visit(Wall wall) {
        return;
    }

    @Override
    public void visit(EmptyTile emptyTile) {
        int x = this.position.getX();
        int y = this.position.getY();

        Position other = emptyTile.getPosition();
        this.position.setX(other.getX());
        this.position.setY(other.getY());

        other.setX(x);
        other.setY(y);
    }

     








}
