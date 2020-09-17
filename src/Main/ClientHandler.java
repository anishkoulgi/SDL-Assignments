package Main;

import models.Expense;
import models.Split;
import repository.ExpenseRepository;
import repository.UserRepository;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Hashtable;

public class ClientHandler extends Thread {
    private Socket client;
    private ObjectOutputStream toClient;
    private ObjectInputStream fromClient;

    public ClientHandler(Socket clientSocket) throws IOException {
        this.client = clientSocket;
        toClient = new ObjectOutputStream(client.getOutputStream());
        fromClient = new ObjectInputStream(client.getInputStream());
    }

    @Override
    public void run(){
        try {
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
            client.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
