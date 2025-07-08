import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {
    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            var curso = new Curso();

            System.out.print("Insira o título do Curso: ");
            curso.setTitulo(scanner.nextLine());

            System.out.print("Insira a descrição do Curso: ");
            curso.setDescricao(scanner.nextLine());

            System.out.print("Insira a carga horária do Curso (em horas): ");
            curso.setCargaHoraria(scanner.nextInt());

            System.out.println(curso);

            var mentoria = new Mentoria();

            System.out.print("Insira o título da Mentoria: ");
            mentoria.setTitulo(scanner.nextLine());

            System.out.print("Insira a descrição da Mentoria: ");
            mentoria.setDescricao(scanner.nextLine());

            System.out.print("Insira a data da Mentoria no formato dd/mm/yyyy: ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            mentoria.setData(LocalDate.parse(scanner.next(), formatter));

            System.out.println(mentoria);
        }
    }
}
