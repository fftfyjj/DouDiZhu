import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jj2000.j2k.image.ImgData;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.Tesseract1;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.vietocr.ImageHelper;


public class Test {

	
	public static void main(String[] args) throws IOException, TesseractException {
//		Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping
        Tesseract1 instance = new Tesseract1(); // JNA Direct Mapping
		File imageFile = new File("imgs/eurotext.png");
        BufferedImage bufferedImage = ImageIO.read(imageFile);
        bufferedImage = ImageHelper.convertImageToGrayscale(bufferedImage);
        bufferedImage = ImageHelper.convertImageToBinary(bufferedImage);
        
        File output = new File("imgs/out.png");
        ImageIO.write(bufferedImage, "png", output);
        String result = instance.doOCR(bufferedImage);
        System.out.println(result);
        
        
//        
//        BufferedImage textImage;
//		try {
//			textImage = ImageIO.read(imageFile);
//			textImage = new BufferedImage(textImage.getWidth(), textImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
//			                                               textImage = ImageHelper.convertImageToBinary(textImage);
//			//textImage = ImageHelper.getScaledInstance(textImage, textImage.getWidth() * 5, textImage.getHeight() * 5);
//			String result = instance.doOCR(textImage);
//            System.out.println(result);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (TesseractException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}                
	}
}
