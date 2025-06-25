package com.dio.desafio.sudoku.sudoku.model;

public class Space {

    private String id;
    private String pos;
    private int row;
    private int column;
    private String valor;
    private boolean isValid;

    public Space(String id, String pos, String valor, boolean isValid) {
        this.id = id;
        this.pos = pos;
        this.valor = valor;
        this.isValid = isValid;
        getRowColumnFromPos();
    }
    public Space() {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPos() {
        return pos;
    }
    public void setPos(String pos) {
        this.pos = pos;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }

    
    public boolean isValid() {
        return isValid;
    }

    public void getRowColumnFromPos() {
        String[] parts = pos.split("-");
        int row = Integer.parseInt(parts[0]);
        int column = Integer.parseInt(parts[1]);
        setRow(row);
        setColumn(column);
    }

    public void setIsValid(boolean b) {
        this.isValid = b;
    }

    @Override
    public String toString() {
        return "Space{" +
                "id='" + id + '\'' +
                ", pos='" + pos + '\'' +
                ", row=" + row +
                ", column=" + column +
                ", valor='" + valor + '\'' +
                ", isValid=" + isValid +
                '}';  
    }  

}
