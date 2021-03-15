import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

public class AsciiArtGenerator {

    //:D
    public void introMessage() throws InterruptedException {
        int width = 100;
        int height = 21;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("SansSerif", Font.BOLD,20));

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.drawString("$ ATM $", 5, 18);

        for(int y = 0; y< height; y++) {
            StringBuilder sb = new StringBuilder();

            Thread.sleep(80);

            for(int x = 0; x < width; x++) {
                sb.append(image.getRGB(x, y) == -16777216 ? "$" : " ");
            }
            System.out.println(sb);

        }
        System.out.println("\n");
    }
//
//    public void intruderMessage() throws InterruptedException {
//        int width = 111;
//        int height = 21;
//
//        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//        Graphics g = image.getGraphics();
//        g.setFont(new Font("SansSerif", Font.BOLD,20));
//
//        Graphics2D g2 = (Graphics2D) g;
//        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//        g2.drawString("Intruder", 5, 18);
//
//        for(int y = 0; y< height; y++) {
//            StringBuilder sb = new StringBuilder();
//
//            Thread.sleep(80);
//
//            for(int x = 0; x < width; x++) {
//                sb.append(image.getRGB(x, y) == -16777216 ? "$" : " ");
//            }
//            System.out.println(sb);
//
//        }
//        Thread.sleep(200);
//        System.out.println("\n");
//    }
}
