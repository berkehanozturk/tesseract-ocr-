import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class database {
    
    Connection myCon=null;
    Statement stm=null;
    ResultSet myRes=null;
    String user;
    String password;
  
    
    public void connection(){
        
        try {
           user="root";
           password="Can172199400";
           myCon= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/yazlab",user,password);
           stm=myCon.createStatement(); 
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
    
    public  ResultSet read(){
      try {  
           connection();      
           myRes=stm.executeQuery("select * from sirketler,fisler where sirketler.id=fisler.id");
           return myRes;
           
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void insert(String[] s){
       try {  
           connection();
           PreparedStatement statment= myCon.prepareStatement("insert into sirketler(firmaAdi,fisNo,tarih,saat) values(?,?,?,?)");
           statment.setString(1,s[0]);
           statment.setString(2,s[3]);
           statment.setString(3,s[1]);
           statment.setString(4,s[2]);
           statment.executeUpdate();
           
           myRes=stm.executeQuery("select id from sirketler where sirketler.fisNo='"+s[3]+"'");
     
           statment=null;
           statment= myCon.prepareStatement("insert into fisler values(?,?,?,?)");
           while(myRes.next()){
           statment.setString(1,myRes.getString("id"));
           }
           statment.setString(2,s[4]);
           statment.setString(3,s[5]);
           statment.setString(4,s[6]);
           statment.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet isletmeAdlari(){
        try {  
           connection(); 
           myRes=stm.executeQuery("select distinct firmaAdi from sirketler");
           return myRes;
           
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet isimArama(String name){
        try {  
           connection();
           myRes=stm.executeQuery("select * from sirketler,fisler where sirketler.firmaAdi='"+name+"' and sirketler.id=fisler.id;");
           
           return myRes;
           
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public ResultSet tarihArama(String date){
        try {  
           connection();
           myRes=stm.executeQuery("select * from sirketler,fisler where sirketler.tarih='"+date+"' and sirketler.id=fisler.id;");
           
           return myRes;
           
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet Arama(String name,String date){
    try {  
           connection();
           myRes=stm.executeQuery("select * from sirketler,fisler where sirketler.tarih='"+date+"' and sirketler.firmaAdi='"+name+"' and sirketler.id=fisler.id;");
           return myRes;
           
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;    
    }
    
    
    public ResultSet tarihSiralaBuyuktenKucuge(){
        try {  
           connection();
           myRes=stm.executeQuery("SELECT * FROM sirketler,fisler where sirketler.id=fisler.id order by STR_TO_DATE(sirketler.tarih, '%d/%m/%Y')  desc");
           return myRes;
           
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;   
    }
    
    public ResultSet tarihSiralaKucuktenBuyuge(){
        try {  
           connection();
           myRes=stm.executeQuery("SELECT * FROM sirketler,fisler where sirketler.id=fisler.id order by STR_TO_DATE(sirketler.tarih, '%d/%m/%Y')  asc");
           return myRes;
           
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;   
    }
    
    public ResultSet alfabetikSırala(){
        try {  
           connection();
           myRes=stm.executeQuery("SELECT * FROM sirketler,fisler where sirketler.id=fisler.id order by sirketler.firmaAdi asc");
           return myRes;
           
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet isimliTarihBuyuktenKucuge(String name){
       try {  
           connection();
           myRes=stm.executeQuery("SELECT * FROM sirketler,fisler where sirketler.id=fisler.id and sirketler.firmaAdi='"+name+"'order by STR_TO_DATE(sirketler.tarih, '%d/%m/%Y')  desc");
           return myRes;
           
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; 
        
    }
    
    
    public ResultSet isimliTarihKucuktenBuyuge(String name){
       try {  
           connection();
           myRes=stm.executeQuery("SELECT * FROM sirketler,fisler where sirketler.id=fisler.id and sirketler.firmaAdi='"+name+"'order by STR_TO_DATE(sirketler.tarih, '%d/%m/%Y')  asc");
           return myRes;
           
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; 
        
    }
}