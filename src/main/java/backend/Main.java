package backend;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- A INICIAR TESTE DE BACKEND ---");

        // 1. Instanciar o Gestor
        GestorPassatempos gestor = new GestorPassatempos();

        // 2. Tentar carregar dados antigos (se existirem)
        gestor.carregarDados();

        if (gestor.getLista().isEmpty()) {
            System.out.println("Nenhum dado encontrado. A criar novos...");

            // 3. Criar dados de teste
            Leitura livro = new Leitura("O Senhor dos Anéis", "Tolkien", 25.50);

            // Adicionar uma sessão de leitura (ontem, 60 minutos)
            Sessao sessao1 = new Sessao(LocalDate.now().minusDays(1), 60, "Li o primeiro capítulo");
            livro.adicionarSessao(sessao1);

            // Adicionar ao gestor
            gestor.adicionarPassatempo(livro);

            System.out.println("Passatempo adicionado: " + livro.getNome());
        } else {
            System.out.println("Dados carregados com sucesso!");
            System.out.println("Passatempos registados: " + gestor.getLista().size());

            for (Passatempo p : gestor.getLista()) {
                System.out.println("- " + p.getNome() + " (Histórico: " + p.getHistorico().size() + " sessões)");
                if (p instanceof Monetizavel) {
                    System.out.println("  Custo: " + ((Monetizavel) p).getCusto() + " " + ((Monetizavel) p).getMoeda());
                }
            }
        }

        // 4. Guardar tudo
        gestor.guardarDados();
        System.out.println("--- FIM DO TESTE ---");
    }
}