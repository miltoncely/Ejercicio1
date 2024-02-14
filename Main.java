import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String SI = "si";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("¡Bienvenido al proceso de pruebas de admisión!");
        System.out.println("Vamos a evaluar sus competencias en el manejo de clases y objetos.");


        System.out.println("¿Tiene experiencia en el manejo de clases y objetos? (Si/No)");
        String respuestaConsulta = reader.readLine();

        if (SI.equalsIgnoreCase(respuestaConsulta.trim())) {
            System.out.println("¡Excelente! Procederemos a la siguiente actividad.");
        } else {
            System.out.println("Le recomendamos estudiar más sobre el manejo de clases y objetos.");
            finalizarProceso();
        }


        System.out.println("Ahora, le pediremos que elabore algunos applets.");


        System.out.println("¿Ha tenido éxito en la elaboración de applets? (Si/No)");
        String respuestaApplets = reader.readLine();

        if (SI.equalsIgnoreCase(respuestaApplets.trim())) {
            System.out.println("¡Bien hecho! Continuaremos con la evaluación de sus habilidades.");
        } else {
            System.out.println("Le recomendamos practicar más en la elaboración de applets.");
            finalizarProceso();
        }
        System.out.println("Felicidades, ha completado las actividades de prueba con éxito. Ahora pasará a la siguiente fase del proceso.");

        finalizarProceso();
    }

    private static void finalizarProceso() {
        System.out.println("Gracias por participar en el proceso de pruebas de admisión. Fin del programa.");
        System.exit(0);
    }
}
