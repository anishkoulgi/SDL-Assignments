package Main;

import java.util.HashMap;
import java.util.Vector;

public class Split {
    Vector<Expense> expenses;
    Vector<User> users;
    HashMap<String,Integer> splitMap;
    float[][] splitMatrix;

    public Split(Vector<Expense> expenses, Vector<User> users) {
        this.expenses = expenses;
        this.users = users;
        this.splitMap = new HashMap<String, Integer>();
        for (int i = 0; i < users.size(); ++i) {
            splitMap.put(users.elementAt(i).getUserId(),i);
        }
        splitMatrix = new float[users.size()][users.size()];
    }

    public float CalcTotal() {
        float total = 0;
        for (Expense exp: expenses) {
            total += exp.getAmount();
        }
        return total;
    }

    public float[][] CalcSplit() {
        for(Expense exp : expenses) {
            float dividedAmount = exp.getAmount() / users.size();
            for(User user : users) {
                if (user.getUserId().compareTo(exp.getUserId()) != 0) {
                    splitMatrix
                            [splitMap.get(user.getUserId())]
                            [splitMap.get(exp.getUserId())]
                            += dividedAmount;
                }
            }
        }

        return splitMatrix;
    }

}
