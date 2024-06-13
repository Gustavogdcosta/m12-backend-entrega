package Tarefa_Colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TarefaColecoes {

	private static final String[] String = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tarefa1();
		tarefa2();
	}
	public static void tarefa1() {
		System.out.println("***** TAREFA 1 *****");
		Scanner s = new Scanner(System.in);
		System.out.println("Digite os nomes separando com virgulas (sem espaços, somente virgulas)");
		
		String verifica = s.next(); //armazenando os nomes digitados em na variável "verifica"		
		String[] vetorDeString = verifica.split(","); //convertendo os nomes separados por virgula da variável verifica em elementos para o array vetorDeString
		
		List<String> nomesOrdenados = new ArrayList<>();
		
		
		for (int i=0; i<vetorDeString.length; i++) {
			nomesOrdenados.add(vetorDeString[i]);
			
		}
		System.out.println("Os nomes digitados ordenados, são:");
		Collections.sort(nomesOrdenados);
		System.out.println(nomesOrdenados);
	}
	
	public static void tarefa2() {
		System.out.println("***** TAREFA 2 *****");
		
		String resposta = "sim";
		
		List<String> arrayMulheres = new ArrayList<>();
		List<String> arrayHomens = new ArrayList<>();
		List<String> arrayOutro = new ArrayList<>();
		
		while(resposta.equalsIgnoreCase("sim")) {
			System.out.println("Digite o nome e sexo do aluno separando os dois por hifen, exemplo: aluno1-m ou aluna1-f");
			Scanner b = new Scanner(System.in);
			String recebeNome = b.next();
			String[] primeiroArray = recebeNome.split("-");
			
			Map<String, String> lista = new HashMap<>();
			lista.put(primeiroArray[1], primeiroArray[0]);
			
			Set<Map.Entry<String, String>> entry = lista.entrySet();
			for (Map.Entry<String, String> e: entry ) {
				if (e.getKey().contains("f")) {	
					arrayMulheres.add(e.getValue());
				} 
				else if (e.getKey().contains("m")) {
					arrayHomens.add(e.getValue());
				} else {
					arrayOutro.add(e.getValue());
				}
			}
			
			lista.remove(primeiroArray[1], primeiroArray[0]);
		
			System.out.println("Deseja adicionar mais algum aluno?");
			Scanner s = new Scanner(System.in);
			resposta = s.next();
		}
		
		Collections.sort(arrayHomens);
		Collections.sort(arrayMulheres);
		Collections.sort(arrayOutro);
		System.out.println("** Alunos Homens:  **");
		System.out.println(arrayHomens);
		System.out.println("** Alunas mulheres: **");
		System.out.println(arrayMulheres);
		if (arrayOutro.size() > 0) {
			System.out.println("** Alguns alunos não foram possíveis identificar o sexo, são eles: **");
			System.out.println(arrayOutro);
		}
		
	}
}
