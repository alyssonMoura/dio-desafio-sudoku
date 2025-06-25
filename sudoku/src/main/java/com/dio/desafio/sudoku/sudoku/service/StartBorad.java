package com.dio.desafio.sudoku.sudoku.service;

import org.springframework.stereotype.Service;

import com.dio.desafio.sudoku.sudoku.model.Board;
import com.dio.desafio.sudoku.sudoku.model.Space;

@Service
public class StartBorad {

    public void execute(Board board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String pos = i + "-" + j;
                String id = "cell-" + pos;
                Space space = new Space(id, pos, "", true);
                board.updateSpace(space);
            }
        }
    }
}
