/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios;

/**
 *
 * @author David
 */
import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import Datos.Parada;

public class SetParadas {
    
    
  Set<Parada>  listaParadas= new HashSet<>();
  
       
        public  SetParadas()throws IOException{
               
                FileReader archivo_paradas= new FileReader("paradas.csv");
              
                BufferedReader buffer= new BufferedReader(archivo_paradas);
                boolean aux=true;
                int cont=0;
                while(aux){
                    String tx =buffer.readLine();

                    if(tx!=null && cont>0){
                        String valores[];
                        valores=tx.split(";");

                        String cod=valores[0];
                        String Ubicacion=valores[1];
                        String paradaTuristica=valores[2];
                        listaParadas.add(new Parada(cod, Ubicacion,paradaTuristica));

                    }
                    else if(tx==null){
                        aux=false;
                    }
                    else{
                        String valores[];
                        valores=tx.split(";");
                        //System.out.println(valores[0]+"\t\t"+valores[1]+"\t\t\t\t\t"+valores[2]);
                    }
                

                    cont++;

                }

           
        }
        
        
        
        public void mostrarParadas(){
            Iterator<Parada> iter;
            iter=listaParadas.iterator();
            while(iter.hasNext()){
                Parada p;
                p=iter.next();
                System.out.println(p.getCodigo()+"\t\t"+p.getUbicacion()+"\t\t"+p.getParadaTuristica());
            }
        }
        
        public Parada buscarParada(String cod){
            Parada aux=null;
            Iterator<Parada> iter;
            iter=listaParadas.iterator();
            while(iter.hasNext()){
                Parada p;
                p=iter.next();
                if (p.getCodigo().equals(cod)){
                   aux=p;
                }
                
            }
            if(aux==null){
                System.out.println("No se encuentra la parada"+cod);
            }
            return aux;
        }
    
    
    
}
