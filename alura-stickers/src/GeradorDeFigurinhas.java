import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {
    
    

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
        // leitura da imagem 
        // InputStream ip = new FileInputStream(new File("media/filme.jpg"));
        // InputStream ip = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_5.jpg").openStream();
        BufferedImage original = ImageIO.read(inputStream);    
    
        
        // criar nova img em memoria com transparência e com novo tamanho
        int largura = original.getWidth();
        int altura = original.getHeight();

        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);


        // copiar a img org para novo img (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(original, 0, 0, null);

        // configurar fonte
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 72);
        graphics.setColor(Color.GREEN);
        graphics.setFont(font);

        // escrever uma frase na nova img
        String frase = "BOMMMDIMAIS";
        int x = 100;
        int y = 100;

        graphics.drawString(frase, x , novaAltura - y);

        // escrever a nova img em arquivo

        ImageIO.write(novaImagem, "png", new File("media/"+nomeArquivo));
    }
}

