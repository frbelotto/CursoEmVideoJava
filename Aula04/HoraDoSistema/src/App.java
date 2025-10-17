import java.util.Date;
import java.util.Locale;
import java.awt.*; // Para resolução de tela
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App{
    public static void main(String[] args) throws Exception {
               
        // System.out.println("Hello, World!");
        Date relogio = new Date();
        System.out.println("A hora do sistema é " + relogio.toString()); //Exemplo básico da aula


        //Fazendo testes com captura automática no sistema
        LocalDateTime ldt = LocalDateTime.now();
        Locale sistema = Locale.getDefault();
       
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy 'às' HH:mm", sistema);
        System.out.println("A data formatada é: " + ldt.format(formatter) + "no formato " + sistema.getCountry());
     
        // Exibe hora com java.util.Date
        Date relogionovo = new Date();
        System.out.println("Hora do sistema: " + relogionovo.toString());

        SistemaInfo.exibirIdiomaSistema();
        SistemaInfo.exibirResolucaoTela();

        // Exibe data formatada em BR e US
        LocalDateTime agora = LocalDateTime.now();
        SistemaInfo.exibirDataFormatada(agora, Locale.forLanguageTag("pt-BR"), "d 'de' MMMM 'de' yyyy 'às' HH:mm");
        SistemaInfo.exibirDataFormatada(agora, Locale.forLanguageTag("en-US"), "MMMM d, yyyy 'at' hh:mm a");
    }
}

class SistemaInfo {

    public static void exibirIdiomaSistema() {
        Locale sistema = Locale.getDefault();
        System.out.println("Idioma do sistema: " + sistema.getDisplayLanguage());
        System.out.println("País do sistema: " + sistema.getDisplayCountry());
        System.out.println("Localização completa: " + sistema.getDisplayName());
    }

    public static void exibirResolucaoTela() {
        try {
            Dimension resolucao = Toolkit.getDefaultToolkit().getScreenSize();
            System.out.println("Resolução da tela: " + resolucao.width + " x " + resolucao.height);
        } 
        catch (HeadlessException e) {
            System.out.println(e);
            System.out.println("Ambiente sem interface gráfica. Resolução não disponível.");
        }
    }

public static void exibirDataFormatada(LocalDateTime data, Locale localizacao, String padrao) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(padrao, localizacao);
    String formatado = data.format(formatter);
    System.out.println("Data formatada (" + localizacao.getDisplayName() + "): " + formatado);
}
}