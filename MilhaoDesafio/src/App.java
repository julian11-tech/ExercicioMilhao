
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.HashSet; // Import the HashSet class
import java.io.FileWriter;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.*;
import java.time.LocalDateTime; // import the LocalDate class

public class App {
  
    public static void main(String[] args) {
        
        LocalDateTime dataInicial = LocalDateTime.now();
        System.out.println("Começou!");
        
       HashSet<Integer> lista1 = new HashSet<Integer>();
       
       Random gen = new Random();
       
       while(lista1.size() != 2000000){
           lista1.add(gen.nextInt(5000000));
       }
       
       HashSet<Integer> lista2 = new HashSet<Integer>();
       
       while(lista2.size() != 1000000){
           int num = gen.nextInt(5000000);
           
           if(!lista1.contains(num))
            lista2.add(num);
       }
       
       ArrayList<Integer> valores = new ArrayList<Integer>();
       
       valores.addAll(lista2);
       Collections.sort(valores);
       
       try{
           FileWriter writer = new FileWriter("teste.txt");
           for (Integer num: valores){
                writer.write(num.toString() + "\n");
           }
           writer.close();
           
           LocalDateTime x = LocalDateTime.now().minusSeconds(dataInicial.getSecond());
           
           System.out.println("Deu certo! Tempo-> " + x.getSecond() + " segundos :)");
       }catch(IOException e){
        System.out.println("Não deu certo!\n:(");
         e.printStackTrace();
         
       }
       
    }
    
}
