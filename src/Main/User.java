package Main;

import java.io.Serializable;

public class User implements Serializable {
    private String userId;
    private String name;
    private Long totalExpense;

    public User(String userId, String name, Long totalExpense) {
        this.userId = userId;
        this.name = name;
        this.totalExpense = totalExpense;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(Long totalExpense) {
        this.totalExpense = totalExpense;
    }
    public void showUser() {
        System.out.println(userId + "\t" + name + "\t" + totalExpense);
    }
}
