package Safe;

public class Dolar extends Moeda {

    public Dolar(double valor) {
        this.valor = valor;

    }

    public void info() {
        System.out.println("***********************");
        System.out.println("*Dolar - " + valor );
        System.out.println("***********************");

    }

    public double converter() {

//usei a cotação do Dolar do dia em que realizei o trabalho

        return this.valor * 4.77;


    }
    //Criação do metodo para criar um objeto para a moeda
    public boolean equals(Object objeto) {
        if(this.getClass() != objeto.getClass()) {
            return false;
        }


        Dolar CoinOfDolar = (Dolar) objeto;


        if(this.valor != CoinOfDolar.valor) {
            return false;
        }

        return true;

    }

}
