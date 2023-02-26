package ija.ija2022.homework1.game;

import ija.ija2022.homework1.common.Field;
import ija.ija2022.homework1.common.Maze;
import ija.ija2022.homework1.common.MazeObject;

public class PathField implements Field {
    private int row;
    private int col;
    private Maze maze;
    private MazeObject object;


    public PathField(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    public boolean equals(Object obj) {
        return obj instanceof PathField && obj == maze.getField(this.row, this.col);
    }

    @Override
    public boolean canMove() {
        return true;
    }

    @Override
    public MazeObject get() {
        return this.object;
    }

    @Override
    public boolean isEmpty() {
        return this.object == null;
    }

    @Override
    public Field nextField(Field.Direction dirs) {
        switch (dirs) {
            case R:
                return this.maze.getField(this.row, this.col + 1);
            case L:
                return this.maze.getField(this.row, this.col - 1);
            case D:
                return this.maze.getField(this.row+1, this.col);
            case U:
                return this.maze.getField(this.row-1, this.col);
        }
        return null;
    }

    @Override
    public boolean put(MazeObject object) {
        if (!this.isEmpty())
            return false;
        this.object = object;
        return true;
    }

    @Override
    public boolean remove(MazeObject object) {
        if (this.object != object)
            return false;
        this.object = null;
        return true;
    }

    @Override
    public void setMaze(Maze maze) {
        this.maze = maze;
    }
    
}
