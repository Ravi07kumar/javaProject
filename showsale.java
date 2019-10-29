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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ravi
 */
public class showsale extends javax.swing.JInternalFrame {

    /**
     * Creates new form showsale
     */
    Connection x;
    public showsale(Connection x) {
        initComponents();
        this.x=x;
        showtable1();
        showtable2();
    }

               void showtable1() {
try
{
     
      Vector heading = new Vector();
      heading.add("sale_id");
      heading.add("client_Name");
      heading.add("Date");
      heading.add("amount");
      heading.add("taxes");
      heading.add("payable_amt");
       
        String query = "select * from sales";
        PreparedStatement ps = x.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        Vector data = new Vector();
        while(rs.next())
        {
              Vector row = new Vector();
              row.add(rs.getString("sale_id"));
              row.add(rs.getString("client_Name"));
              row.add(rs.getString("date"));
              row.add(rs.getString("total_amt"));
              row.add(rs.getString("tax"));
              row.add(rs.getString("pay"));
            
             data.add(row);
        }
        DefaultTableModel d=new DefaultTableModel(data,heading);
        table1.setModel(d);

        
}
  catch(Exception ex)
  {
    ex.printStackTrace();
  }
}
               
               void showtable2() {
try
{
     
        Vector heading = new Vector();
        heading.add("saletable_id");
        heading.add("sale_id");
        heading.add("medicine name");
        heading.add("purchase id");
        heading.add("quantity");
        heading.add("sale_price");
        heading.add("tax");
        heading.add("total_amt");
        String query = "select * from salestable";
        PreparedStatement ps = x.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        Vector data = new Vector();
        while(rs.next())
        {
             Vector row = new Vector();
             row.add(rs.getString("saletable_id"));
             row.add(rs.getString("sale_id"));
             row.add(rs.getString("medicine_name"));
             row.add(rs.getString("purchase_id"));
             row.add(rs.getString("quantity"));
             row.add(rs.getString("sale_price"));
             row.add(rs.getString("taxes"));
             row.add(rs.getString("total_amt"));
            
             data.add(row);
        }
        DefaultTableModel d=new DefaultTableModel(data,heading);
        table2.setModel(d);

        
}
  catch(Exception ex)
  {
    ex.printStackTrace();
  }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("sale");

        table1.setBackground(new java.awt.Color(103, 146, 160));
        table1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        table1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table1);

        table2.setBackground(new java.awt.Color(103, 146, 160));
        table2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        table2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(table2);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 3, 36)); // NOI18N
        jLabel1.setText("TOTAL SALES DETAILS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
}
