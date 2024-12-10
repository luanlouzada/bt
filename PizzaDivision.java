import java.util.*;

public class PizzaDivision {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int familyMembers = 0;
            int pizzaSlices = 0;

            while (true) {
                try {
                    System.out.print("Digite o número de membros da família: ");
                    familyMembers = Integer.parseInt(scanner.nextLine());
                    if (familyMembers > 0) break;
                    System.out.println("Por favor, insira um número maior que zero.");
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                }
            }

            while (true) {
                try {
                    System.out.print("Digite o número de fatias da pizza: ");
                    pizzaSlices = Integer.parseInt(scanner.nextLine());
                    if (pizzaSlices > 0) break;
                    System.out.println("Por favor, insira um número maior que zero.");
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                }
            }

            int slicesPerMember = pizzaSlices / familyMembers;
            int leftoverSlices = pizzaSlices % familyMembers;

            System.out.printf("\nCada membro da família receberá %d fatias.%n", slicesPerMember);

            if (leftoverSlices > 0) {
                System.out.printf("Sobrarão %d fatias.%n", leftoverSlices);

                int additionalSlicesNeeded = familyMembers - leftoverSlices;
                System.out.printf("Você precisará de mais %d fatias para que todos recebam a mesma quantidade.%n", additionalSlicesNeeded);
            } else {
                System.out.println("A pizza foi dividida igualmente entre todos os membros da família.");
            }

        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}
