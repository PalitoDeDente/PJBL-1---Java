public class Pet{
   //Atributos da classe 
   private String nomePet;
   private String tipoPet;
   //metodo contrutor
   public Pet(String nomePet, String tipoPet){
      this.nomePet = nomePet;
      this.tipoPet = tipoPet; 
   }
   public String getnomePet(){
   return nomePet;
   }
   public String gettipoPet(){
   return tipoPet;
   }
}