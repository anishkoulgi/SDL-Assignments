package Main;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {
    private static final int PORT = 8000;

    public static void main(String[] arg) throws Exception {

        ServerSocket server = new ServerSocket(PORT);
        System.out.println("[SERVER] Awaiting connection...");

        Socket connection = server.accept();
        ObjectOutputStream toClient = new ObjectOutputStream(connection.getOutputStream());
        ObjectInputStream fromClient = new ObjectInputStream(connection.getInputStream());
        Vector<Expense> expenses = new Vector<Expense>();
        Vector<User> users = new Vector<User>();
        String choice;

        do {

            choice = (String) fromClient.readObject();
            System.out.println("[SERVER] " + choice);
            switch (choice) {
                case "1" : {
                    User newUser = (User)fromClient.readObject();
                    users.add(newUser);
                    System.out.println("[SERVER] Added User successfully!");
                    break;
                }
                case "2": {
                    Expense newExpense = (Expense)fromClient.readObject();
                    expenses.add(newExpense);
                    System.out.println("[SERVER] Added Expense successfully!");
                    break;
                }
                case "3" : {
                    Split obj = new Split(expenses,users);
                    float splitMatrix[][] = obj.CalcSplit();
                    toClient.writeObject(splitMatrix);
                    break;
                }
                case "4" : {
                    Split obj = new Split(expenses,users);
                    toClient.writeObject(obj.CalcTotal());
                    break;
                }
                case "5": {
                    toClient.writeObject(users);
                    break;
                }
                case "6": {
                    toClient.writeObject(expenses);
                    break;
                }
            }
        } while (!choice.equals("7"));
        System.out.println("[SERVER] Shutting down...");
        connection.close();
        server.close();
    }
}
