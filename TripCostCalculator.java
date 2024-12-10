import java.util.Scanner;

public class TripCostCalculator {
    public static void main(String[] args) {
        double averageConsumption = 12.0;
        double distance = 360.0;

        Scanner scanner = new Scanner(System.in);
        double pricePerLiter = -1.0;

        while (pricePerLiter <= 0) {
            System.out.print("Informe o preço do combustível por litro (em R$): ");
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine().replace(",", ".");
                try {
                    pricePerLiter = Double.parseDouble(input);
                    if (pricePerLiter <= 0) {
                        System.out.println("Por favor, insira um valor positivo.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número.");
                }
            }
        }

        double requiredLiters = distance / averageConsumption;

        double totalCost = requiredLiters * pricePerLiter;

        System.out.println("Litros de combustível necessários: " + requiredLiters);
        System.out.println("Custo total da viagem: R$ " + String.format("%.2f", totalCost));

        scanner.close();
    }
}
