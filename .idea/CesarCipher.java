import java.security.SecureRandom;
import java.util.Scanner;

public class CesarCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al Cifrado César del equipo 0343");
        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1). Cifrar mensaje");
            System.out.println("2). Descifrar mensaje");
            System.out.println("3). Generar clave aleatoria");
            System.out.println("4). Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    cifrarMensaje(scanner);
                    break;
                case 2:
                    descifrarMensaje(scanner);
                    break;
                case 3:
                    generarClaveAleatoria();
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion != 4);

        scanner.close();
    }

    // Método para cifrar un mensaje
    public static void cifrarMensaje(Scanner scanner) {
        System.out.print("Ingrese el mensaje a cifrar: ");
        String mensajeOriginal = scanner.nextLine();

        System.out.print("Ingrese la clave: ");
        int clave = scanner.nextInt();

        scanner.nextLine();

        String mensajeCifrado = cifrarCesar(mensajeOriginal, clave);
        System.out.println("Mensaje Cifrado: " + mensajeCifrado);
    }

    // Método para descifrar un mensaje
    public static void descifrarMensaje(Scanner scanner) {
        System.out.print("Ingrese el mensaje a descifrar: ");
        String mensajeCifrado = scanner.nextLine();

        System.out.print("Ingrese la clave: ");
        int clave = scanner.nextInt();


        scanner.nextLine();

        String mensajeDescifrado = descifrarCesar(mensajeCifrado, clave);
        System.out.println("Mensaje Descifrado: " + mensajeDescifrado);
    }

    // Método para cifrar una cadena usando el cifrado César
    public static String cifrarCesar(String texto, int clave) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);

            // Verifica si el caracter es una letra
            if (Character.isLetter(caracter)) {
                // Obtén el código ASCII del caracter
                int codigoAscii = (int) caracter;

                // Determina si es una letra mayúscula o minúscula
                char base = Character.isUpperCase(caracter) ? 'A' : 'a';

                // Aplica el cifrado César
                char cifrado = (char) ((codigoAscii - base + clave) % 26 + base);

                // Agrega el caracter cifrado al resultado
                resultado.append(cifrado);
            } else {
                // Si no es una letra, agrega el caracter sin cifrar
                resultado.append(caracter);
            }
        }

        return resultado.toString();
    }

    // Método para descifrar una cadena usando el cifrado César
    public static String descifrarCesar(String texto, int clave) {
        // El descifrado es simplemente el cifrado con una clave negativa
        return cifrarCesar(texto, -clave);
    }

    // Método para generar una clave aleatoria
    public static void generarClaveAleatoria() {
        SecureRandom random = new SecureRandom();
        int claveAleatoria = random.nextInt(26);

        System.out.println("Querido legionario, El Cesar ha dicho que " + claveAleatoria + " es nuestra clave. ");
    }
}
