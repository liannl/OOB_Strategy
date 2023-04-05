import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int ind = 0, stop = 5;
        String str = "";
        StrategyClient strategy = new StrategyClient();

        System.out.print("Input data: ");
        str = scan.nextLine();

        System.out.println("\nSymmetric-Key cryptography ");
        strategy.setEncription(new SymmetricKeyCryptography());
        System.out.println(strategy.execute(str));

        System.out.println("\nAsymmetric cryptography ");
        strategy.setEncription(new PublicKeyCryptography());
        System.out.println(strategy.execute(str));

        System.out.println("\nSignature cryptography ");
        strategy.setEncription(new SignatureCryptography());
        System.out.println(strategy.execute(str));

    }
}
