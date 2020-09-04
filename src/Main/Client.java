package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Vector;

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8000;

    public static void main(String[] args) throws Exception {
        Socket client = new Socket(SERVER_IP,SERVER_PORT);
        System.out.println("[CLIENT] Connected to Server...");
        ObjectInputStream fromServer = new ObjectInputStream(client.getInputStream());
        ObjectOutputStream toServer = new ObjectOutputStream(client.getOutputStream());
        System.out.println("-----------------Expense Splitter------------------");
        System.out.println("Menu \n 1) Add User \n 2) Add Expense \n 3) Calculate Split \n 4) Show total expenses \n 5) Show users \n 6) Show Expenses \n 7) Exit");
        String choice;
        BufferedReader fromUser = new BufferedReader(new InputStreamReader(System.in));
        int users = 0;
        do {
            System.out.println("Please enter your choice");
            choice = fromUser.readLine();
            toServer.writeObject(choice);
            switch (choice) {
                case "1" : {
                    String name,id;
                    System.out.println("Enter name and id of user");
                    name = fromUser.readLine();
                    id = fromUser.readLine();
                    User newUser = new User(id,name, 0L);
                    toServer.writeObject(newUser);
                    users++;
                    break;
                }
                case "2" : {
                    String id,remark,userId;
                    System.out.println("Enter id of string,remark and id of user who paid the expense");
                    id = fromUser.readLine();
                    remark = fromUser.readLine();
                    userId = fromUser.readLine();
                    float amt;
                    System.out.println("Enter amount");
                    amt = Float.parseFloat(fromUser.readLine());
                    Expense newExpense = new Expense(id,amt, new Date(),remark,userId);
                    toServer.writeObject(newExpense);
                    break;
                }
                case "3" : {
                    float splitMatrix[][] = (float[][]) fromServer.readObject();
                    System.out.println("[CLIENT]");
                    for (int i = 0; i < users; ++i) {
                        for (int j = 0; j < users; ++j) {
                            System.out.print(splitMatrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;
                }
                case "4" : {
                    float total = (float)fromServer.readObject();
                    System.out.println("[CLIENT] Total Expenses are " + total);
                    break;
                }
                case "5" : {
                    Vector<User> currentUsers;
                    currentUsers  = (Vector<User>)fromServer.readObject();
                    for(User usr:currentUsers) {
                        usr.showUser();
                    }
                    break;
                }
                case "6" : {
                    Vector<Expense> expenses;
                    expenses = (Vector<Expense>)fromServer.readObject();
                    System.out.println(expenses.size());
                    for(Expense expense:expenses) {
                        expense.showExpense();
                    }
                    break;
                }
            }
        } while (!choice.equals("7"));
        System.out.println("[CLIENT] Shutting down...");
        client.close();
    }
}
