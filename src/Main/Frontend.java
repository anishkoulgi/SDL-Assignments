package Main;

import models.Expense;
import models.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Frontend extends javax.swing.JFrame {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8000;
    Socket client;
    ObjectInputStream fromServer;
    ObjectOutputStream toServer;

    public Frontend() throws IOException, ClassNotFoundException {
        initComponents();
        client = new Socket(SERVER_IP,SERVER_PORT);
        System.out.println("[CLIENT] Connected to Server...");
        fromServer = new ObjectInputStream(client.getInputStream());
        toServer = new ObjectOutputStream(client.getOutputStream());
        getUsers();
        getExpenses();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lastName = new javax.swing.JTextField();
        firstName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        expenseName = new javax.swing.JTextField();
        amount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        expenseSubmit = new javax.swing.JButton();
        userPaid = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Noto Sans CJK JP", 0, 16)); // NOI18N
        jLabel2.setText("Last Name");

        jLabel3.setFont(new java.awt.Font("Noto Serif CJK JP", 0, 16)); // NOI18N
        jLabel3.setText("First Name");

        lastName.setFont(new java.awt.Font("Noto Sans CJK JP", 0, 16)); // NOI18N

        firstName.setFont(new java.awt.Font("Noto Sans CJK JP", 0, 16)); // NOI18N

        jButton1.setFont(new java.awt.Font("Noto Sans CJK JP", 0, 16)); // NOI18N
        jButton1.setText("Add User");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Noto Sans CJK JP", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "ID", "First Name", "Last Name"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Users", jPanel1);

        jLabel4.setFont(new java.awt.Font("Noto Serif CJK JP", 0, 16)); // NOI18N
        jLabel4.setText("Expense Name");

        expenseName.setFont(new java.awt.Font("Noto Sans CJK JP", 0, 16)); // NOI18N

        amount.setFont(new java.awt.Font("Noto Sans CJK JP", 0, 16)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Noto Sans CJK JP", 0, 16)); // NOI18N
        jLabel5.setText("Amount");

        expenseSubmit.setFont(new java.awt.Font("Noto Sans CJK JP", 0, 16)); // NOI18N
        expenseSubmit.setText("Add Expense");
        expenseSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expenseSubmitActionPerformed(evt);
            }
        });

        userPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userPaidActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Noto Sans CJK JP", 0, 16)); // NOI18N
        jLabel6.setText("Paid By");

        jTable2.setFont(new java.awt.Font("Noto Sans CJK JP", 0, 16)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "ID", "Expense Name", "Amount", "Paid by"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable2.setRowHeight(30);
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel6))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(amount, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                                        .addComponent(expenseName, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                                        .addComponent(userPaid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(173, 173, 173)
                                                .addComponent(expenseSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(99, 99, 99)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(expenseName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(29, 29, 29)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(36, 36, 36)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(userPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6))
                                                .addGap(39, 39, 39)
                                                .addComponent(expenseSubmit))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Expenses", jPanel2);

        jLabel1.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 24)); // NOI18N
        jLabel1.setText("Expense Splitter");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTabbedPane1)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(496, 496, 496))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void getUsers() throws IOException, ClassNotFoundException {
        Vector<User> currentUsers;
        String choice = "5";
        toServer.writeObject(choice);
        currentUsers  = (Vector<User>)fromServer.readObject();

        DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
        df.setRowCount(0);
        for(User user : currentUsers) {
            userPaid.addItem(user.getName() + " " + user.getLname());
            Vector<String> row = new Vector<String>();
            row.add(user.getUserId());
            row.add(user.getName());
            row.add(user.getLname());
            System.out.println(row.get(0) + row.get(1) + row.get(2));
            df.addRow(row);
        }
    }

    private void getExpenses() throws IOException, ClassNotFoundException {
        Vector<Expense> expenses;
        String choice = "6";
        toServer.writeObject(choice);
        expenses  = (Vector<Expense>)fromServer.readObject();
        DefaultTableModel df = (DefaultTableModel)jTable2.getModel();
        df.setRowCount(0);
        for(Expense exp : expenses) {

            Vector<String> row = new Vector<String>();
            row.add(exp.getExpenseId());
            row.add(exp.getRemark());
            row.add(Float.toString(exp.getAmount()));
            row.add(exp.getUserId());
            df.addRow(row);
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String choice = "1";
            toServer.writeObject(choice);
            String first_name = firstName.getText();
            String last_name = lastName.getText();
            Hashtable<String,String> name = new Hashtable<>();
            name.put("fname",first_name);
            name.put("lname",last_name);
            toServer.writeObject(name);
            try {
                getUsers();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Frontend.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(Frontend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void expenseSubmitActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String choice = "2";
            toServer.writeObject(choice);
            String expName = expenseName.getText();
            float amt = Float.parseFloat(amount.getText());
            String usrId = Integer.toString(userPaid.getSelectedIndex() + 1);
            Expense newExpense = new Expense("",amt, new Date(),expName,usrId);
            toServer.writeObject(newExpense);
            getExpenses();
        } catch (IOException ex) {
            Logger.getLogger(Frontend.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Frontend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void userPaidActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public static void main(String args[]) throws IOException {


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Frontend().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Frontend.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Frontend.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField amount;
    private javax.swing.JTextField expenseName;
    private javax.swing.JButton expenseSubmit;
    private javax.swing.JTextField firstName;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField lastName;
    private javax.swing.JComboBox<String> userPaid;
    // End of variables declaration
}
