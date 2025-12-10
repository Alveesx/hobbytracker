package backend;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- TESTE DO BACKEND ---");

        // 1. Criar o Gestor
        GestorPassatempos gestor = new GestorPassatempos();

        // 2. Tentar carregar dados do ficheiro
        gestor.carregarDados();

        // Se a lista estiver vazia, cria dados de exemplo
        if (gestor.getLista().isEmpty()) {
            System.out.println("Lista vazia. A criar dados de exemplo...");

            // CORREÇÃO AQUI: Só Nome e Autor (sem preço)
            Leitura livro = new Leitura("O Senhor dos Aneis", "Tolkien");
            livro.setObjetivoAnualHoras(100);

            // Adicionar uma sessão de teste (ontem, 60 min)
            Sessao s1 = new Sessao(LocalDate.now().minusDays(1), 60, "Li o capitulo 1");
            livro.adicionarSessao(s1);

            // Adicionar ao Gestor
            gestor.adicionarPassatempo(livro);

            System.out.println("Livro criado e adicionado.");
        } else {
            System.out.println("Dados recuperados do ficheiro 'dados.dat'!");
        }

        // 3. Listar o que está na memória
        System.out.println("\n--- MEUS HOBBIES ---");
        for (int i = 0; i < gestor.getLista().size(); i++) {
            Passatempo p = gestor.getLista().get(i);

            System.out.println(p.toString());
            System.out.println("   > Progresso: " + p.getPercentagemConclusao() + "%");
            System.out.println("   > Sessões: " + p.getHistorico().size());
        }

        // 4. Guardar tudo
        gestor.guardarDados();

        System.out.println("--- FIM DO TESTE ---");
    }
}