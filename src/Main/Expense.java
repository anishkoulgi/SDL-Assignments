package Main;

import java.io.Serializable;
import java.util.Date;

public class Expense implements Serializable {
    private String expenseId;
    private float amount;
    private Date date;
    private String remark;
    private String userId;

    public Expense(String expenseId, float amount, Date date, String remark,String userId) {
        this.expenseId = expenseId;
        this.amount = amount;
        this.date = date;
        this.remark = remark;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public void showExpense() {
        System.out.println(expenseId + "\t" + amount + "\t" + userId + "\t" + date + "\t" + remark);
    }
}
