import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class SalvarTarefas {
    private static final String ARQUIVO_TAREFAS = "tarefas.txt";

    public static void salvarTarefas(ArrayList<Tarefas> tarefas) {
        Path caminho = obterCaminhoArquivo();

        try {
            Path diretorio = caminho.getParent();
            if (diretorio != null && !Files.exists(diretorio)) {
                Files.createDirectories(diretorio);
            }

            try (BufferedWriter writer = Files.newBufferedWriter(caminho, StandardCharsets.UTF_8)) {
                for (Tarefas tarefa : tarefas) {
                    String descricao = tarefa.getDescricao().replace("\\", "\\\\").replace(";", "\\;");
                    writer.write((tarefa.isConcluida() ? "1" : "0") + ";" + descricao);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar tarefas: " + caminho + " -> " + e.getMessage());
        }
    }

    public static ArrayList<Tarefas> carregarTarefas() {
        ArrayList<Tarefas> tarefas = new ArrayList<>();

        for (Path caminho : obterCaminhosPossiveis()) {
            if (!Files.exists(caminho)) {
                continue;
            }

            try (BufferedReader reader = Files.newBufferedReader(caminho, StandardCharsets.UTF_8)) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    if (linha.trim().isEmpty()) {
                        continue;
                    }

                    String[] partes = linha.split(";", 2);
                    if (partes.length < 2) {
                        continue;
                    }

                    boolean concluida = "1".equals(partes[0].trim());
                    String descricao = partes[1].replace("\\;", ";").replace("\\\\", "\\").trim();

                    Tarefas tarefa = new Tarefas(descricao);
                    if (concluida) {
                        tarefa.marcarComoConcluida();
                    }
                    tarefas.add(tarefa);
                }
                return tarefas;
            } catch (IOException e) {
                System.out.println("Erro ao carregar tarefas: " + caminho + " -> " + e.getMessage());
            }
        }

        return tarefas;
    }

    private static Path obterCaminhoArquivo() {
        Path caminhoLocal = Path.of(ARQUIVO_TAREFAS);

        try {
            Files.createFile(caminhoLocal);
            Files.deleteIfExists(caminhoLocal);
            return caminhoLocal;
        } catch (IOException e) {
            Path fallback = Path.of(System.getProperty("user.home"), "GerenciadorTarefas", ARQUIVO_TAREFAS);
            return fallback;
        }
    }

    private static ArrayList<Path> obterCaminhosPossiveis() {
        ArrayList<Path> caminhos = new ArrayList<>();
        caminhos.add(Path.of(ARQUIVO_TAREFAS));
        caminhos.add(Path.of(System.getProperty("user.home"), "GerenciadorTarefas", ARQUIVO_TAREFAS));
        return caminhos;
    }
}
