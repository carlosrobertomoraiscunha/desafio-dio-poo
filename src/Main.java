import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(final String[] args) {
        try (var scanner = new Scanner(System.in)) {
            final List<Bootcamp> bootcamps = new ArrayList<>();
            final List<Dev> devs = new ArrayList<>();
            int opcaoSelecionada = -1;

            do {
                System.out.println("1 - Criar um bootcamp.");
                System.out.println("2 - Detalhar um bootcamp.");
                System.out.println("3 - Criar um curso em um bootcamp.");
                System.out.println("4 - Criar uma mentoria em um bootcamp.");
                System.out.println("5 - Criar um dev.");
                System.out.println("6 - Detalhar um dev.");
                System.out.println("7 - Inscrever um dev em um bootcamp.");
                System.out.println("8 - Progredir o dev nos seus conteúdos.");
                System.out.println("0 - Sair do programa.");

                opcaoSelecionada = scanner.nextInt();
                scanner.nextLine(); // flush

                switch (opcaoSelecionada) {
                    case 0 -> System.out.println("Encerrando o programa...");
                    case 1 -> bootcamps.add(criarBootcamp(scanner));
                    case 2 -> detalharBootcamp(scanner, bootcamps);
                    case 3 -> criarCursoEmBootcamp(scanner, bootcamps);
                    case 4 -> criarMentoriaEmBootcamp(scanner, bootcamps);
                    case 5 -> devs.add(criarDev(scanner));
                    case 6 -> detalharDev(scanner, devs);
                    case 7 -> inscreverDevEmBootcamp(scanner, bootcamps, devs);
                    case 8 -> progredirDev(scanner, devs);
                    default -> System.out.println("Opção não permitida!");
                }
            } while (opcaoSelecionada != 0);
        }
    }

    private static Bootcamp criarBootcamp(final Scanner scanner) {
        final var bootcamp = new Bootcamp();

        System.out.print("Insira o nome do Bootcamp: ");
        bootcamp.setNome(scanner.nextLine());

        System.out.print("Insira a descrição do Bootcamp: ");
        bootcamp.setDescricao(scanner.nextLine());

        System.out.format("O bootcamp %s foi criado com sucesso!\n", bootcamp.getNome());

        return bootcamp;
    }

    private static void detalharBootcamp(Scanner scanner, List<Bootcamp> bootcamps) {
        if (bootcamps.isEmpty()) {
            System.out.println("Não há bootcamps cadastrados!");
        } else {
            final var bootcamp = selecionarBootcamp(scanner, bootcamps);

            System.out.println("===========Bootcamp===========");
            System.out.format("Nome: %s\n", bootcamp.getNome());
            System.out.format("Descrição: %s\n", bootcamp.getDescricao());
            System.out.format("Data Inicial: %s\n", bootcamp.getDataInicial().format(formatter));
            System.out.format("Data Final: %s\n", bootcamp.getDataFinal().format(formatter));
            System.out.format("Devs Inscritos: %s\n", bootcamp.getDevsInscritos().stream().map(Dev::getNome).toList());
            System.out.format("Conteúdos: [");
            imprimirConteudos(bootcamp.getConteudos());
            System.out.format("]\n");
            System.out.println("==============================");
        }
    }

    private static void imprimirConteudos(final Collection<Conteudo> conteudos) {
        conteudos.forEach(conteudo -> {
            StringBuilder sb = new StringBuilder();

            if (conteudo instanceof Curso) {
                Curso curso = (Curso) conteudo;

                sb.append("\n\t").append(conteudo.getClass().getSimpleName()).append(" {\n");
                sb.append("\t\tTítulo: ").append(curso.getTitulo()).append("\n");
                sb.append("\t\tDescrição: ").append(curso.getDescricao()).append("\n");
                sb.append("\t\tCarga Horária: ").append(curso.getCargaHoraria()).append("\n");
                sb.append("\t\tXp: ").append(curso.calcularXp()).append("\n");
                sb.append("\t}");
            } else if (conteudo instanceof Mentoria) {
                Mentoria mentoria = (Mentoria) conteudo;

                sb.append("\n\t").append(conteudo.getClass().getSimpleName()).append(" {\n");
                sb.append("\t\tTítulo: ").append(mentoria.getTitulo()).append("\n");
                sb.append("\t\tDescrição: ").append(mentoria.getDescricao()).append("\n");
                sb.append("\t\tData: ").append(mentoria.getData().format(formatter)).append("\n");
                sb.append("\t\tXp: ").append(mentoria.calcularXp()).append("\n");
                sb.append("\t}");
            }

            System.out.println(sb.toString());
        });
    }

    private static Bootcamp selecionarBootcamp(final Scanner scanner, final List<Bootcamp> bootcamps) {
        int indexBootcamp;

        while (true) {
            System.out.println("Selecione o bootcamp de sua escolha:");

            for (int i = 0; i < bootcamps.size(); i++) {
                System.out.println((i + 1) + " - " + bootcamps.get(i).getNome());
            }

            indexBootcamp = scanner.nextInt();
            scanner.nextLine(); // flush

            if (indexBootcamp > 0 && indexBootcamp <= bootcamps.size())
                break;
            else
                System.out.println("Bootcamp inválido!");
        }

        return bootcamps.get(indexBootcamp - 1);
    }

    private static void criarCursoEmBootcamp(final Scanner scanner, List<Bootcamp> bootcamps) {
        if (bootcamps.isEmpty()) {
            System.out.println("Não há bootcamps cadastrados!");
        } else {
            final var bootcamp = selecionarBootcamp(scanner, bootcamps);
            final var curso = new Curso();

            System.out.print("Insira o título do Curso: ");
            curso.setTitulo(scanner.nextLine());

            System.out.print("Insira a descrição do Curso: ");
            curso.setDescricao(scanner.nextLine());

            System.out.print("Insira a carga horária do Curso (em horas): ");
            curso.setCargaHoraria(scanner.nextInt());
            scanner.nextLine(); // flush

            bootcamp.getConteudos().add(curso);

            System.out.format("O curso %s foi criado no bootcamp %s.\n", curso.getTitulo(), bootcamp.getNome());
        }
    }

    private static void criarMentoriaEmBootcamp(final Scanner scanner, List<Bootcamp> bootcamps) {
        if (bootcamps.isEmpty()) {
            System.out.println("Não há bootcamps cadastrados!");
        } else {
            final var bootcamp = selecionarBootcamp(scanner, bootcamps);
            final var mentoria = new Mentoria();

            System.out.print("Insira o título da Mentoria: ");
            mentoria.setTitulo(scanner.nextLine());

            System.out.print("Insira a descrição da Mentoria: ");
            mentoria.setDescricao(scanner.nextLine());

            System.out.print("Insira a data da Mentoria no formato dd/mm/yyyy: ");
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            mentoria.setData(LocalDate.parse(scanner.next(), formatter));

            bootcamp.getConteudos().add(mentoria);

            System.out.format("A mentoria %s foi criada no bootcamp %s.\n", mentoria.getTitulo(), bootcamp.getNome());
        }
    }

    private static Dev criarDev(final Scanner scanner) {
        final var dev = new Dev();

        System.out.print("Insira o nome do Dev: ");
        dev.setNome(scanner.nextLine());

        System.out.format("O dev %s foi criado com sucesso!\n", dev.getNome());

        return dev;
    }

    private static void detalharDev(Scanner scanner, List<Dev> devs) {
        if (devs.isEmpty()) {
            System.out.println("Não há devs cadastrados!");
        } else {
            final var dev = selecionarDev(scanner, devs);

            System.out.println("===========Dev===========");
            System.out.format("Nome: %s\n", dev.getNome());
            System.out.format("Conteúdos Inscritos: [");
            imprimirConteudos(dev.getConteudosInscritos());
            System.out.format("]\n");
            System.out.format("Conteúdos Concluídos: [");
            imprimirConteudos(dev.getConteudosConcluidos());
            System.out.format("]\n");
            System.out.format("XP Total: %.2f\n", dev.calcularXpTotal());
            System.out.println("=========================");
        }
    }

    private static Dev selecionarDev(final Scanner scanner, final List<Dev> devs) {
        int indexBootcamp;

        while (true) {
            System.out.println("Selecione o dev de sua escolha:");

            for (int i = 0; i < devs.size(); i++) {
                System.out.println((i + 1) + " - " + devs.get(i).getNome());
            }

            indexBootcamp = scanner.nextInt();
            scanner.nextLine(); // flush

            if (indexBootcamp > 0 && indexBootcamp <= devs.size())
                break;
            else
                System.out.println("Dev inválido!");
        }

        return devs.get(indexBootcamp - 1);
    }

    private static void inscreverDevEmBootcamp(Scanner scanner, List<Bootcamp> bootcamps, List<Dev> devs) {
        if (bootcamps.isEmpty()) {
            System.out.println("Não há bootcamps cadastrados!");
        } else if (devs.isEmpty()) {
            System.out.println("Não há devs cadastrados!");
        } else {
            final var bootcamp = selecionarBootcamp(scanner, bootcamps);
            final var dev = selecionarDev(scanner, devs);

            if (bootcamp.getDevsInscritos().contains(dev)) {
                System.out.format("O dev %s já está inscrito no bootcamp %s.\n", dev.getNome(), bootcamp.getNome());
                return;
            }

            dev.inscreverBootcamp(bootcamp);
            System.out.format("O dev %s foi inscrito no bootcamp %s.\n", dev.getNome(), bootcamp.getNome());
        }
    }

    private static void progredirDev(Scanner scanner, List<Dev> devs) {
        if (devs.isEmpty()) {
            System.out.println("Não há devs cadastrados!");
        } else {
            final var dev = selecionarDev(scanner, devs);
            var conteudo = dev.progredir();

            if (conteudo != null)
                System.out.format("O dev %s concluiu o %s de título %s.\n", dev.getNome(),
                        conteudo.getClass().getSimpleName(), conteudo.getTitulo());
            else
                System.err.format("O dev %s não está matriculado em nenhum conteúdo!\n", dev.getNome());
        }
    }
}