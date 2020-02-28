
import org.apache.commons.lang.ArrayUtils;


public class Split {
    
static String parse[]=new String[7];
static boolean fisNo=false;
static boolean saat=false;

    static String isimArama[]={"A.Ş","A.S","4.S","LTD","A Ş"};
    static String tarihArama[]={"TARIH","TARİH","TARİM","TARİ","TARI"};
    static String fisNoArama[]={"FİŞ NO","FİS NO","FIS NO","FIŞ NO","FİŞ NÜ","FIŞ NU","Fİ$ NO","FI$ NO"};
    static String saatArama[]={"SAAT","SART","SAT"};
    static String toplamKdvArama[]={"TOPKDV","TOPKDY","TOPKOV","TOPLAM KDV"};
    static String toplamArama[]={"TOPLAM"};
    static String urunArama[]={"*","X","#","&","%"};
    static String noktalama[]={":",";","."};
    static String tarih[]={":",";",".",","};
   
    
    public String[] parcala(String text){
        
       
       String dizi[]=null;
       boolean varMi=false;
       fisNo=false;
       saat=false;
       int index=-1;
       parse[4]=null;
       
       String remove[]={"—","|","<",">","|","“","”","'"};
      
       for(int i=0;i<remove.length;i++){
           text=text.replace(remove[i],"");
       }
       
       text=text.replace(";",":");
       text=text.replace("$","Ş");
       
       
       dizi=text.split("\n");
          for(int i=0;i<dizi.length;i++){ //gerekmeyen satırları bulmak
           if(dizi[i].contains("TOPLAM")){
               index=i;
               break;
           }
       }
          
          if(index != -1){ //kullanmayacağın satırları silme
              while(index+1<dizi.length){
                  dizi=removeString(dizi,index+1);
              }
              index=-1;
              }
            
           for(int i=0;i<dizi.length;i++){ // ismi ayırma
               for(int j=0;j<isimArama.length;j++){
                if(dizi[i].contains(isimArama[j])){
                    isimBulma(dizi[i],isimArama[j]);
                    index=i;
                    varMi=true;
                    break;
                }
                }
               if(index != -1){
                   i=dizi.length;
               }
           }
           
           
           if(varMi==false){ //A.Ş veya LTD ŞTİ yazmıyorsa ismi alma
               
               if(dizi[0].isEmpty()){
                 parse[0]=dizi[1];
                 index=1;
               }else{
                parse[0]=dizi[0];   
                index=0;
               }
               
           }
           
           if(index != -1){ //isim olan satırı sil
                 dizi=removeString(dizi,index);
                  index=-1;
           }
           
                   
          varMi=false;
           for(int i=0;i<dizi.length;i++){ // tarih ayırma
               for(int j=0;j<tarihArama.length;j++){
                if(dizi[i].contains(tarihArama[j])){
                    fisNo=fisNoVarMi(dizi[i]);
                    saat=saatVarMi(dizi[i]);
                    tarihBulma(dizi[i],tarihArama[j]);
                    index=i;
                    varMi=true;
                    break;
                }
                }
           }
           
           
            if(index != -1){ //tarihi bulduğum satırı sil
                 dizi=removeString(dizi,index);
                  index=-1;
           }
            
            if(saat == false){
            for(int i=0;i<dizi.length;i++){ // saat ayırma
               for(int j=0;j<saatArama.length;j++){
                if(dizi[i].contains(saatArama[j])){
                    saatBulma(dizi[i],saatArama[j]);
                    index=i;
                    break;
                }
                }
            }
           }
            
            if(index != -1){ //saati bulduğum bulduğum satırı sil
                 dizi=removeString(dizi,index);
                  index=-1;
           }
            
            
           if(fisNo == false){
            for(int i=0;i<dizi.length;i++){ // fisNo ayırma
               for(int j=0;j<fisNoArama.length;j++){
                if(dizi[i].contains(fisNoArama[j])){
                    fisNoBulma(dizi[i],fisNoArama[j]);
                    index=i;
                    break;
                }
                }
            }
            
             if(index != -1){ //fiş no bulduğum satırı sil
                  dizi=removeString(dizi,index);
                  index=-1;
           }
           }
           
           for(int i=0;i<dizi.length;i++){ // topkanjdv ayırma
               for(int j=0;j<toplamKdvArama.length;j++){
                if(dizi[i].contains(toplamKdvArama[j])){
                    toplamKdvBulma(dizi[i],toplamKdvArama[j]);
                    index=i;
                    break;
                }
                
               }}
               
            if(index != -1){ //toplamKDV bulduğum satırı sil
                  dizi=removeString(dizi,index);
                  index=-1;
           }
            
          for(int i=0;i<dizi.length;i++){ // toplam ayırma
               for(int j=0;j<toplamArama.length;j++){
                if(dizi[i].contains(toplamArama[j])){
                    toplamBulma(dizi[i],toplamArama[j]);
                    index=i;
                    break;
                }
                }
          }
               
            if(index != -1){ //toplam bulduğum satırı sil
                  dizi=removeString(dizi,index);
                  index=-1;
           }
            
             for(int i=0;i<dizi.length;i++){ // ürün arama ayırma
               for(int j=0;j<urunArama.length;j++){
                if(dizi[i].contains(urunArama[j])){
                    urunBulma(dizi[i]);
                    index=i;
                    
                }
                }
          }
             
              if(parse[1]==null){
                     parse[1]="00/00/0000";
                 }
             
             for(int i=0;i<parse.length;i++){
                   if(parse[i]==null){
                     parse[i]="Bulunamadı.";
                 }
             }
          
             
           return parse;
    }
             
    public static void isimBulma(String s,String bolunecek){
        
        String array[]=s.split(bolunecek);
        parse[0]=array[0]+bolunecek;
    }
    
     public static void tarihBulma(String s,String bolunecek){
         
         for(int i=0;i<noktalama.length;i++){
             if(i != noktalama.length-1){
            s= s.replaceFirst(noktalama[i],"");
             }
         }
        
        String array[]=s.split(bolunecek);
        if(fisNo==true){
             for(int j=0;j<fisNoArama.length;j++){
                if(array[1].contains(fisNoArama[j])){
                  bolunecek=fisNoArama[j];
                  break;
                }
             }
             
            array=array[1].split(bolunecek);
            array[0]=replaceSlash(array[0]);
            array[1]=array[1].substring(1);
            parse[1]=tarihYapisiDuzelt(array[0]);;
            parse[3]=array[1];
            
        } else if(saat==true){
            for(int j=0;j<saatArama.length;j++){
                if(array[1].contains(saatArama[j])){
                  bolunecek=saatArama[j];
                  break;
                }
             }
            array=array[1].split(bolunecek);
            array[0]=replaceSlash(array[0]);
            parse[1]=tarihYapisiDuzelt(array[0]);
            array[1]=array[1].replace(" ","");
            array[1]=array[1].substring(1);
            parse[2]=array[1];
        } else {
         array=array[1].split(bolunecek);
         array[0]=replaceSlash(array[0]);
         parse[1]=tarihYapisiDuzelt(array[0]);
         
        }
    }
     
     public static boolean fisNoVarMi(String s){
         
         for(int i=0;i<fisNoArama.length;i++){
             if(s.contains(fisNoArama[i])){
                 return true;
             }
         }   
         return false;
     }
     
      public static boolean saatVarMi(String s){
         
         for(int i=0;i<saatArama.length;i++){
             if(s.contains(saatArama[i])){
                 return true;
             }
         }   
         return false;
     }
      
      public static void saatBulma(String s,String bolunecek){
        s=s.replaceAll("\\s+","");
        s=s.replace("  ","");
        String array[]=s.split(bolunecek);
        
        array[1]=array[1].substring(1);
        array[1]=saatDuzelt(array[1]);
        parse[2]=array[1];
    }
      
      public static void fisNoBulma(String s,String bolunecek){
        s=s.replace("  ","");
        s=s.replace("\\s+","");
        String array[]=s.split(bolunecek);
        for(int i=0;i<noktalama.length;i++){
            array[1]= array[1].replace(noktalama[i],"");
         }
        array[1]=fisNoDuzelt(array[1]);
        
        parse[3]=array[1];
    }
      
        public static void toplamKdvBulma(String s,String bolunecek){
        s=s.replace("  ","");
        s=s.replaceAll("\\s+","");
        String array[]=s.split(bolunecek);
        array[1]=toplamKdvDuzelt(array[1]);
        
        parse[5]=array[1];
    }
        
       public static void toplamBulma(String s,String bolunecek){
        s=s.replace("  ","");
        s=s.replaceAll("\\s+","");
        String array[]=s.split(bolunecek);
        array[1]=toplamFiyatDuzelt(array[1]);
        parse[6]=array[1];
    }
       
       public static void urunBulma(String s){
           if(parse[4]==null){
        parse[4]="{"+s+"}";
           } else {
        parse[4]=parse[4]+"{"+s+"}";
    }
       }
       
       public static String[] removeString(String [] array,int index){
          array= (String[]) ArrayUtils.remove(array,index);
          return array;
       }
       
       public static String replaceSlash(String s){
          
           for(int i=0;i<tarih.length;i++){
                if(s.contains(tarih[i])){
                   s=s.replace(tarih[i],"/");
                }
            }
           
           s=s.replaceAll("\\s+","");
           s=s.replace("  ","");
           return s;
       }
       
       public static String tarihYapisiDuzelt(String s){
           
           if(s.contains("/")){
           String array[]=s.split("/");
               System.out.println(array.length);
           
           if(array.length==3){
               if(array[0].length()==2 && array[1].length()==2 && array[2].length()==4){
                   return s;
               } else{
                   s="00/00/0000";
                   return s;
               } 
           } else{
                   s="00/00/0000";
                   return s;
               } 
           }
           return s;
       }
       public static String toplamKdvDuzelt(String s ){
           String k = s.replaceAll("[^.,0-9]", "");
           
           System.out.println(k);
           return k;
       }
       public static String toplamFiyatDuzelt(String s ){
           String k = s.replaceAll("[^.,0-9]", "");
           
           System.out.println(k);
           return k;
       }
        public static String saatDuzelt(String s ){
           String k = s.replaceAll("[^:0-9]", "");
           
           System.out.println(k);
           return k;
       }
        public static String fisNoDuzelt(String s ){
           String k = s.replaceAll("[^0-9]", "");
           
           System.out.println(k);
           return k;
       }
}
