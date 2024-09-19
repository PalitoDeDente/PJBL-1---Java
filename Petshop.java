	import java.util.ArrayList;
	import java.util.Scanner;
	
	public class Petshop{
		static Scanner leitor = new Scanner (System.in);

		//LISTA DE TUTORES
		private static ArrayList<Tutor> tutor = new ArrayList<Tutor>(); // Lista de tutores
		public static void popularCadastro() {
			 Tutor t; // Objeto contribuinte.
			 // Adiciona contribuinte 1 com dependentes e imóvel.
			 int codTutor = geraCodCont(); // Cria código sequencial inicando em 1.
			 t=new Tutor("Thaynara Simioni",10,1,2024,"Rua Rio Guaporé, 630", codTutor);
			 t.incluiPet("Lilica","Cachorro");
			 t.incluiPet("Fejão","Cachorro");
			 tutor.add(t);
			 System.out.println(t.getnomeTutor()+": cadastrado.");
			 // Adiciona contribuinte 1 com dependentes e imóvel.
			 codTutor = geraCodCont(); // Cria código sequencial inicando em 1.
			 t=new Tutor("Renan Lima",5,3,2007,"Rua Luiza Baldão Borata, 48", codTutor);
			 t.incluiPet("Minnie","Cachorro");
			 t.incluiPet("Pretinha","Gato");
			 t.incluiPet("Nami","Gato");
			 tutor.add(t);
			 System.out.println(t.getnomeTutor()+": cadastrado.");
			 codTutor = geraCodCont(); // Cria código sequencial inicando em 1.
			 t=new Tutor("Vinicius Ferreira",9,9,2001,"Rua Vinicius Guilherme, 666", codTutor);
			 t.incluiPet("Vini","Cachorro");
			 tutor.add(t);
			 System.out.println(t.getnomeTutor()+": cadastrado.");
			 codTutor = geraCodCont(); // Cria código sequencial inicando em 1.
			 t=new Tutor("Guilherme",9,5,1887,"Chique Xique, 27", codTutor);
			 tutor.add(t);
			 System.out.println(t.getnomeTutor()+": cadastrado.");
			 
			 }

		public static int geraCodCont(){ // Gera código p/ contribuinte. // CREIO EU QUE DE PRA REUTILIZAR TUDO ISSO AI PRO CONTADOR :P
			 if (tutor.size()==0)
				 return 1;
			 else // Incrementa o código do contribuinte no final da lista.
				 return tutor.get(tutor.size()-1).getCod()+1;
		}

		public static void cadTutorPets() {
			Scanner cad = new Scanner (System.in);
		    int dia=1, mes=1, ano=1;
		    String ender;
		    String nomePet = "";
		    String tipoPet;
		    String nomeTutor = "";

		    do {
		        System.out.println("Digite o nome do Tutor (vazio encerra cadastro tutor): ");
		        nomeTutor = cad.nextLine();
		        if (nomeTutor.equals("")) {
		            break; // Sai do loop se o nome do tutor estiver vazio
		        }
		        boolean dataValida = false;
		        do {
		            try {
		                System.out.println("Digite dia (dd), mês (mm) e ano (aaaa) de nascimento do tutor (separados por espaços):");
		                String dataNascimento = cad.nextLine();
		                String[] partesData = dataNascimento.split(" ");
						//Verifica se tem campos suficientes
						if (partesData.length != 3) {
							System.out.println("Entrada inválida: por favor, insira o dia, mês e ano separados por espaços.");
							continue; // Reinicia o loop se o número de partes estiver incorreto
						}

		                dia = Integer.parseInt(partesData[0]);
		                mes = Integer.parseInt(partesData[1]);
		                ano = Integer.parseInt(partesData[2]);

		                // Verifica se a data é válida antes de continuar
		                if (Tutor.valiData(dia, mes, ano)) {
		                    dataValida = true;
		                }

						//Verifica o formato das entradas
					} catch (NumberFormatException e) {
		                System.out.println("Erro de formato: por favor, insira números válidos.");
		            }
		        } while (!dataValida); // Continua até que uma data válida seja inserida
		        
		        do{
					System.out.println("Digite endereço do tutor/pet:");
					ender = cad.nextLine();
					if (ender.equals("")) {
						System.out.println("Campo de endereço vazio!");
					}
				}while(ender.equals(""));

		        int codTutor = geraCodCont();
		        Tutor t = new Tutor(nomeTutor, dia, mes, ano, ender, codTutor);

		        do {
		            System.out.println("Digite nome do pet (vazio encerra cadastro pet): ");
		            nomePet = cad.nextLine();
		            if (nomePet.equals("")) {
		                break; // Sai do loop se o nome do pet estiver vazio
		            }

		            System.out.println("Digite tipo do pet:");
		            tipoPet = cad.nextLine(); // Use nextLine para pegar a string inteira

		            t.incluiPet(nomePet, tipoPet);
		            System.out.println("--- Pet cadastrado ---");
		        } while (!nomePet.equals(""));

		        tutor.add(t); // Adiciona o tutor à lista de tutores
		        System.out.println("--- Tutor cadastrado ---");
		    } while (!nomeTutor.equals(""));
		}


		public static void imprimiCad() {
			System.out.println("\n--- CADASTRO DE TUTORES E PETS ------------------------------------------------------\n");
			if (tutor.size()==0) {
				System.out.println("Não existem tutores cadastrados.");
			}
			for (Tutor t:tutor)
				System.out.println(t.toString()+"\n"); // precisar criar um toString no Tutor, creio que vai ter que criar um toString no Pets também pra formatar
			System.out.println("------------------------------------------------------------------------------\n");
		}

		public static void buscarPets() {
			Scanner tela = new Scanner (System.in);

			if(tutor.size()==0) {
				System.out.println("Não existem tutores cadastrados.");
			}else{
				System.out.println("Digite código do tutor a ser localizado: ");
				double numLeitor = tela.nextDouble();
				boolean tutorEncontrado = false;
				for (Tutor t : tutor) {
					if (t.getCod() == numLeitor) {
						System.out.println(t.toString());
						tutorEncontrado = true;
						break; // Interrompe o loop após encontrar o tutor
					}
				}

				if (!tutorEncontrado) {
					System.out.println("Nenhum tutor com o código " + numLeitor + " encontrado.");
				}

			}	
		}
		public static void excluiPets(){
			Scanner screen = new Scanner (System.in);

			if(tutor.size()==0) {
				System.out.println("Não existem tutores cadastrados.");
			}else{
				System.out.println("Código do tutor a ser excluido: ");
				double numLeitor = screen.nextDouble();
				boolean tutorEncontrado = false;
				for (Tutor t : tutor) {
					if (t.getCod() == numLeitor) {
						tutor.remove(t);
						System.out.println("--- Tutor (+pets) com código " + numLeitor + " excluído com sucesso! ---");
						tutorEncontrado = true;
						break; // Interrompe o loop após encontrar e remover o tutor
					}
				}

				if (!tutorEncontrado) {
					System.out.println("Nenhum tutor com o código " + numLeitor + " encontrado.");
				}

			}		
		}
		public static void main(String[] args){	
			popularCadastro();
		    String opcao = "y";
			while (!opcao.equals("x")) {
		          System.out.println("\n--- Menu ---");
		          System.out.println("c. Cadastrar tutor + pet(s)");
		          System.out.println("i. imprimir cadastro");
		          System.out.println("b. buscar pets por codigo tutor");
		          System.out.println("e. excluir pets ");
		          System.out.println("x. encerrar");
		          System.out.print("Opção escolhida: ");
		          opcao = leitor.nextLine();
		          
		          switch (opcao) {
		             case "c":
		                cadTutorPets();
		                break;
		             case "i":
		                imprimiCad();
		                break;
		             case "b":
		                buscarPets();
		                break;
		             case "e":
		                excluiPets();
		                break;
		             case "x":
		                System.out.println("\n--- Programa de cadastro encerrado ---");
		                break;
		             default:
		                System.out.println("Opção inválida! Tente novamente.");
		          }
			}
		}
	}
	

