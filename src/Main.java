import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int priority, count =0;
        String name, dueDate, deadline;

        Task[] taskList = new Task[10];

        Scanner keyboard = new Scanner(System.in);

        File binaryFile = new File("Task.dat");
        System.out.println("Previously saved Tasks from binary file:");
        if (binaryFile.exists() && binaryFile.length() > 1L) {
            try {
                ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(binaryFile));
                taskList = (Task[]) fileReader.readObject();

                while (taskList[count] != null)
                    System.out.println(taskList[count++]);


                fileReader.close();

            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        else
            System.out.println("[None, please enter new Tasks]\n");

        do {
            System.out.println("Please enter task name (or \"quit\" to exit): ");
            name = keyboard.nextLine();
            if (name.equalsIgnoreCase("quit"))
                break;
            System.out.println("Please enter due date (in form MM/DD/YYYY): ");
            dueDate = keyboard.nextLine();
            System.out.println("Please enter deadline: ");
            deadline = keyboard.nextLine();
            System.out.println("Please enter priority: ");
            priority = keyboard.nextInt();
            keyboard.nextLine();

            taskList[count++] = new Task(name, dueDate, deadline, priority);

        } while(true);
        keyboard.close();

        try {
            ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(binaryFile));
            fileWriter.writeObject(taskList);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
