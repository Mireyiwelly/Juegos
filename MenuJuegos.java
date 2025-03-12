import java.util.Scanner;
public class MenuDeJuegos {
    
    public enum Opciones
    {
        AHORCADO, JUEGOX, JUEGOY, JUEGOZ, SALIR
    }
    public static void main(String[] args) {
        Opciones opcionUsuario;
        Scanner sc = new Scanner(System.in);

        do
        {
            System.out.println("1.Jugar al ahorcado");
            System.out.println("2.Jugar a x");
            System.out.println("3.Jugar a y");
            System.out.println("4.Salir");
            Opciones opcion = sc.nextInt();
            switch(opcionUsuario)
            {
                case Opciones.AHORCADO:
                Ahorcado ahorcado = new Ahorcado();
                ahorcado.IniciarAhorcado();
                break;    

                    
                case Opciones.JUEGOX:
                    


                    
                case Opciones.JUEGOY:
                    

                    
                case Opciones.SALIR:
                    System.out.println("Fin del programa");
                    break;
            }
        }
        while(opcionUsuario != Opciones.SALIR);
    }
}
