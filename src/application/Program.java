package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List <Lesson> lesson = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
		System.out.println("\nDados da " + i + "a aula:");
		System.out.print("Conteudo ou tarefa (c/t)? ");
		
		char ch = sc.next().toLowerCase().charAt(0);
		System.out.print("Título: ");
		sc.nextLine();
		String title = sc.nextLine();
		
		if(ch == 'c') {
			System.out.print("Url do vídeo: ");
			String url = sc.nextLine();
			System.out.print("Duração em segundos: ");
			int seconds = sc.nextInt();
			lesson.add(new Video(title, url, seconds));
		} else {
			System.out.print("Descrição: ");
			String descriton = sc.nextLine();
			System.out.print("Quantidade de questões: ");
			int quantity = sc.nextInt();
			lesson.add(new Task(title, descriton, quantity));
		}
		}
		
		int sum =0;
		for (Lesson l : lesson) {
			sum += l.duration();
		}
		System.out.print("\nDURAÇÃO TOTAL DO CURSO = " + sum +" segundos");
		
		sc.close();
	}

}
