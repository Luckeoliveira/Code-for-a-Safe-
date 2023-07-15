package Safe;

public class Euro extends Moeda {
    public Euro(double valor) {
        this.valor = valor;
    }

    public void info() {
        System.out.println("***********************");
        System.out.println("*Euro - " + this.valor);
        System.out.println("***********************");
    }

    public double converter() {
        return this.valor * 5.2;
    }

    public boolean equals(Object objeto) {
        if (this.getClass() != objeto.getClass()) {
            return false;
        } else {
            Euro CoinOfEuro = (Euro)objeto;
            return this.valor == CoinOfEuro.valor;
        }
    }
}