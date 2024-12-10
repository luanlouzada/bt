import java.util.Scanner;

public class PrimeNumberRecursive {
    /* Já resolvi várias vezes esse exercício, usando recursão,
    tem forma mais eficiente de resolver, mas não me lembro da outra.
     */
    public static boolean isPrime(int number, int divisor) {
        if (divisor == 1) {
            return true;
        }
        if (number % divisor == 0) {
            return false;
        }
        return isPrime(number, divisor - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite um número inteiro positivo: ");
            String input = scanner.nextLine();

            int number = Integer.parseInt(input);

            if (number <= 0) {
                System.out.println("Por favor, insira um número inteiro positivo.");
            } else if (number == 1) {
                System.out.println("1 não é primo.");
            } else {
                boolean result = isPrime(number, number - 1);
                if (result) {
                    System.out.println(number + " é um número primo.");
                } else {
                    System.out.println(number + " não é um número primo.");
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, insira um número inteiro válido.");
        } finally {
            scanner.close();
        }
    }
}
