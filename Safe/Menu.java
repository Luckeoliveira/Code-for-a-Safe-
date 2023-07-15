package Safe;

import java.util.Scanner;
import java.util.InputMismatchException;


public class Menu {

    private Scanner scanner;
    private Cofre cofre;

    public Menu() {
        scanner = new Scanner(System.in);
        cofre = new Cofre();

    }

    //Criação de um Metodo para o Menu principal
    public void MainMenu() {
        System.out.println("**************** COFRE ****************");
        System.out.println("*                                     *");
        System.out.println("*1 - Adicionar Moeda                  *");
        System.out.println("*2 - Remover Moeda                    *");
        System.out.println("*3 - Listar Moedas                    *");
        System.out.println("*4 - Valor total convertido para real *");
        System.out.println("*0 - Encerrar                         *");
        System.out.println("*                                     *");
        System.out.println("***************************************");

        String selectOption = scanner.next();

        // Usei um Switch case para a escolha das opções acima
        switch (selectOption) {

            case "0":
                System.out.println("****************************");
                System.out.println("* Encerrando Programma...  *");
                System.out.println("****************************");
                break;

            case "1":
                menuAddCoins();
                MainMenu();
                break;

            case "2":

                menuRemoveCoins();
                MainMenu();

                break;

            case "3":
                cofre.listedCoin();
                MainMenu();
                break;

            default:
                System.out.println("**********************");
                System.out.println("* Opção Invalida...  *");
                System.out.println("* Tente Novamente!   *");
                System.out.println("**********************");
                MainMenu();
                break;

            case "4":
                double totalConvertedValue = cofre.ConvertedValue();

                //Aqui fiz uma pequena conversão para retornar apenas valor com duas casas decimais, pois certos valores iriam dar  como resultado valores muito longos

                String totalConvertedValueString = String.format("%.2f" , totalConvertedValue);
                totalConvertedValueString = totalConvertedValueString.replace(".", ".");
                System.out.println("O valor total convertido ´para real é: " + totalConvertedValueString);

                MainMenu();
                break;
        }


    }
    private void menuAddCoins() {

        System.out.println("*****************");
        System.out.println("*Escolha Moeda: *");
        System.out.println("*1 - Real       *");
        System.out.println("*2 - Dolar      *");
        System.out.println("*3 - Euro       *");
        System.out.println("*****************");

        int optionCoin = scanner.nextInt();

        // Condição para Testas  a opção selecionada, caso o usuario digitar qualquer coisa fora 1, 2 ou 3 de um erro
        if (optionCoin == 1 || optionCoin == 2 || optionCoin == 3) {
            System.out.println("****************************");
            System.out.println("* Digite o Valor da Moeda: *");
            System.out.println("****************************");
        }

        else {
            System.out.println("*********************");
            System.out.println("* Moeda Inexistente *");
            System.out.println("*********************");
            return;
        }


        //Aqui usei um um metodo para que possar ler como String caso o Usuario digite o valor com virgula
        //pois se eu usasse um para ler int, o usuario obrigatoriamente teria que usar ponto "."

        String StringCoin = scanner.next();
        StringCoin = StringCoin.replace("," , ".");

        //Aqui usei um metodo para converter o valor para um double, porque o valor da Moeda é em Double, então precisamos retornar um valor em double

        double valueCoin = Double.valueOf(StringCoin);

        Moeda coin = null;

        if(optionCoin == 1) {
            coin = new Real(valueCoin);

        }

        else if(optionCoin == 2) {
            coin = new Dolar(valueCoin);

        }

        else if(optionCoin == 3) {
            coin = new Euro(valueCoin);

        }

        cofre.adicionar(coin);
        System.out.println("********************");
        System.out.println("* Moeda Adicionada *");
        System.out.println("********************");

    }


    private boolean OptionCoin(String string, String string2, String string3) {
        return false;
    }

    private void menuRemoveCoins() {

        System.out.println("*****************");
        System.out.println("*Escolha Moeda: *");
        System.out.println("*1 - Real       *");
        System.out.println("*2 - Dolar      *");
        System.out.println("*3 - Euro       *");
        System.out.println("*****************");
        int optionCoin = scanner.nextInt();

        System.out.println("*****************************");
        System.out.println("* Digite o Valor da Moeda:  *");
        System.out.println("*****************************");

        String StringCoin = scanner.next();

        StringCoin = StringCoin.replace("," , ".");


        double valueCoin = Double.valueOf(StringCoin);

        Moeda coin = null;

        if(optionCoin == 1) {
            coin = new Real(valueCoin);

        }

        else if(optionCoin == 2) {
            coin = new Dolar(valueCoin);

        }

        else if(optionCoin == 3) {
            coin = new Euro(valueCoin);

        }
        else
            System.out.println("********************");
        System.out.println("* Moeda invalida!  *");
        System.out.println("* Tente Novamente! *");
        System.out.println("********************");


        if (cofre.remover(coin)){
            System.out.println("*******************************");
            System.out.println("* Moeda removida com sucesso! *");
            System.out.println("*******************************");

        }

        else {
            System.out.println("*********************************************************");
            System.out.println("* Não foi encontrado nenhuma moeda com o valor desejado *");
            System.out.println("*********************************************************");
        }

    }

}
