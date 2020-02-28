
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.System.exit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class NewJFrame extends javax.swing.JFrame implements ItemListener,ActionListener{
    
    public NewJFrame() {
        initComponents(); 
    jScrollPane3.getViewport().setBackground(new Color(0,0,0,0));
    jScrollPane3.setOpaque(false);

    ((DefaultTableCellRenderer)jTable1.getDefaultRenderer(Object.class)).setOpaque(false);
    //jScrollPane3.getViewport().setOpaque(false);
    jTable1.setFont(new Font(Font.SERIF, Font.PLAIN, 12));
    jTable1.setShowGrid(true);
    jTable1.setBackground(Color.WHITE);
    jLabel2.setBackground(new java.awt.Color(255,255,255));
    choice1.addItemListener(this);
    jXDatePicker1.addActionListener(this);
    
            }
    
    String selectedName=null;
    String selectedDate=null;
    database db=new database();
    int stateCheck1,stateCheck2,stateCheck3=0;
    String text=null;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        choice1 = new java.awt.Choice();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jButton5 = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GUİ");
        setPreferredSize(new java.awt.Dimension(915, 600));

        jButton1.setText("Bilgileri Getir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "İşletme Adı", "Fiş No", "Tarih", "Saat", "Ürünler", "Toplam KDV", "Toplam Fiyat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("                 Resim seçilmedi");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("                     Okunan Metin ");

        jButton2.setText("Resim Seç");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Kaydet");
        jButton3.setMaximumSize(new java.awt.Dimension(105, 29));
        jButton3.setMinimumSize(new java.awt.Dimension(105, 29));
        jButton3.setPreferredSize(new java.awt.Dimension(105, 29));
        jButton3.setRequestFocusEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("        Tarih:");

        jLabel4.setText("İşletme Adı:");

        choice1.setMinimumSize(new java.awt.Dimension(115, 28));

        jLabel5.setText("        Arama Filtreleri");

        jButton4.setText("Uygula");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setText("    Sıralama Kriterleri");

        jCheckBox1.setText("Tarihleri büyükten küçüğe sırala");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Tarihleri küçükten büyüğe sırala");

        jCheckBox3.setText("Alfabeye göre sırala");

        jButton5.setText("Uygula");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton4))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(100, 100, 100))
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addGap(60, 60, 60)))
                .addComponent(jButton1)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("picLabel");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        db.isletmeAdlari();
        ResultSet myRes=db.read();
        addTable(myRes);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        final JFileChooser choose=new JFileChooser();
        /*FileNameExtensionFilter filter= new FileNameExtensionFilter("jpg","jpeg");
        choose.setFileFilter(filter);*/
        
        FileNameExtensionFilter filter=new FileNameExtensionFilter("jpg","png","jfif","jpeg");
        choose.addChoosableFileFilter(filter);
        choose.setAcceptAllFileFilterUsed(true);
        int returnValue= choose.showOpenDialog(choose);
        String path=null;
        if(returnValue == JFileChooser.APPROVE_OPTION){
            path=choose.getSelectedFile().getAbsolutePath();
            ImageOperation img=new ImageOperation();
            text=img.selectImage(path);
        } else {
            choose.remove(choose);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(text != null){
          Split parcala=new Split();
          String parse[]=parcala.parcala(text);
          db.insert(parse);
          text=null;
        } else {
            JOptionPane.showMessageDialog(this,"Öncelikle resim seçmelisiniz.");
        }
        this.addChoice();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if(selectedName=="Seçiniz"){
            selectedName=null;}
        
        if(selectedName != null && selectedDate==null){
            ResultSet result=db.isimArama(selectedName);
            addTable(result);
        }
        
        if(selectedDate != null && selectedName==null){
            ResultSet result=db.tarihArama(selectedDate);
            addTable(result);
        }
        if(selectedDate != null && selectedName != null){
            ResultSet result=db.Arama(selectedName,selectedDate);
            addTable(result);
        }
        
        jXDatePicker1.getEditor().setText("");
        selectedDate=null;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

     public void stateChanged(){
        jCheckBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() ==ItemEvent.SELECTED) {
                      stateCheck1=1;
                } else {
                    stateCheck1=0;
                }
            }
        });
        
        jCheckBox2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    stateCheck2=1;
                } else {
                    stateCheck2=0;
                }
            }
        });
        
        jCheckBox3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    stateCheck3=1;
                } else {
                    stateCheck3=0;
                }
            }
        });
    }
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        stateChanged();
        
        if(stateCheck1==1 && stateCheck2==0){
            if(selectedName==null){
            ResultSet result=db.tarihSiralaBuyuktenKucuge();
            addTable(result);
            } else {
               ResultSet result=db.isimliTarihBuyuktenKucuge(selectedName);
                addTable(result); 
            }
           
        } else if(stateCheck1==0 && stateCheck2==1){
            if(selectedName==null){
           ResultSet result=db.tarihSiralaKucuktenBuyuge();
           addTable(result); 
            }
            else{
                ResultSet result=db.isimliTarihKucuktenBuyuge(selectedName);
                addTable(result);
            }
            
        } else if(stateCheck1==1 && stateCheck2==1){
            JOptionPane.showMessageDialog(this,"Tarih kriterlerinden sadece birini seçebilirsiniz.");
        } else if(stateCheck3==1 && stateCheck1==0 && stateCheck2==0){
            ResultSet result=db.alfabetikSırala();
            addTable(result);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        
        JTable table= (JTable) evt.getSource();
        Point point= evt.getPoint();
        int row= table.rowAtPoint(point);
        int column=table.columnAtPoint(point);
        
        if(evt.getClickCount()==2 && table.getSelectedColumn() != -1 && table.getSelectedRow() != -1){
            if(table.getSelectedColumn()==0 || table.getSelectedColumn()==4){
            String s=jTable1.getValueAt(table.getSelectedRow(),table.getSelectedColumn()).toString();
            String array[]=urunParcala(s);
            JOptionPane.showMessageDialog(this,array);
            }
        }
    }//GEN-LAST:event_jTable1MousePressed

    public static void main(String args[]) throws IOException {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    
    public void setImage(ImageIcon icon){
        Image img=icon.getImage();
        Image img2=img.getScaledInstance(jLabel1.getWidth(),jLabel1.getHeight(),Image.SCALE_SMOOTH);
        jLabel1.setIcon(new ImageIcon(img2));
    }
    
    public void setText(String str){
        this.jLabel2.setText(str);
        jLabel2.setFont(new Font("Serif", Font.PLAIN, 9));
    }
    
    public void addChoice(){
        choice1.removeAll();
        ResultSet result=db.isletmeAdlari();
        choice1.add("Seçiniz");
        try{
        while(result.next()){
            choice1.add(result.getString("firmaAdi"));
        }  
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void addTable(ResultSet result){
        DefaultTableModel model1= (DefaultTableModel) jTable1.getModel();
        model1.getDataVector().removeAllElements();
        model1.fireTableDataChanged();
         String row[]=new String[8];
        try {
        
            while(result.next()){
                row[0]=result.getString("firmaAdi");
                row[1]=result.getString("fisNo");
                row[2]=result.getString("tarih");
                row[3]=result.getString("saat");
                row[4]=result.getString("urunler");
                row[5]=result.getString("toplamKdv");
                row[6]=result.getString("toplamFiyat");
                DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
                model.addRow(row);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choice1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void itemStateChanged(ItemEvent e) {
        selectedName=choice1.getSelectedItem();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        selectedDate=jXDatePicker1.getDate().toString();
        String array[]=new String[6];
        array=selectedDate.split(" ");
        
        switch(array[1]){
            case "Jan": array[1]="01";
                break;
            case "Feb": array[1]="02";
                break;
            case "Mar": array[1]="03";
                break;
            case "Apr": array[1]="04";
                break;
            case "May": array[1]="05";
                break;
            case "Jun": array[1]="06";
                break;
            case "Jul": array[1]="07";
                break;
            case "Aug": array[1]="08";
                break;
            case "Sep": array[1]="09";
                break;
            case "Oct": array[1]="10";
                break;
            case "Nov": array[1]="11";
                break;
            case "Dec": array[1]="12";
                break;
        }
        selectedDate=array[2]+"/"+array[1]+"/"+array[5];
    }
    
    public static String[] urunParcala(String urunler){
        
         String array[]=urunler.split("\\{");
           
           for(int i=0;i<array.length;i++){
              array[i]=array[i].replace("}","");
           }
          return array; 
    }

}
