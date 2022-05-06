
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ceyda
 */
public class JavaTablo extends javax.swing.JFrame {
   public static String[] info = new String[6];
    ArrayList<Masraflar> data = new ArrayList<>();
    BufferedReader br;
   
    /**
     * Creates new form JavaTablo
     */
    public JavaTablo() {
        initComponents();
        if (System.getProperty("java.vendor").equals("Ubuntu")) {
            readFile(new File(System.getProperty("user.dir") + "/src/harcamalar.txt"));
        } else {
            readFile(new File(System.getProperty("user.dir") + "\\src\\harcamalar.txt"));      
        }
        setDataToTable();
        setInfo();
        
    }
    
       private void setDataToTable() {
        jTable1_UrunTablo.getColumnModel().getColumn(0).setHeaderValue(data.get(0).getId());
        jTable1_UrunTablo.getColumnModel().getColumn(1).setHeaderValue(data.get(0).getDate());
        jTable1_UrunTablo.getColumnModel().getColumn(2).setHeaderValue(data.get(0).getCategory());
        jTable1_UrunTablo.getColumnModel().getColumn(3).setHeaderValue(data.get(0).getPrice());

        for (int i = 1; i < data.size(); i++) {
            ((DefaultTableModel) jTable1_UrunTablo.getModel()).addRow(new Object[]{data.get(i).getId(),
                data.get(i).getDate(), data.get(i).getCategory(), data.get(i).getPrice()});
        }

    }

        private void readFile(File file) {
        try {
            br = new BufferedReader(new FileReader(file));            
            for (String line; (line = br.readLine()) != null;) {
                String[] items = line.split(";");
                data.add(new Masraflar(items[0], items[1], items[2], items[3]));
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getLocalizedMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getLocalizedMessage());
        }
    }
         public static HashMap<String, Double> sortByValue(HashMap<String, Double> hm) 
    { 
       
        LinkedList<Map.Entry<String, Double> > list = 
               new LinkedList< >(hm.entrySet()); 
  
        
        Collections.sort(list, (Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) -> (o1.getValue()).compareTo(o2.getValue())); 
          
        HashMap<String, Double> temp = new LinkedHashMap<>(); 
        list.forEach((aa) -> {
            temp.put(aa.getKey(), aa.getValue());
       }); 
        return temp; 
    }
         private void setInfo() {
        double totalPrice = 0;
        double weekEndTotal = 0;
        for (int i = 1; i < data.size(); i++) {
            totalPrice += Double.valueOf(data.get(i).getPrice());
            if (data.get(i).isWeekend()) {
                weekEndTotal += Double.valueOf(data.get(i).getPrice());
            }
        }
        if (weekEndTotal > (totalPrice - weekEndTotal)) {
            info[0] = "Haftasonu daha fazla harcama yapılmış";
        } else {
             info[0] = "Haftaiçi daha fazla harcama yapılmış";
        }
        info[1] = "Toplam Harcama Tutarı : " + totalPrice;

        HashMap<String, Double> categories = new HashMap<>();
        HashMap<String, Double> days = new HashMap<>();
        HashMap<String, Double> months = new HashMap<>();
        data.stream().map((e) -> {
   
            if (!e.getCategory().equals("KATEGORİ")) {
                double price = Double.valueOf(e.getPrice());
                if (categories.containsKey(e.getCategory())) {                    
                    categories.put(e.getCategory(), categories.get(e.getCategory()) + price);
                } else {
                    categories.put(e.getCategory(), Double.valueOf(e.getPrice()));
                }
            }
            
           if (!e.getCategory().equals("KATEGORİ")) {
               if (days.containsKey(e.getDay())) {
                   double price = Double.valueOf(e.getPrice());
                   days.put(e.getDay(), days.get(e.getDay()) + price);
               } else {
                   days.put(e.getDay(), Double.valueOf(e.getPrice()));
               }
           }
     
           return e;
       }).filter((e) -> (!e.getCategory().equals("KATEGORİ"))).forEachOrdered((e) -> {
           if (months.containsKey(e.getMonth())) {
               double price = Double.valueOf(e.getPrice());
               months.put(e.getMonth(), months.get(e.getMonth()) + price);
           } else {
               months.put(e.getMonth(), Double.valueOf(e.getPrice()));
           }
       });

        categories.entrySet().forEach((entry) -> {
            String key = entry.getKey();
            double value = entry.getValue();
            ((DefaultTableModel) jTable4.getModel()).addRow(new Object[]{key, value});
       });

        days.entrySet().forEach((entry) -> {
            String key = entry.getKey();
            double value = entry.getValue();
            ((DefaultTableModel) jTable2.getModel()).addRow(new Object[]{key, value});
       });
        
        months.entrySet().forEach((entry) -> {
            String key = entry.getKey();
            double value = entry.getValue();
            ((DefaultTableModel) jTable3.getModel()).addRow(new Object[]{key, value});
       });
        
        String maxCatPrice = "";
        String minCatPrice = "";
        int order = 0;
        Map<String, Double> maxCat = sortByValue(categories);
        for (Map.Entry<String, Double> cat : maxCat.entrySet()) { 
            if (order == 0) {
                minCatPrice = cat.getKey();
            }
            order++;
            maxCatPrice = cat.getKey();
        }        
        order = 0;
        info[2] = "En fazlama harcama " + maxCatPrice + " kategorisine ait";
        info[3] = "En az harcama " + minCatPrice + " kategorisine ait";
        
        String minMonthPrice = "";
        String maxMonthPrice = "";
        Map<String, Double> minMonth = sortByValue(months);
        for (Map.Entry<String, Double> month : minMonth.entrySet()) { 
            if (order == 0) {
                minMonthPrice = month.getKey();
            }
            order++;
            maxMonthPrice = month.getKey();
        }        
        info[4] = "En az harcama "+ minMonthPrice + " ayında yapılmış";
        info[5] = "En fazla harcama "+ maxMonthPrice + " ayında yapılmış";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_UrunTablo = new javax.swing.JTable();
        jLabel1_GunlerinHarcamaTutarı = new javax.swing.JLabel();
        jLabel2_AylarınHarcamaTutarı = new javax.swing.JLabel();
        jLabel3_KategorilerinHarcamaTutarı = new javax.swing.JLabel();
        jScrollPane2_GunlerinHarctamaToplam = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3_AylarınHarcamaToplam = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4_KategoriHarcamaToplam = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton1_SecilenGünlerinToplamı = new javax.swing.JButton();
        jButton4_SecilenAylarınToplamı = new javax.swing.JButton();
        jButton5_SecilenKategoriToplam = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1_ToplamFiyat = new javax.swing.JLabel();
        jLabel2_MaxGun = new javax.swing.JLabel();
        jLabel3_Haftasonu = new javax.swing.JLabel();
        jLabel4_MaxToplamFiyat = new javax.swing.JLabel();
        jLabel5_MinToplamFiyat = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1_UrunTablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "İŞLEM NO", "TARİH", "KATEGORİ", "TUTAR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
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
        jScrollPane1.setViewportView(jTable1_UrunTablo);
        if (jTable1_UrunTablo.getColumnModel().getColumnCount() > 0) {
            jTable1_UrunTablo.getColumnModel().getColumn(0).setResizable(false);
            jTable1_UrunTablo.getColumnModel().getColumn(1).setResizable(false);
            jTable1_UrunTablo.getColumnModel().getColumn(2).setResizable(false);
            jTable1_UrunTablo.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1_GunlerinHarcamaTutarı.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1_GunlerinHarcamaTutarı.setText("Günlerin Harcama Tutarı");

        jLabel2_AylarınHarcamaTutarı.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2_AylarınHarcamaTutarı.setText("Ayların Harcama Tutarı");

        jLabel3_KategorilerinHarcamaTutarı.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3_KategorilerinHarcamaTutarı.setText("Kategorilerin Harcama Tutarı");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Günler", "Toplam"
            }
        ));
        jScrollPane2_GunlerinHarctamaToplam.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Aylar", "Toplam"
            }
        ));
        jScrollPane3_AylarınHarcamaToplam.setViewportView(jTable3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kategori", "Toplam"
            }
        ));
        jScrollPane4_KategoriHarcamaToplam.setViewportView(jTable4);

        jButton1_SecilenGünlerinToplamı.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1_SecilenGünlerinToplamı.setText("Seçilen Günlerin Toplamı");
        jButton1_SecilenGünlerinToplamı.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_SecilenGünlerinToplamıActionPerformed(evt);
            }
        });

        jButton4_SecilenAylarınToplamı.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton4_SecilenAylarınToplamı.setText("Seçilen Ayların Toplamı");
        jButton4_SecilenAylarınToplamı.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_SecilenAylarınToplamıActionPerformed(evt);
            }
        });

        jButton5_SecilenKategoriToplam.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton5_SecilenKategoriToplam.setText("Seçilen Kategorilerin Toplamı");
        jButton5_SecilenKategoriToplam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5_SecilenKategoriToplamActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1_ToplamFiyat.setText("Haftaiçi daha fazla harcama yapılmış");

        jLabel2_MaxGun.setText("Toplam Harcama Tutarı: 41920.590000000004");

        jLabel3_Haftasonu.setText("En fazla harcama \"Makarna\" kategorisine ait");

        jLabel4_MaxToplamFiyat.setText("En az harcama \"İçecek\" kategorisine ait");

        jLabel5_MinToplamFiyat.setText("En fazla harcama \"Nisan\" ayında yapılmış");

        jLabel1.setText("En az harcama \"Aralık\" ayında yapılmış");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1_ToplamFiyat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4_MaxToplamFiyat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3_Haftasonu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2_MaxGun, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5_MinToplamFiyat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1_ToplamFiyat, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2_MaxGun)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3_Haftasonu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4_MaxToplamFiyat)
                .addGap(13, 13, 13)
                .addComponent(jLabel5_MinToplamFiyat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2_GunlerinHarctamaToplam, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3_AylarınHarcamaToplam, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4_SecilenAylarınToplamı, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4_KategoriHarcamaToplam, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton5_SecilenKategoriToplam, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1_GunlerinHarcamaTutarı, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(321, 321, 321)
                                .addComponent(jLabel2_AylarınHarcamaTutarı, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1_SecilenGünlerinToplamı, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3_KategorilerinHarcamaTutarı, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1_GunlerinHarcamaTutarı)
                    .addComponent(jLabel2_AylarınHarcamaTutarı, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3_KategorilerinHarcamaTutarı, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2_GunlerinHarctamaToplam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jScrollPane3_AylarınHarcamaToplam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4_KategoriHarcamaToplam, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1_SecilenGünlerinToplamı, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4_SecilenAylarınToplamı)
                    .addComponent(jButton5_SecilenKategoriToplam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4_SecilenAylarınToplamıActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_SecilenAylarınToplamıActionPerformed

        int[] selected_row = jTable3.getSelectedRows();
        if (selected_row.length > 1) {
            double total = 0;
            String months = "";
            for (int i = 0; i < selected_row.length; i++) {
                total += (Double) jTable3.getValueAt(selected_row[i], 1);
                months += "\n-> "+jTable3.getValueAt(selected_row[i], 0).toString();
            }
            JOptionPane.showMessageDialog(this, "Seçilen aylar :"+months +"\nToplam Tutar : " + total);
        } else {
            JOptionPane.showMessageDialog(this, "Lütfen en az 2 adet ay seçiniz");
        }
    }//GEN-LAST:event_jButton4_SecilenAylarınToplamıActionPerformed

    private void jButton5_SecilenKategoriToplamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5_SecilenKategoriToplamActionPerformed

        int[] selected_row = jTable4.getSelectedRows();
        if (selected_row.length > 1) {
            double total = 0;
            String categories = "";
            for (int i = 0; i < selected_row.length; i++) {
                total += (Double) jTable4.getValueAt(selected_row[i], 1);
                categories += "\n-> "+jTable4.getValueAt(selected_row[i], 0).toString();
            }
            JOptionPane.showMessageDialog(this, "Seçilen kategoriler :"+categories +"\nToplam Tutar : " + total);
        } else {
            JOptionPane.showMessageDialog(this, "Lütfen en az 2 adet kategori seçiniz");
        }
    }//GEN-LAST:event_jButton5_SecilenKategoriToplamActionPerformed

    private void jButton1_SecilenGünlerinToplamıActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_SecilenGünlerinToplamıActionPerformed
 
        int[] selected_row = jTable2.getSelectedRows();
        if (selected_row.length > 1) {
            double total = 0;
            String days = "";
            for (int i = 0; i < selected_row.length; i++) {
                total += (Double) jTable2.getValueAt(selected_row[i], 1);
                days += "\n-> "+jTable2.getValueAt(selected_row[i], 0).toString();
            }
            JOptionPane.showMessageDialog(this, "Seçilen günler :"+days +"\nToplam Tutar : " + total);
        } else {
            JOptionPane.showMessageDialog(this, "Lütfen en az 2 adet gün seçiniz");
        }
    }//GEN-LAST:event_jButton1_SecilenGünlerinToplamıActionPerformed

    
          
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JavaTablo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JavaTablo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JavaTablo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JavaTablo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(() -> {
            new JavaTablo().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_SecilenGünlerinToplamı;
    private javax.swing.JButton jButton4_SecilenAylarınToplamı;
    private javax.swing.JButton jButton5_SecilenKategoriToplam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1_GunlerinHarcamaTutarı;
    private javax.swing.JLabel jLabel1_ToplamFiyat;
    private javax.swing.JLabel jLabel2_AylarınHarcamaTutarı;
    private javax.swing.JLabel jLabel2_MaxGun;
    private javax.swing.JLabel jLabel3_Haftasonu;
    private javax.swing.JLabel jLabel3_KategorilerinHarcamaTutarı;
    private javax.swing.JLabel jLabel4_MaxToplamFiyat;
    private javax.swing.JLabel jLabel5_MinToplamFiyat;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2_GunlerinHarctamaToplam;
    private javax.swing.JScrollPane jScrollPane3_AylarınHarcamaToplam;
    private javax.swing.JScrollPane jScrollPane4_KategoriHarcamaToplam;
    private javax.swing.JTable jTable1_UrunTablo;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    // End of variables declaration//GEN-END:variables


   }