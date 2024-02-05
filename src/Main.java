import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    private static final String RESULTS_FILE = "results.txt";
    private static PriorityQueue<Toy> toyQueue = new PriorityQueue<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Select action:");
            System.out.println("1. Add a new toy");
            System.out.println("2. To hold a drawing");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    addNewToy(scanner);
                    break;
                case 2:
                    Give();
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Wrong choice, try again.");
                    break;
            }
        }
    }
}
class Toy implements Comparable<Toy> {
    private int id;
    private String name;
    private double weight;

    public Toy(int id, String name, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Toy otherToy) {
        // Сравниваем игрушки по весу для определения порядка в очереди
        return Double.compare(this.weight, otherToy.weight);
    }
}
