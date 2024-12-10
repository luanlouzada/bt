import java.util.*;

public class StudentGradeFilter {

    public static void main(String[] args) {
    /* Usei tudo que eu uso no dia a dia no trabalho e faculdade, única coisa que precisei da uma colada boa foi no
     nome colorido e negrito.
    Esse comentário é meu Luan Louzada, só um exemplo do dia a dia: */
    //TODO: Implementar se o aluno ja existe, se sim perguntar se quer modificar o aluno atual ou criar um novo
        try (Scanner scanner = new Scanner(System.in)) {
            List<Student> students = new ArrayList<>();
            int numberOfStudents = 0;

            while (true) {
                try {
                    System.out.print("Digite o número de alunos na turma: ");
                    numberOfStudents = Integer.parseInt(scanner.nextLine());
                    if (numberOfStudents > 0) break;
                    System.out.println("Por favor, insira um número maior que zero.");
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                }
            }

            for (int i = 0; i < numberOfStudents; i++) {
                System.out.printf("\u001B[1mDigite o \u001B[34mnome\u001B[0m do aluno %d: ", i + 1);
                String name = scanner.nextLine();

                double grade = 0.0;
                while (true) {
                    try {
                        System.out.printf("\u001B[1mDigite a \u001B[33mnota\u001B[0m do aluno %d (use vírgula ou ponto): ", i + 1);
                        String gradeInput = scanner.nextLine().replace(",", ".");
                        grade = Double.parseDouble(gradeInput);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Por favor, insira um número válido para a nota.");
                    }
                }

                students.add(new Student(name, grade));
            }

            double average = calculateAverage(students);
            printAboveAverageStudents(students, average);

            String response;
            do {
                System.out.print("Deseja corrigir a nota de algum aluno? (sim/não): ");
                response = scanner.nextLine().trim().toLowerCase();

                if (response.equals("sim")) {
                    System.out.print("Digite o nome do aluno que deseja corrigir: ");
                    String name = scanner.nextLine();

                    Student studentToEdit = null;
                    for (Student student : students) {
                        if (student.getName().equalsIgnoreCase(name)) {
                            studentToEdit = student;
                            break;
                        }
                    }

                    if (studentToEdit != null) {
                        while (true) {
                            try {
                                System.out.printf("Digite a nova nota para %s (use vírgula ou ponto): ", studentToEdit.getName());
                                String newGradeInput = scanner.nextLine().replace(",", ".");
                                double newGrade = Double.parseDouble(newGradeInput);
                                studentToEdit.setGrade(newGrade);
                                System.out.printf("Nota de %s atualizada para %.2f\n", studentToEdit.getName(), studentToEdit.getGrade());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada inválida para a nota. Tente novamente.");
                            }
                        }

                        average = calculateAverage(students);
                        printAboveAverageStudents(students, average);
                    } else {
                        System.out.println("Aluno não encontrado. Verifique o nome e tente novamente.");
                    }
                }

            } while (response.equals("sim"));

        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    private static double calculateAverage(List<Student> students) {
        double total = 0;
        for (Student student : students) {
            total += student.getGrade();
        }
        return total / students.size();
    }

    private static void printAboveAverageStudents(List<Student> students, double average) {
        System.out.printf("\nA média da turma é: %.2f\n", average);
        System.out.println("Alunos com nota acima da média:");
        for (Student student : students) {
            if (student.getGrade() > average) {
                System.out.printf("%s com nota %.2f\n", student.getName(), student.getGrade());
            }
        }
        System.out.println();
    }

    private static class Student {
        private final String name;
        private double grade;

        public Student(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public double getGrade() {
            return grade;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }
    }
}
