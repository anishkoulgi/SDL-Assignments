package Main;

import models.Expense;
import models.Split;
import repository.ExpenseRepository;
import repository.UserRepository;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

public class Server {
    private static final int PORT = 8000;

    public static void main(String[] arg) throws Exception {

        ServerSocket server = new ServerSocket(PORT);
        System.out.println("[SERVER] Awaiting connection...");

        Socket connection = server.accept();
        ObjectOutputStream toClient = new ObjectOutputStream(connection.getOutputStream());
        ObjectInputStream fromClient = new ObjectInputStream(connection.getInputStream());

        UserRepository userRepo = new UserRepository();
        ExpenseRepository expRepo = new ExpenseRepository();
        String choice;

        do {

            choice = (String) fromClient.readObject();
            System.out.println("[SERVER] " + choice);
            switch (choice) {
                case "1" : {
                    Hashtable<String,String> name = (Hashtable<String, String>) fromClient.readObject();
                    userRepo.addUser(name.get("fname"),name.get("lname"));
                    break;
                }
                case "2": {
                    Expense newExpense = (Expense)fromClient.readObject();
                    expRepo.addExpense(newExpense.getRemark(),newExpense.getAmount(),newExpense.getUserId());
                    break;
                }
                case "3" : {

                    Split obj = new Split(expRepo.getExpenses(),userRepo.getUsers());
                    float[][] splitMatrix = obj.CalcSplit();
                    toClient.writeObject(userRepo.getUserCount());
                    toClient.writeObject(splitMatrix);
                    break;
                }
                case "4" : {
                    Split obj = new Split(expRepo.getExpenses(),userRepo.getUsers());
                    toClient.writeObject(obj.CalcTotal());
                    break;
                }
                case "5": {
                    toClient.writeObject(userRepo.getUsers());
                    break;
                }
                case "6": {
                    toClient.writeObject(expRepo.getExpenses());
                    break;
                }
            }
        } while (!choice.equals("7"));
        System.out.println("[SERVER] Shutting down...");
        connection.close();
        server.close();
    }
}
