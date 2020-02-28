
import java.awt.Color;
import java.io.File;
import javax.swing.ImageIcon;
import net.sourceforge.tess4j.Tesseract; 
import net.sourceforge.tess4j.TesseractException; 
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgcodecs.Imgcodecs.imwrite;
import org.opencv.imgproc.Imgproc;
import static org.opencv.imgproc.Imgproc.INTER_AREA;
import static org.opencv.imgproc.Imgproc.cvtColor;
import static org.opencv.imgproc.Imgproc.equalizeHist;
import static org.opencv.imgproc.Imgproc.resize;


public class ImageOperation {
    
    String text=null;
    
      private static Tesseract getTesseract(){
        Tesseract instance=new Tesseract();
        instance.setDatapath("C:\\Users\\berkehan\\Downloads\\tessdata");
        instance.setLanguage("tur");
        return instance;
    }
    
    
    public String selectImage(String path){
        Tesseract tesseract= getTesseract();
        nu.pattern.OpenCV.loadShared();
        
         try {     
            /*Mat dst=new Mat();
            Mat origin=imread(path);
            cvtColor(origin,dst,Imgproc.COLOR_BGR2GRAY);
            imwrite("gray.png",dst);*/
            
            Mat resizeimage1=new Mat();
            Size scaleSize=new Size(300,340);
            Mat origin=imread(path);
            resize(origin,resizeimage1,scaleSize,0,0,INTER_AREA);
            imwrite("gosterilecek1.png",resizeimage1);

            NewJFrame frame= NewClass.frame;
            ImageIcon icon = new ImageIcon("gosterilecek1.png");
            frame.setImage(icon);
            
            Mat dst = new Mat();
            Mat dst13 = new Mat();
            Mat dest = new Mat();
            Mat destler = new Mat();
            Mat dst2 = new Mat();
            Mat dst3 = new Mat();
            Mat dst4 = new Mat();
            Mat dst5 = new Mat();
            Mat dst6 = new Mat();
            Mat resizeimage = new Mat();
            Mat resizeimage3 = new Mat();
            Mat resizeimage4 = new Mat();
            Mat resizeimage2 = new Mat();// resim resizelama 
   //Size scaleSize = new Size(1300,800);//resim resizelama
   //resize(origin, resizeimage, scaleSize , 0, 0, INTER_AREA);
      
   // Rect roi = new Rect(0, 0 , 900, 100);//resim kesme
   // Mat cropped = new Mat(resizeimage, roi);//resim kesme
   // imwrite("gray.png", cropped);
                
 /*  Imgproc.GaussianBlur(origin, dest,new Size(0,0), 10);
   Core.addWeighted(origin, 1.5, dest, -0.5, 0, dest);
    Imgproc.GaussianBlur(dest, dst,new Size(0,0), 10);
   Core.addWeighted(dest, 1.5, dst, -0.5, 0, dst);
     Imgproc.GaussianBlur(dst, dst2,new Size(0,0), 10);
   Core.addWeighted(dst, 1.5, dst2, -0.5, 0, dst2);
     Imgproc.GaussianBlur(dst2, resizeimage,new Size(0,0), 10);
   Core.addWeighted(dst2, 1.5, resizeimage, -0.5, 0, resizeimage);
    Imgproc.GaussianBlur(resizeimage, dst3,new Size(0,0), 10);
   Core.addWeighted(resizeimage, 1.5, dst3, -0.5, 0, dst3);
       
	Imgproc.threshold(dst3,resizeimage2,55,255,Imgproc.THRESH_BINARY);
        //Imgproc.Canny(resizeimage2, resizeimage2, 10, 100);
           int boy,en;
           boy=(int) (resizeimage2.height()*1.2);
           en= (int) (resizeimage2.width()*1.2);
           int top, bottom, left, right;
         int borderType;
       Size scaleSize2 = new Size(boy,en);//resim resizelama
        resize(resizeimage2, resizeimage2, scaleSize2 , 0, 0, INTER_AREA);
        Imgproc.pyrUp(resizeimage2, resizeimage2, new Size(resizeimage2.cols()*2,  resizeimage2.rows()*2));
        //Imgproc.cvtColor(resizeimage2, resizeimage2, Imgproc.COLOR_BGR2GRAY); */ 
           
 
        Imgproc.GaussianBlur(origin, dest, new Size(0, 0), 10); 
         Core.addWeighted(origin, 1.5, dest, -0.5, 0, dest);
             
      Imgproc.GaussianBlur(dest, dst2, new Size(0, 0), 10); 
         Core.addWeighted(dest, 1.5, dst2, -0.5, 0, dst2);
          Imgproc.GaussianBlur(dst2, dst3, new Size(0, 0), 10); 
         Core.addWeighted(dst2, 1.5, dst3, -0.5, 0, dst3);
         Imgproc.cvtColor(dst3, resizeimage2, Imgproc.COLOR_BGR2GRAY);
         
         equalizeHist( resizeimage2, dst5 );
        Imgproc.threshold(dst5,dst6,10,255,Imgproc.THRESH_BINARY);
        System.out.println(origin.width()+""+origin.height());
        
         Size scaleSize2 = new Size(origin.width()*1.2,origin.height()*1.2);//resim resizelama
        resize(dst6, resizeimage, scaleSize2 , 0, 0, INTER_AREA);
        System.out.println(resizeimage.width()+""+resizeimage.height());
         imwrite("gray.png", resizeimage); 

      //imwrite("gray.png", resizeimage2);
                
            text = tesseract.doOCR(new File("gray.png")); 
            text=text.toUpperCase();
            frame.setText("<html>"+text.replaceAll("\n", "<br/>")+"<html>");
            text.replaceAll("<br/>","\n");
             System.out.println(text);
            return text;
         
        } 
        catch (TesseractException e) { 
            e.printStackTrace(); 
        }   return text;
 }
    }
    