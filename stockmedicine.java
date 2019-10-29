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
public class stockmedicine extends javax.swing.JInternalFrame {

    /**
     * Creates new form stockmedicine
     */
    Connection x;
    public stockmedicine(Connection x) {
        initComponents();
        this.x=x;
        fillmedicine();
       
    }
    int mq=0;
    
    int sq=0;
    
     String remaning=null;
    int medq=0;
    int salesq=0;
 
  void fillmedicine()
    {
     try { 
            
            String query = "select * from medicine";
            PreparedStatement ps = x.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                 String name= rs.getString("medicine_name");
                 mcombo.addItem(name);
         }
      }
    catch (Exception ex) 
    {
            ex.printStackTrace();
    }
}     
     void totalmedicine()
    {
     try {  
         mq=0;
            String t = mcombo.getSelectedItem().toString(); 
            String query = "select * from purchase where medicine_name=?";
            PreparedStatement ps = x.prepareStatement(query);
            ps.setString(1, t);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                 mq+= Integer.parseInt(rs.getString("quantity"));
               //  System.out.println(mq);
            }
      }
    catch (Exception ex) 
    {
            ex.printStackTrace();
    }
}   
     
     
     
  void salesq()
    {
     try { 
          sq=0;
            String t = mcombo.getSelectedItem().toString(); 
            String query = "select * from salestable where medicine_name=?";
            PreparedStatement ps = x.prepareStatement(query);
            ps.setString(1, t);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                   sq+= Integer.parseInt(rs.getString("quantity"));
                 //  System.out.println(sq);
            }
      }
    catch (Exception ex) 
    {
            ex.printStackTrace();
    }
}     



   void showtable() {
       
         totalmedicine();
         salesq();
try
{   
    String t = mcombo.getSelectedItem().toString(); 
    
 
     medq=mq;
     salesq=sq;
     remaning=(String.valueOf(medq-salesq));
    // System.out.print(remaning);
      Vector heading = new Vector();
      heading.add("medicine name");
      heading.add("total quantity");
      heading.add("sales quantity");
      heading.add("remaning quantity");
     
           Vector data = new Vector();
      
           Vector row = new Vector();
           row.add(t);
           row.add(medq);
           row.add((salesq));
           row.add(remaning);
            
        data.add(row);
       
        DefaultTableModel d=new DefaultTableModel(data,heading);
        table.setModel(d);

        
}
  catch(Exception ex)
  {
    ex.printStackTrace();
  }
}
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mcombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);

        mcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mcomboActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("Medicine Name");

        table.setBackground(new java.awt.Color(103, 146, 160));
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
        btn.setText("Search");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 3, 36)); // NOI18N
        jLabel2.setText("DETIALS OF STOCK MEDICINE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(mcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(293, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(122, 122, 122))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(btn)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        // TODO add your handling code here:
         showtable();
    }//GEN-LAST:event_btnActionPerformed

    private void mcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mcomboActionPerformed
        // TODO add your handling code here:
       
         salesq();
    }//GEN-LAST:event_mcomboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> mcombo;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
