package model.entities;

public class Sql {
    private int codigo;
    private double price;

    //constr
    public Sql() {

    }

    public Sql(int codigo, double price) {
        this.codigo = codigo;
        this.price = price;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrice() {
        return price;
    }

}
