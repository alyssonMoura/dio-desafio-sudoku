package com.dio.desafio.sudoku.sudoku.service;

import com.dio.desafio.sudoku.sudoku.model.Board;
import com.dio.desafio.sudoku.sudoku.model.Space;

public class ValidBoard {

    public Board execute(Board board, Space space) {
        space.setIsValid(true);
        for (Space s : board.getSpaces().values()) {
            if (!s.getValor().isEmpty() && s.getValor().equals(space.getValor()) && !s.getId().equals(space.getId())) {
                if (s.getRow() == space.getRow() || s.getColumn() == space.getColumn()) {
                    space.setIsValid(false);
                }
                if (s.getRow() / 3 == space.getRow() / 3 && s.getColumn() / 3 == space.getColumn() / 3) {
                    space.setIsValid(false);
                }
                if (s.getRow() == s.getColumn() && space.getRow() == space.getColumn()) {
                    space.setIsValid(false);
                }
                if (s.getRow() + s.getColumn() == 8 && space.getRow() + space.getColumn() == 8) {
                    space.setIsValid(false);
                }
            }
        }
        board.updateSpace(space);
        return board;
    }
}
