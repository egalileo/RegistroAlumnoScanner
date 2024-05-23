import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
    int opcion, intentos = 3, cualNota;
    double notas[] = new double[4];
    double nota, promedio, nuevaNota;
    String contrasena = "AA0001", contra, salida;
    boolean salir = false;
    Scanner sc = new Scanner(System.in);
    
    // inicio sesion
    do {
        System.out.println("Ingrese su contrasena, posee "+intentos+" intentos");
        contra = sc.nextLine();

        if(contra.equals(contrasena)){
            System.out.println("Iniciando sesion con exito...");
            intentos = 0;
            salir = false;
        }else{
            intentos--;
            System.out.println("Contrasena incorrecta ...");
            if( intentos == 0){
                System.out.println("Maximo de intentos alcanzado");
                salir  = true; // No le damos permiso de entrar a nuestro sistema
            }
        }

    }while(intentos > 0);


    while( salir == false){ //Menu dinamico iterable
        System.out.println("Bienvenido alumno. Ingrese la opcion que desea\n1. Ingresar notas\n2. Ver notas \n3. Cambiar nota \n4. Promedio \n Cualquier otro para salir");
        opcion = sc.nextInt();

        if(opcion == 1){  // Ingresar nota


            // System.out.println(notas.length);
            for(int i = 0 ; i < notas.length ; i++ ){
                do{ // validar nota
                    System.out.println("Ingrese la nota #"+(i+1));
                    nota = sc.nextDouble();
                }while (nota <0 || nota > 10);
                notas[i] = nota;
            }

        } else if (opcion == 2) { // ver notas

            salida = "";
            salida += "Notas del alumno AA0001\n";
            for(int i = 0 ; i < notas.length ; i++ ){
                salida += "Nota #"+(i+1)+" : "+notas[i]+"\n";
            }
            System.out.println(salida);

        } else if (opcion == 3) { // Cambiar nota
            System.out.println("Ingrese la nota que desea cambiar");
            cualNota = sc.nextInt();
            if(cualNota < 1 || cualNota > 4){
                System.out.println("Error. Ingrese un valor correcto");
            }else{
                // logica del cambio de nota
                do{ // validar nota
                    System.out.println("Ingrese la nueva nota #"+cualNota);
                    nuevaNota = sc.nextDouble();
                }while (nuevaNota <0 || nuevaNota > 10);

                notas[cualNota - 1] = nuevaNota;
                System.out.println("Nota cambiada con exito");
            }
        } else if (opcion == 4) { // Ver promedio
            promedio = 0;
            for(int i = 0 ; i < notas.length ; i++ ){
                promedio += notas[i] ;
            }
            promedio /= 4;
            System.out.println("Promedio del alumno AA0001:"+promedio);
        }else { // salir
            salir  = true;
            System.out.println("... saliendo del sistema");
        }
    }











    }
}