package reserva.log;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

/**
 * Created by Glenio on 17/10/2018.
 */
public class Log {

    static File arquivo;
    static FileReader fileReader;
    static BufferedReader bufferedReader;
    static FileWriter fileWriter;
    static BufferedWriter bufferedWriter;

    private static final Object monitor = new Object();
    private static final ArrayList<String> fila = new ArrayList<>();

    //produtor
    public static void addLog(String a){

        synchronized (monitor){
            System.out.println("ENTRO NO ADD LOG");
            System.out.println(a);
            fila.add(a);
            monitor.notify();
        }
    }

    //consumidor
    public static class Escreve implements Runnable{
        @Override
        public void run(){
            while(true){
                String ip;
                synchronized (monitor){
                    if(fila.isEmpty()){
                        try{
                            monitor.wait();
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    ip = fila.remove(0);
                }try{
                    arquivo = new File("Log.txt");
                    fileReader = new FileReader(arquivo);
                    bufferedReader = new BufferedReader(fileReader);

                    Vector texto = new Vector();

                    while(bufferedReader.ready()){

                        texto.add(bufferedReader.readLine());
                    }

                    fileWriter = new FileWriter(arquivo);
                    bufferedWriter = new BufferedWriter(fileWriter);

                    for(int i=0; i<texto.size(); i++) {

                        bufferedWriter.write(texto.get(i).toString());
                        bufferedWriter.newLine();
                    }

                    bufferedWriter.write("\n" + ip);
                    bufferedWriter.write("\nDATA: "+ new Date());
                    bufferedWriter.write("\n------------------------");
                    bufferedReader.close();
                    bufferedWriter.close();

                    System.out.println(" Escreveu no log \n");
                }
                catch(FileNotFoundException ex){
                    try{

                        arquivo.createNewFile();

                    }catch(IOException ex1){
                        System.exit(0);
                    }
                }
                catch(IOException er){
                    System.exit(0);
                }
            }
        }
    }
}