package com.dio.desafio.sudoku.sudoku.model;

import java.util.HashMap;
import java.util.Map;

import com.dio.desafio.sudoku.sudoku.enumeration.StatusGameEnum;

public class Board {
    
    private Map<String, Space> spaces = new HashMap<>();
    private int[][] grid;
    private StatusGameEnum status = StatusGameEnum.IN_PROGRESS;

    public StatusGameEnum getStatus() {
        return status;
    }

    public void setStatus(StatusGameEnum status) {
        this.status = status;
    }

    public Board() {
        this.spaces = new HashMap<>();
        this.grid = new int[9][9];
    }

    public int[][] getGrid() {
        return grid;
    }

    public void updateSpace(Space space) {
             removerSpace(space.getId());
            spaces.put(space.getId(), space);
            grid[space.getRow()][space.getColumn()] = space.getValor() != "" ? Integer.parseInt(space.getValor()) : 0;

    }

    public Map<String, Space> getSpaces() {
    return spaces;
}

    public void removerSpace(String string) {
        spaces.remove(string);
        for (Space space : spaces.values()) {
            if (space.getId().equals(string)) {
                grid[space.getRow()][space.getColumn()] = 0;
                break;
            }
        }

    }

    // private boolean isSpaceValid(Space space) {
    //     for (Space s : spaces.values()) {
    //         if (!s.getValor().isEmpty() && s.getValor().equals(space.getValor()) && !s.getId().equals(space.getId())) {
    //             if (s.getRow() == space.getRow() || s.getColumn() == space.getColumn()) {
    //                 return false;
    //             }
    //             if (s.getRow() / 3 == space.getRow() / 3 && s.getColumn() / 3 == space.getColumn() / 3) {
    //                 return false;
    //             }
    //             if (s.getRow() == s.getColumn() && space.getRow() == space.getColumn()) {
    //                 return false;
    //             }
    //             if (s.getRow() + s.getColumn() == 8 && space.getRow() + space.getColumn() == 8) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }

}
