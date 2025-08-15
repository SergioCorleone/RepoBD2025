import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ContadorCp {
    public static void main(String[] args) {
        //Declarando Strings que ayudaran a poder leer nuestro .csv con BufferedReader
        String RutaArchivo = ".\\codigos_postales_hmo.csv";
        String linea;
        String separador = ",";

        //Creando el TreeMap para almacenar los datos de nuestro archivo
        Map<String, Integer> contadorCp = new TreeMap<>();

        //Hacer uso de un try & chatch debido a que BufferedReader y File Reader son susceptibles a errores
        try(BufferedReader Br= new BufferedReader(new FileReader(RutaArchivo))){
        while ((linea = Br.readLine()) != null) {
            //Separar el texto por su delimitador que es ","
            String[] columnas = linea.split(separador);

            //Limpiar el texto en caso de haber espacios entre , y ,
            String Cp = columnas[0].trim();

            contadorCp.put(Cp, contadorCp.getOrDefault(Cp, 0) + 1);
        }
        }
        //Arrojar error en caso de no contar con algun archivo
        catch (IOException e){
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        //Emplear un for para imprimir todos los datos
        for (Map.Entry<String, Integer> entry : contadorCp.entrySet()) {
            System.out.println("Codigo Postal: " +entry.getKey() + " Numero de asentamientos: " +entry.getValue());
        }
    }
}
