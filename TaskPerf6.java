import java.util.*;
import java.io.*;

public class TaskPerf6 {
    public static void main(String args[]) {
        File outputFile = new File("D:\\Collage STI\\1st year\\2nd Sem\\Comprog 2\\Login or Signup\\Records.txt");
        Scanner s = new Scanner(System.in);
        System.out.print("Enter [R] for register or [L] for login: ");
        String choice = s.nextLine().trim().toUpperCase();
        
        try {
            switch (choice) {
                case "R": {
                    System.out.print("Enter your Name or Username: ");
                    String uName = s.nextLine();
                    System.out.print("Enter your Password: ");
                    String pWord = s.nextLine();
                    
                    if (!uName.matches("^[a-zA-Z0-9]*$") || !pWord.matches("^[a-zA-Z0-9]*$")) {
                        System.out.println("Only input alphanumeric characters");
                    } else {
                        PrintWriter pwrite = new PrintWriter(new BufferedWriter(new FileWriter(outputFile, true)));
                        pwrite.println(uName + " " + pWord);
                        pwrite.flush();
                        pwrite.close();
                        System.out.println("You have Successfully Registered!");
                    }
                }
                break;

                case "L": {
                    System.out.print("Enter your Name or Username: ");
                    String uName = s.nextLine();
                    System.out.print("Enter your Password: ");
                    String pWord = s.nextLine();
                    
                    if (!uName.matches("^[a-zA-Z0-9]*$") || !pWord.matches("^[a-zA-Z0-9]*$")) {
                        System.out.println("Only input alphanumeric characters");
                    } else {
                        Scanner opf = new Scanner(outputFile);
                        boolean isExist = false;
                        
                        while (opf.hasNextLine()) {
                            String line = opf.nextLine().trim();
                            String[] info = line.split(" ");
                            if (info[0].trim().equalsIgnoreCase(uName) && info[1].trim().equalsIgnoreCase(pWord)) {
                                System.out.println("You have Successfully Logged in!");
                                isExist = true;
                                break;
                            }
                        }
                        
                        if (!isExist) {
                            System.out.println("Incorrect username and password!");
                        }
                        opf.close();
                    }
                }
                break;

                default: 
                    System.out.println("x> Invalid choice!");
            }
        } catch (IOException ioe) {
            System.out.println("An error occurred: " + ioe.getMessage());
        }
        
        s.close();
        return;
    }
}
