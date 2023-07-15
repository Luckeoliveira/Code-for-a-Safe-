package Safe;

public class Real extends Moeda {
    public Real(double valor) {
        this.valor = valor;
    }

    public void info() {
        System.out.println("***********************");
        System.out.println("* Real - " + this.valor);
        System.out.println("***********************");
    }

    public double converter() {
        return this.valor;
    }

    public boolean equals(Object objeto) {
        if (this.getClass() != objeto.getClass()) {
            return false;
        } else {
            Real CoinOfReal = (Real)objeto;
            return this.valor == CoinOfReal.valor;
        }
    }
}
