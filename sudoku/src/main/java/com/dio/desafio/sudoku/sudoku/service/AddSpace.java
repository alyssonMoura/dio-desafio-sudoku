package com.dio.desafio.sudoku.sudoku.service;

import java.util.Map;

import com.dio.desafio.sudoku.sudoku.model.Board;
import com.dio.desafio.sudoku.sudoku.model.Space;

public class AddSpace {

    public void execute(Board board, Map<String, String> payload) {
       Space space = new Space(
            payload.get("id"),
            payload.get("pos"),
            payload.get("valor"),
            true
        );
        board.updateSpace(space);
    }
}
