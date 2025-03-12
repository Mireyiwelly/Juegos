import java.util.ArrayList;
import java.util.Scanner;

public class Ahorcado
{
        private Scanner sc;
        private char [] palabra;
        private char [] guiones;
        private String palabraUsuario, letra;
        private int vidas = 6;
        private boolean correcta;
        private boolean victoria;
        private boolean letrasValidas;
        private ArrayList<Character> repes;

        public void IniciarAhorcado()
        {
            sc = new Scanner(System.in); // Inicialización del scanner
            vidas = 6;
            correcta = false; 
            victoria = false;
            repes = new ArrayList<>();
        do
        {
            if(!letrasValidas)
            System.out.println("Los caráceteres introducidos no son válidos");
            
            System.out.println("Introduce la palabra a adivinar:");
            palabraUsuario = sc.nextLine().toLowerCase();  //usuario introduce la palabra para jugar
            letrasValidas = true;  

            for(int i = 0; i < palabraUsuario.length(); i++) // Introducimos las letras en la array
            if( palabraUsuario.charAt(i) < 'a' || palabraUsuario.charAt(i) > 'z')
                letrasValidas = false;

            else palabra[i] = palabraUsuario.charAt(i);
        }   
        while(!letrasValidas);
        for (int i = 0; i < palabraUsuario.length(); i++) // Creamos otra array con tantos guiones como letras tenga la palabra
        {
            if(palabraUsuario.charAt(i) != ' ')
            guiones [i] = ('_');    

            else guiones[i] = ' ';
        }
           
            
        System.out.println(); //espacio
        
        do
        {
            System.out.println(guiones); //Mostramos los guiones
            System.out.println("Vidas restantes: " + vidas); //Imprimir vidas
            correcta = false;
            System.out.print("Introduce la letra:  ");
            letra = sc.nextLine().toLowerCase();

            if(repes.contains(letra.charAt(0)) ) //Si la letra está repetida salta este mensaje
            {
                System.out.println("Ya has introducido esta letra");
                correcta = true;
            }
            else
            {
                for(int k = 0; k< palabraUsuario.length(); k++) //Buscar si la letra está en la palabra
                {
                    if(palabra[k] == letra.charAt(0)) //Si la letra introducida por el usuario está, se cambiarán los guiones por la letra introducida en dicha posición
                    {
                        guiones[k] = palabra[k];
                        correcta = true;
                        repes.add(letra.charAt(0)); //guardamos letra para evitar repetirla
                    }
                  
                }
            }
            if(!correcta) //Si la letra introducida no es correcta, se le quitará una vida.
            {
                System.out.println("Caray! La letra " + letra + " no está en la palabra que buscas :(");
                vidas--;
                System.out.println();
            } 
           if(new String(guiones, 0, palabraUsuario.length()).equals(palabraUsuario))//Recorremos la palabra para ver si es correcta
            victoria = true;

            else victoria = false;

        }
        while ( (vidas > 0) && !victoria ); //Con esto saldriamos del bucle
        if (victoria)
            System.out.println("\nHAS GANADO! ENHORABUENA :D");
        else
        {
            System.out.println("Has perdido :(");
            System.out.println("La palabra era: ");
            for(int i = 0; i < palabraUsuario.length(); i++) 
            {
                System.out.print(palabra[i]);
            }
            System.out.println();
        }
        sc.close();    
    }
}
