/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ravi
 */
public class sales extends javax.swing.JInternalFrame {

    /**
     * Creates new form sales
     */
     Vector data = new Vector();
    float sum=0,txt=0,add=0;
   Connection x;
    public sales(Connection x) {
        initComponents();
        this.x=x;
        fillname();
        fillclient();
       
     
    }
     void fillname()
    {
     try {   
            
            String query = "select * from purchase";
            PreparedStatement ps = x.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
  
                String name= rs.getString("medicine_name");
                mcombo.addItem(name);
         }
            fillprice();
      }
    catch (Exception ex) 
    {
            ex.printStackTrace();
    }
    }
      void fillprice()
    {
     try {   
             String m = mcombo.getSelectedItem().toString();
             String query = "select * from purchase where medicine_name=?";
             PreparedStatement ps = x.prepareStatement(query);
             ps.setString(1, m);
             ResultSet rs = ps.executeQuery();

            while (rs.next()) 
            {
              String sale=rs.getString("sale_price");
             ptf.setText(sale);
               
       }
      }
    catch (Exception ex) 
    {
            ex.printStackTrace();
    }
    }
      void fillclient()
    {
     try {   
            
            String query = "select * from client";
            PreparedStatement ps = x.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
  
                String name= rs.getString("client_name");
                combo.addItem(name);
           }
      }
    catch (Exception ex) 
    {
            ex.printStackTrace();
    }
    }
      void fillpurchase()
    {
        purtf.removeAllItems();
     try {   
              String m = mcombo.getSelectedItem().toString();
              String query = "select * from purchase where medicine_name=?";
              PreparedStatement ps = x.prepareStatement(query);
              ps.setString(1, m);
              ResultSet rs = ps.executeQuery();

            while (rs.next()) {
  
                String name= rs.getString("batch_id");
              
                    purtf.addItem(name);
              
       }
      }
    catch (Exception ex) 
    {
            ex.printStackTrace();
    }
    }
      
         void showData() {
                    
try
{   
    //  String sale_id=stf.getText();
      String medicine_id = mcombo.getSelectedItem().toString();
      String purchase_id=purtf.getSelectedItem().toString();
      String Quantity=qtf.getText();
      String sale_price=ptf.getText();
      String taxes=taxtf.getText();
      String total=total_amt.getText();
       sum=Float.parseFloat(total)+sum;
       txt=Float.parseFloat(taxes)+txt;
       Vector heading = new Vector();
      //  heading.add("sale_id");
        heading.add("medicine_Name");
        heading.add("purchase_id"); 
        heading.add("Quantity");
        heading.add("sale price");
        heading.add("taxes");
        heading.add("total amt");
        Vector row = new Vector();
             //row.add((sale_id));
             row.add(medicine_id);
             row.add(purchase_id);
             row.add((Quantity));
             row.add(sale_price);
             row.add(taxes);
             row.add(total);
             data.add(row);
       
        DefaultTableModel d=new DefaultTableModel(data,heading);
        table.setModel(d);
     
}
  catch(Exception ex)
  {
    ex.printStackTrace();
  }
// totaltf.setText(Float.toString(sum));
}  
                  
  void salestable()
          
//          select saleid from sales order by saleid desc
                   
    {         String name=null;
               try {
                     
                     String query ="select sale_id from sales order by sale_id";
                     PreparedStatement ps = x.prepareStatement(query);
                     ResultSet rs = ps.executeQuery();

                    while (rs.next()) 
                             {
  
                                 name= rs.getString("sale_id");
                              }
                    }
               catch (Exception ex) 
                    {
                    ex.printStackTrace();
                    }
     try {
          int rows= table.getRowCount();
          TableModel tm= table.getModel();
          for(int i=0;i<rows;i++)
         {
          
          String medicine_name=(String) tm.getValueAt(i,0);
          String purchase_id=(String)tm.getValueAt(i,1);
          String quantity=(String)tm.getValueAt(i,2);
          String sale_price=(String)tm.getValueAt(i,3);
          String taxes=(String)tm.getValueAt(i,4);
          String pay=(String)tm.getValueAt(i,5);
          
          
            String query = "insert into salestable (sale_id,medicine_name,purchase_id,quantity,sale_price,taxes,total_amt)values (?,?,?,?,?,?,?)";
            PreparedStatement ps = x.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2,medicine_name);
            ps.setString(3,purchase_id);
            ps.setString(4,quantity);
            ps.setString(5,sale_price);
            ps.setString(6,taxes);
            ps.setString(7,pay);
            ps.executeUpdate();
         }
           JOptionPane.showMessageDialog(this, " Yeah!! Data Saved"); 
       
         }
    catch (Exception ex) 
    {
            ex.printStackTrace();
    }
      
}   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        dtf = new javax.swing.JTextField();
        ttf = new javax.swing.JTextField();
        totaltf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        mcombo = new javax.swing.JComboBox<>();
        qtf = new javax.swing.JTextField();
        ptf = new javax.swing.JTextField();
        taxtf = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        total_amt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        purtf = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        paytf = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("Client_id");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setText("Date");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setText("Tax");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setText("Total amount");

        combo.setBackground(new java.awt.Color(103, 146, 160));
        combo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        dtf.setBackground(new java.awt.Color(103, 146, 160));
        dtf.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        ttf.setBackground(new java.awt.Color(103, 146, 160));
        ttf.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        totaltf.setBackground(new java.awt.Color(103, 146, 160));
        totaltf.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel6.setText("medicine_id");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel7.setText("Quantity");

        Price.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        Price.setText(" sale price");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel9.setText("Taxes");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel8.setText("Toatl Amount");

        mcombo.setBackground(new java.awt.Color(103, 146, 160));
        mcombo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        mcombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mcomboItemStateChanged(evt);
            }
        });
        mcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mcomboActionPerformed(evt);
            }
        });

        qtf.setBackground(new java.awt.Color(103, 146, 160));
        qtf.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        qtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtfActionPerformed(evt);
            }
        });

        ptf.setBackground(new java.awt.Color(103, 146, 160));
        ptf.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        taxtf.setBackground(new java.awt.Color(103, 146, 160));
        taxtf.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        taxtf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                taxtfFocusLost(evt);
            }
        });
        taxtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taxtfActionPerformed(evt);
            }
        });

        jTextField4.setText("jTextField4");

        total_amt.setEditable(false);
        total_amt.setBackground(new java.awt.Color(103, 146, 160));
        total_amt.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/images/add.png"))); // NOI18N
        jButton1.setText("save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        table.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        jButton2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/images/add.png"))); // NOI18N
        jButton2.setText("Add in table");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel5.setText("purchase_id");

        purtf.setBackground(new java.awt.Color(103, 146, 160));
        purtf.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        purtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purtfActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel10.setText("total Payable amt");

        paytf.setBackground(new java.awt.Color(103, 146, 160));
        paytf.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Ubuntu", 3, 36)); // NOI18N
        jLabel11.setText("SALES MEDICINE  AND BILLING");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(187, 187, 187)
                        .addComponent(jButton2)
                        .addGap(366, 366, 366)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addComponent(total_amt, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dtf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ttf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(paytf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totaltf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(271, 271, 271)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 986, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(432, 432, 432)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(taxtf, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ptf, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qtf, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(purtf, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(taxtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(dtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(totaltf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(137, 137, 137)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(mcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(purtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(qtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ptf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(237, 237, 237)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(ttf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(total_amt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paytf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(88, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_formFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         try {  
              String name= combo.getSelectedItem().toString();
              String date=dtf.getText();
              String total=totaltf.getText();
              String tax=ttf.getText();
              String pay=paytf.getText();
           
            String query = "insert into sales (client_name,date,total_amt,tax,pay)values (?,?,?,?,?)";
            PreparedStatement ps = x.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2,date);
            ps.setString(3,total);
            ps.setString(4,tax);
            ps.setString(5,pay);
            ps.executeUpdate();
           JOptionPane.showMessageDialog(this, " Yeah!! Data Saved"); 
            
         }
    catch (Exception ex) 
    {
            ex.printStackTrace();
    }
      
        salestable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mcomboActionPerformed
        // TODO add your handling code here:
       fillpurchase();
   
    }//GEN-LAST:event_mcomboActionPerformed

    private void taxtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taxtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taxtfActionPerformed

    private void taxtfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_taxtfFocusLost
        // TODO add your handling code here:
        int a=Integer.parseInt(qtf.getText());
        float b=Float.parseFloat(ptf.getText());
        float c=Float.parseFloat(taxtf.getText());
        float x=(a*(b+c));
        total_amt.setText(String.valueOf(x));
    }//GEN-LAST:event_taxtfFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        showData();
        
      sum=0;
      txt=0;
      add=0;
      int rows= table.getRowCount();
      TableModel tm=  table.getModel();
      for(int i=0;i<rows;i++)
      {
          
          String h=(String)tm.getValueAt(i,4);
          String g=(String)tm.getValueAt(i,5);
          txt+=Float.parseFloat(h);
          sum+=Float.parseFloat(g);
          add=((txt*sum)/100)+sum;
          
      }
      
                ttf.setText(Float.toString(txt));
                totaltf.setText(Float.toString(sum));
                paytf.setText(Float.toString(add));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void purtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purtfActionPerformed
        // TODO add your handling code here:
        fillprice();
    }//GEN-LAST:event_purtfActionPerformed

    private void mcomboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mcomboItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_mcomboItemStateChanged

    private void qtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Price;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JTextField dtf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JComboBox<String> mcombo;
    private javax.swing.JTextField paytf;
    private javax.swing.JTextField ptf;
    private javax.swing.JComboBox<String> purtf;
    private javax.swing.JTextField qtf;
    private javax.swing.JTable table;
    private javax.swing.JTextField taxtf;
    private javax.swing.JTextField total_amt;
    private javax.swing.JTextField totaltf;
    private javax.swing.JTextField ttf;
    // End of variables declaration//GEN-END:variables

    private String String(float sum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
