public class args{
  public static void main(String[] args){
    int numero;
    for(int i = 0; i < args.length; i++){
      numero = Integer.parseInt(args[i]);
      System.out.println(numero*numero);
    } 
  }
}

