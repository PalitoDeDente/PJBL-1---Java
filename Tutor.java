package pjbl;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public class Tutor{
   private String nomeTutor;
	private String ender;
	private int cod;
	private LocalDate dataNasc;
	//lista dinamica
	private ArrayList<Pet> pet=new ArrayList<Pet>();
	//metodo Contrutor
	public Tutor(String nomeTutor, int dia, int mes, int ano, String ender, int cod){
		this.nomeTutor = nomeTutor;
        this.ender = ender;
        this.cod = cod;
        this.dataNasc = LocalDate.of(ano,mes,dia);
   }
	public static int getAnoAtual() {
        LocalDate dataSistema = LocalDate.now();
        return dataSistema.getYear();
    }
	public static int getMesAtual() {
        LocalDate dataSistema = LocalDate.now();
        // Retorna o ano atual
        return dataSistema.getMonth().getValue();
    }
	public static int getDiaAtual() {
        LocalDate dataSistema = LocalDate.now();
        // Retorna o ano atual
        return dataSistema.getDayOfMonth();
    }
	
	public static boolean bissexto(int ano) {
	        return (ano % 4 == 0);
	}
	public static boolean valiData(int dia, int mes, int ano) {
	    String e = "Data inválida, tente novamente";
	    if (ano > getAnoAtual()) {
	        System.out.println(e);
	        return false;
	    }
	    
	    // Verifica se o ano é o ano atual
	    if (ano == getAnoAtual()) {
	        // Verifica se o mês é inválido ou maior que o mês atual
	        if (mes > getMesAtual() || mes < 1 || mes > 12) {
		        System.out.println(e);
	            return false;
	        }
	        
	        // Verifica se o mês é o mês atual
	        if (mes == getMesAtual()) {
	            // Verifica se o dia é maior que o dia atual
	            if (dia > getDiaAtual()) {
	    	        System.out.println(e);
	                return false;
	            }
	        }

	        // Verificação do máximo de dias no mês
	        int maxDia;
	        switch (mes) {
	            case 2:
	                maxDia = bissexto(ano) ? 29 : 28;
	                break;
	            case 4: case 6: case 9: case 11:
	                maxDia = 30;
	                break;
	            default:
	                maxDia = 31;
	                break;
	        }

	        // Verifica se o dia é válido para o mês
	        if (dia < 1 || dia > maxDia) {
		        System.out.println(e);
	            return false;
	        }
	    }

	    return true; // Data válida
	}
	public void incluiPet(String nomePet, String tipoPet){
       
       Pet pt = new Pet(nomePet, tipoPet);
       pet.add(pt);
       
   }   
	public String getnomeTutor(){ // n sei se vai precisar honestamente falando
        return nomeTutor; 
   }
	public int getCod(){
		return cod;
	}
//	public String getEnder() {
//		   return ender;
//	   }
	
	public String getDataNasc() {
	   DateTimeFormatter fmt=DateTimeFormatter.ofPattern("dd/MM/yyyy");
	   return dataNasc.format(fmt); //  faz sentido ter esse, pq ele formata a data (teoricamente)
   }
	public int getIdade(){
	   LocalDate dataSistema=LocalDate.now();
	   int idade=Period.between(dataNasc,dataSistema).getYears(); //  esse faz sentido tbm pq ele calculada automatico
	   return idade;
   }

	public String toString(){
	   // *** CADASTRO DE CONTRIBUINTE *** << tem disso, mas ta fora do toString
	   String s = "Cod. do tutor: "+cod+"\n";
	   s+= "  Nome...........: "+nomeTutor+"\n";
	   s+= "  Data de nascimento: "+getDataNasc()+" ("+getIdade()+" anos)\n";
	   s+= "  Endereço.......: "+ender+"\n";
	   s+= "  Relação de Pets:\n";
	   if (pet.size()==0) {
		   s+="  - Pets de "+nomeTutor+": nenhum cadastrado.";
	   }else {
		   for(Pet p:pet)
			   s+="  - Nome do pet: "+p.getnomePet()+"; Tipo: "+p.gettipoPet()+".\n";
	   }   	   
	   return s;  
   }
}
