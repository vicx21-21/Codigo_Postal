package CP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*codigo que lee documento csv y contea cuantas veces se repiten los codigos postales
Por Victoria Vargas Encinas*/

public class codigoo {
    public static void main(String[] args) {
        //aqui hago un arreglo de 358 de largo ya que son numeros desde 83000 a 83357 entonces son 358}
        //este arreglo es de 2 columnas porque una guarda el codigo postal y el otro la cantidad de veces que se repite
        String [][] codigo =new String [358][2];

        //inicia el arreglo donde i empieza desde 0 ya que es lo que se le ira sumando a 83000 para que todas las posiciones tengan su codigo
         for(int i =0;i<358;i++){
             codigo[i][0]=String.valueOf(83000+i);//aqui se le va sumando para que su i 0 sea el codigo postal
             codigo[i][1]="0";//inicializa la cantidad de repeticiones  de todos los codigos en 0
         }

    try{
        File archivo = new File("codigos_postales_hmo (1).csv");/* aqui creamos un archivo con
                                                                       la direccion de nuestro archivo csv con los cp*/
        Scanner leer = new Scanner(archivo); //scanner que leera el archivo

        while (leer.hasNextLine()){//mientras no llegue al final y siga habiendo renglones
            String linea = leer.nextLine();//guarda la linea completa


        try {
            int cp = Integer.parseInt(linea.substring(0, 5)); // primeros 5 dígitos de la linea  ya que en cada renglos los primeros 5 digitos son el codigo
            int index = cp - 83000; // posición en el arreglo  por ejemplo 830001-83000 pues es posicion 1 osea el index
            codigo[index][1] = String.valueOf(Integer.parseInt(codigo[index][1]) + 1);//aqui se le suma 1 a la repeticion si se vuelve a leer el index
        } catch (NumberFormatException e) {
            // ignorara lineas que no empiezen con numeros
        }

    }
        leer.close();//cierra el scanner

        for(int i =0;i<358;i++){ //imprime el arreglo con codigo postal y cuantas veces se repite
            if (!codigo[i][1].equals("0")){//aqui hace que aparezcan si sus repeticiones son diferentes de 0 ,ya que hay muchos con 0
                System.out.println(codigo[i][0]+" se repite "+codigo[i][1]+" veces. ");
           }
    }


    } catch (FileNotFoundException e) {//por si no se encuentra el archivo
        System.out.println("No se encontró el archivo.");
    }
}
    }


