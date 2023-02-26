package ija.ija2022.homework1.game;

import ija.ija2022.homework1.common.Field;
import ija.ija2022.homework1.common.Maze;
import ija.ija2022.homework1.common.MazeObject;

public class WallField implements Field {
    private int row;
    private int col;
    private Maze maze;
    

    public WallField(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    public boolean equals(Object obj) {
        return obj instanceof WallField && obj == maze.getField(this.row, this.col);
    }

    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public MazeObject get() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Field nextField(Field.Direction dirs) {
        throw new UnsupportedOperationException("Unimplemented method 'nextField'");
    }

    @Override
    public boolean put(MazeObject object) {
        throw new UnsupportedOperationException("Unimplemented method 'put'");
    }

    @Override
    public boolean remove(MazeObject object) {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void setMaze(Maze maze) {
        this.maze = maze;
    }
}
