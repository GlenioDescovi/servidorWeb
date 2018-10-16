package reserva.servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Glenio on 11/10/2018.
 */


public class RequisicaoHTTP {


    private String protocolo;
    private String recurso;
    private String metodo;
    private boolean manterViva = true;
    private int tempoLimite = 3000;
    private Map<String, List<String>> cabecalhos;

    public static RequisicaoHTTP lerRequisicao(InputStream entrada) throws IOException {
        RequisicaoHTTP requisicao = new RequisicaoHTTP();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
        /* Lê a primeira linha
         contem as informaçoes da requisição
         */
        String linhaRequisicao = buffer.readLine();
        System.out.println("linha:"+linhaRequisicao);
        //quebra a string pelo espaço em branco
        String[] dadosReq = linhaRequisicao.split(" ");

        //pega o metodo
        requisicao.setMetodo(dadosReq[0]);

        //paga o caminho do arquivo
        requisicao.setRecurso(dadosReq[1]);

        //pega o protocolo
        requisicao.setProtocolo(dadosReq[2]);

        String dadosHeader = buffer.readLine();

        //Enquanto a linha nao for nula e nao for vazia
        while (dadosHeader != null && !dadosHeader.isEmpty()) {
            //System.out.println(dadosHeader);
            String[] linhaCabecalho = dadosHeader.split(":");
            requisicao.setCabecalho(linhaCabecalho[0], linhaCabecalho[1].trim().split(","));
            dadosHeader = buffer.readLine();
        }
        //se existir a chave Connection no cabeçalho
        if (requisicao.getCabecalhos().containsKey("Connection")) {
            //seta o manterviva a conexao se o connection for keep-alive
            requisicao.setManterViva(requisicao.getCabecalhos().get("Connection").get(0).equals("keep-alive"));
        }
        return requisicao;
    }

    public void setCabecalho(String chave, String... valores) {
        if (cabecalhos == null) {
            cabecalhos = new TreeMap<>();
        }
        cabecalhos.put(chave, Arrays.asList(valores));
    }

    //getters e setters
    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public boolean isManterViva() {
        return manterViva;
    }

    public void setManterViva(boolean manterViva) {
        this.manterViva = manterViva;
    }

    public int getTempoLimite() {
        return tempoLimite;
    }

    public void setTempoLimite(int tempoLimite) {
        this.tempoLimite = tempoLimite;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public String getRecurso() {
        return recurso;
    }

    public String getMetodo() {
        return metodo;
    }

    public Map<String, List<String>> getCabecalhos() {
        return cabecalhos;
    }
}