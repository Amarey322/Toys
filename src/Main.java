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


    private static void addNewToy(Scanner scanner) {
        System.out.println("Enter the toy ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        System.out.println("Enter the name of the toy:");
        String name = scanner.nextLine();

        System.out.println("Enter the weight of the toy:");
        double weight = scanner.nextDouble();
        scanner.nextLine(); // Очистка буфера

        Toy newToy = new Toy(id, name, weight);
        toyQueue.add(newToy);
    }
    private static void Give() {
        if (toyQueue.isEmpty()) {
            System.out.println("The toy list is empty. Add toys before the drawing.");
            return;
        }

        Toy winningToy = getRandomToy();

        try (FileWriter writer = new FileWriter(RESULTS_FILE, true)) {
            writer.write("The toy won: " + winningToy.getName() + "\n");
        } catch (IOException e) {
            System.out.println("An error occurred when writing the results of the drawing to a file.");
        }

        System.out.println("The drawing is over. The toy won: " + winningToy.getName());
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
