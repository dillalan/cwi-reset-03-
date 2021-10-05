
public class Registradora {

    public static void main(String[] args) {
        System.out.println("bug1");
        primeiroBug();

//        System.out.println("Estoque Disponível:");
//        System.out.println("Pão: "+ItensPorQuantidade.getPao());
//        System.out.println("Sanduíche: "+ItensPorQuantidade.getSanduiche());
//        System.out.println("Torta: "+ItensPorQuantidade.getTorta());
//        System.out.println("Café: "+ItensPorQuantidade.getCafe());
//        System.out.println("Leite: "+ItensPorQuantidade.getLeite()+"\n -----------");

        System.out.println("bug2");
        segundoBug();

//        System.out.println("Estoque Disponível:");
//        System.out.println("Pão: "+ItensPorQuantidade.getPao());
//        System.out.println("Sanduíche: "+ItensPorQuantidade.getSanduiche());
//        System.out.println("Torta: "+ItensPorQuantidade.getTorta());
//        System.out.println("Café: "+ItensPorQuantidade.getCafe());
//        System.out.println("Leite: "+ItensPorQuantidade.getLeite()+"\n -----------");

        System.out.println("bug3");
        terceiroBug();

//        System.out.println("Estoque Disponível:");
//        System.out.println("Pão: "+ItensPorQuantidade.getPao());
//        System.out.println("Sanduíche: "+ItensPorQuantidade.getSanduiche());
//        System.out.println("Torta: "+ItensPorQuantidade.getTorta());
//        System.out.println("Café: "+ItensPorQuantidade.getCafe());
//        System.out.println("Leite: "+ItensPorQuantidade.getLeite()+"\n -----------");

        System.out.println("bug4");
//        quartoBug();
//
//        System.out.println("Estoque Disponível:");
//        System.out.println("Pão: "+ItensPorQuantidade.getPao());
//        System.out.println("Sanduíche: "+ItensPorQuantidade.getSanduiche());
//        System.out.println("Torta: "+ItensPorQuantidade.getTorta());
//        System.out.println("Café: "+ItensPorQuantidade.getCafe());
//        System.out.println("Leite: "+ItensPorQuantidade.getLeite()+"\n -----------");

//        quintoBug();
//
//        sextoBug();
    }

    private static double registrarItem(String item, int quantidade) {
        double precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);
        String[] itens = {"pao", "sanduiche", "torta", "leite", "cafe"};
        for (String produto:
             itens) {
            if (QuantidadeMinimaItem.precisaReposicao(produto)) {
                if ("pao".equals(produto) || "sanduiche".equals(produto) || "torta".equals(produto)) {
                    if (!DataProjeto.cozinhaEmFuncionamento()) {
                        System.out.println("Cozinha fechada!\n -----------");
                        System.out.println("Estoque Disponível:");
                        System.out.println("Pão: "+ItensPorQuantidade.getPao());
                        System.out.println("Sanduíche: "+ItensPorQuantidade.getSanduiche());
                        System.out.println("Torta: "+ItensPorQuantidade.getTorta()+"\n -----------");
                    } else {
                        ReposicaoCozinha.reporItem(produto);
                    }
                } else if ("leite".equals(produto) || "cafe".equals(produto)){
                    ReposicaoFornecedor.reporItem(produto);
                }
            }
        }
        return precoItem;
    }

    private static void primeiroBug() {
        /*
        A string enviada para resgistrarItem é 'sanduiche' e causando falha ao ser comparada com 'sanduba'
        A desambiguação do termo corrige o defeito(sanduiche==sanduiche)
         */
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "sanduiche";
        int quantidade = 4;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void segundoBug() {
        /*
        A expressão de calculo de precoTotal para o item torta é divisão de inteiros que gera um resultado
        inteiro de ZERO. Corrigido com a transformação para double.
         */
        DataProjeto.criarDataComCozinhaEncerradaMasComDiaUtil();
        String item = "torta";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void terceiroBug() {
        /*
        Diferença de strings para o objeto item de valor 'café. A desambiguação do termo corrige o
        defeito(cafe==cafe)
         */
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "cafe";
        int quantidade = 40;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void quartoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        System.out.println(String.format("Valor total: %.2f", precoTotal2));
    }

    private static void quintoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "pao";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void sextoBug() {
        DataProjeto.criarDataComCozinhaEncerradaSemDiaUtil();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        System.out.println(String.format("Valor total: %.2f", precoTotal2));
    }

}
