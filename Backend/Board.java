package Backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Backend.Tiles.EmptyTile;
import Backend.Tiles.Tile;
import Backend.Tiles.Unit.Unit;

public class Board {
    private Tile[][] board;


    public Board(){
        board = null;
    }

    public void loadLevel(int level) throws FileNotFoundException{
        List<String> list = file2List("levels/level" + level + ".txt");
        String line;

        board = new Tile[list.size()][list.get(0).length()];

        for(int i=0; i<list.size(); i++){
            line = list.get(i);

            for(int j=0; j<line.length(); j++){
                board[i][j] = charToTile(line.charAt(j));
            }
        }
    }

    private List<String> file2List(String path) throws FileNotFoundException{
        List<String> list = new ArrayList<>();

        File file = new File(path);
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                list.add(line);
            }

            reader.close();

        return list;
    }

    private Tile charToTile(char c){
        // TODO: use factory
        return null;
    }
    
    public Tile getTile(int x, int y){
        if(x < 0 || x > board[0].length || y < 0 || y > board.length){
            return null;
        }

        return board[y][x];
    }

    public void updatePositions(Unit u, Tile tile){
        board[u.getPosition().getY()][u.getPosition().getX()] = u;

        // a dead enemy
        if(tile.getTile() == '1'){
            tile = new EmptyTile('.', tile.getPosition().getX(), tile.getPosition().getY());
        }

        board[tile.getPosition().getY()][tile.getPosition().getX()] = tile;
    }

}
