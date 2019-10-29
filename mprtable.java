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
public class mprtable extends javax.swing.JInternalFrame {

    /**
     * Creates new form mprtable
     */
    Connection x;
    public mprtable(Connection x) {
        initComponents();
        this.x=x;
        fillname();
    }
      void fillname()
    {
     try {   
            
            String query = "select * from medicine";
            PreparedStatement ps = x.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                         String name= rs.getString("medicine_name");
                         mtf.addItem(name);}
      }
    catch (Exception ex) 
    {
            ex.printStackTrace();
    }
    }
       public  void medicinename()
      {  
         // String id=null;
          try {
            
        Vector heading = new Vector();
      heading.add("batch_id");
      heading.add("medicine_Name");
      heading.add("supplier name");
      heading.add("quantity");
      heading.add("price");
      heading.add(" sale price");
      heading.add("mfg");
      heading.add("exp");
      heading.add("purchase date");
      heading.add("total amount");
            String m = mtf.getSelectedItem().toString();
            String query = "select * from purchase where medicine_name=?";
            PreparedStatement ps = x.prepareStatement(query);
            ps.setString(1, m);
            ResultSet rs=ps.executeQuery();
            Vector data = new Vector();
            while(rs.next())
               {
                  Vector row = new Vector();
                  row.add(rs.getString("batch_id"));
                  row.add(rs.getString("medicine_Name"));
                  row.add(rs.getString("supplier_name"));
                  row.add(rs.getString("quantity"));
                  row.add(rs.getString("price"));
                  row.add(rs.getString("sale_price"));
                  row.add(rs.getString("mfg"));
                  row.add(rs.getString("exp"));
                  row.add(rs.getString("purchase_date"));
                  row.add(rs.getString("total_amt"));
             
                  data.add(row);
                }
            DefaultTableModel d=new DefaultTableModel(data,heading);
            table.setModel(d);
         
            
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
        mtf = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("MEDICINE NAME");

        mtf.setBackground(new java.awt.Color(103, 146, 160));
        mtf.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

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

        btn.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/images/search.png"))); // NOI18N
        btn.setText("SHOW");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        jLabel2.setText("CLICK TO SHOW DETAILS OF MEDICINE");

        jLabel3.setBackground(new java.awt.Color(162, 33, 29));
        jLabel3.setFont(new java.awt.Font("Ubuntu", 3, 36)); // NOI18N
        jLabel3.setText("MEDICINE PURCHASE DETAILS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(85, 85, 85)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(59, 59, 59)
                                        .addComponent(mtf, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 217, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mtf, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        // TODO add your handling code here:
       // showData();
       medicinename();
    }//GEN-LAST:event_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> mtf;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
