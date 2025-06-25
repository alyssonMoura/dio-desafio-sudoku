package com.dio.desafio.sudoku.sudoku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import com.dio.desafio.sudoku.sudoku.model.Board;
import com.dio.desafio.sudoku.sudoku.model.Space;
import com.dio.desafio.sudoku.sudoku.service.AddSpace;
import com.dio.desafio.sudoku.sudoku.service.StartBorad;
import com.dio.desafio.sudoku.sudoku.service.ValidBoard;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class HomeController {

    private final Board board = new Board();
    @Autowired
    private final StartBorad startBorad = new StartBorad();

    @GetMapping("/")
    public String home(Model model) {
        startBorad.execute(board);
        model.addAttribute("spaces", board.getSpaces());
        return "home";
    }

    @PostMapping("/cell-update")
    @ResponseBody
    public void cellUpdate(@RequestBody Map<String, String> payload) {
        AddSpace addSpace = new AddSpace();
        addSpace.execute(board, payload);
    }
    @GetMapping("/board-json")
    @ResponseBody
    public Map<String, Space> boardJson() {
        System.out.println("Returning board JSON");
        for (Space space : new ArrayList<>(board.getSpaces().values())) {
        ValidBoard validBoard = new ValidBoard();
        validBoard.execute(board, space);
            System.out.println(space);
        }
        return board.getSpaces();
    }

    @PostMapping("/reset")
    @ResponseBody
    public void resetBoard() {
        startBorad.execute(board);
    }

    @PostMapping("/solve")
    @ResponseBody
    public void solveBoard() {
        for (Space space : board.getSpaces().values()) {
            space.setValor("");
            space.setIsValid(true);
            board.updateSpace(space);
        }
    }
}
