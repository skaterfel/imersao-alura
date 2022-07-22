import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // fazer uma conexao HTTP e buscar o top 250 filmes
        // String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        // ExtratorDeConteudoDaNasa extrator = new ExtratorDeConteudoDaNasa();
        String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);
     
        
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradorDeFigurinhas = new GeradorDeFigurinhas();
        //exibir os dados
        for (int i = 0; i < 3; i++) {
            Conteudo conteudo = conteudos.get(i); 
          
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();

            String nomeDoArquivo = conteudo.getTitulo().replace(":", "-") + ".png";

            
            geradorDeFigurinhas.cria(inputStream, nomeDoArquivo);




            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
}
