/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios;


import Datos.Parada;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author David
 */
public class SetBuses {
    
    Map<String,List> conjuntoBuses= new TreeMap<>(); /// tabla hash donde se almacenara cada linea de bus con su recorrido
    
    String cadenaInformacion="";
    String cadenaInformacionDestino="";
    String ubicacionCrearMapa="";
    String ubicacionCrearMapaDestino="";
    SetParadas hashParadas;
    boolean encontrarBus=false;
    
    
     public  SetBuses()throws IOException{
                 hashParadas=new SetParadas();   /// instanciar la piscina de paradas y guardarlo en un hashset
                
                FileReader archivoBuses= new FileReader("buses.csv");
               
                BufferedReader buffer= new BufferedReader(archivoBuses);
                boolean aux=true;
                boolean con=true;
                int cont=0;
                while(aux){
                    String tx =buffer.readLine();

                    if(tx!=null && cont>0){
                        String valores[];
                        String paradas;
                        valores=tx.split(";");
              
                        paradas=valores[1];
                        String cadenaParadas[];
                        List<Parada> recorridoBus= new LinkedList<>();

                       
                      
                        for(int i=0;i<20;i++){
                            cadenaParadas=paradas.split(",");
                            recorridoBus.add(hashParadas.buscarParada(cadenaParadas[i])); /// agregamos elementos de tipo Parada a la lista de recorridos
                          
                        }
                        
                        /// Agregamos al TreeMap  el numero de linea de bus y la lista de recorrido
                        conjuntoBuses.put(valores[0], recorridoBus);
                    }
                    else if(tx==null){
                        aux=false;
                    }
                    else{
                        String valores[];
                        valores=tx.split(";");
                        
                    }
                    cont++;
                }          
        }

    public String getCadenaInformacion() {
        return cadenaInformacion;
    }

    public String getUbicacionCrearMapa() {
        return ubicacionCrearMapa;
    }

    public boolean isEncontrarBus() {
        return encontrarBus;
    }

    public String getUbicacionCrearMapaDestino() {
        return ubicacionCrearMapaDestino;
    }

    public String getCadenaInformacionDestino() {
        return cadenaInformacionDestino;
    }
    
    
     
     
     
     
    public void mostrarLinea(){
        Iterator iter=conjuntoBuses.keySet().iterator();
         
        while(iter.hasNext()){   /// MOSTRAR CADA ELEMENTO DE LA TABLA HASH
            
            String key= (String) iter.next();
            System.out.println("Linea:"+key);
            Iterator<List> iter2=conjuntoBuses.get(key).iterator();  /// devueve una lista ligada  que contiene objetos tipo parada 
             /// MOSTRAR LOS ELEMENTOS DE LA LISTA LIGADA DE CADA CLAVE DE LA TABLA HASH
            while(iter2.hasNext()){
                Parada par=(Parada) iter2.next();
                System.out.println("\tCODIGO:"+par.getCodigo()+" UBICACION: "+par.getUbicacion()+" LUGAR TURISTICO:"+par.getParadaTuristica());
            }   
        }
       
    }
    
    
    public void EncontrarBusesUnaParada(String cod){
        /// recorrer la tabla hash
        int cont=0;
        Iterator ite=conjuntoBuses.keySet().iterator();        
        while(ite.hasNext()){   /// BUSCARR CADA ELEMENTO DE LA TABLA HASH
            Parada parFinal;
            String key= (String) ite.next();
            Iterator<List> ite2=conjuntoBuses.get(key).iterator();  /// devueve una lista ligada  que contiene objetos tipo parada 
            Iterator<List> iteAux=conjuntoBuses.get(key).listIterator(19);  /// apuntar al ultimo elemento de la lista
            Parada parAux= (Parada) iteAux.next();                          /// Obtener la ultima parada del bus

            while((ite2.hasNext()==true) & (cont<19) ){
                 Parada par=(Parada) ite2.next();
                 
                 
                 if(par.getCodigo().equals(cod)){             /// Buscamos los buses que pasen por esa parada
                     //System.out.println("\n\nBus:"+key+" Ubicacion Parada:"+par.getUbicacion() +" Destino del Bus:"+parAux.getParadaTuristica());
                     encontrarBus=true;
                     ubicacionCrearMapa=par.getUbicacion();
                     cadenaInformacion+="\n\nLinea:"+key +" Destino del Bus:"+parAux.getParadaTuristica();
                     
                 }
                 cont++;
             }
            
            
            cont=0;
        }      
    }
    
    
    public void EncontrarDestino(String cod,String destino){
        System.out.println("HOLAA\n");
        int cont=0;
                
        /// recorrer la tabla hash
        int contador=0;
        boolean aux=false;
        Iterator it=conjuntoBuses.keySet().iterator();        
        while(it.hasNext()){   /// BUSCARR CADA ELEMENTO DE LA TABLA HASH
            Parada parFinal;
            String key= (String) it.next();
            Iterator<List> it2=conjuntoBuses.get(key).iterator();
            /// devueve una lista ligada  que contiene objetos tipo parada 
            Iterator<List> itAux=conjuntoBuses.get(key).listIterator(19);  /// apuntar al ultimo elemento de la lista
            Parada parAux= (Parada) itAux.next();                          /// Obtener la ultima parada del bus
            while((it2.hasNext())& (cont<19)){
                 Parada par=(Parada) it2.next();
                 
                 
                 if(par.getCodigo().equals(cod)){             /// Buscamos los buses que pasen por esa parada
                     encontrarBus=true;
                     ubicacionCrearMapa=par.getUbicacion();
                     
                     //System.out.println("\n\nBus:"+key+" Ubicacion Parada:"+par.getUbicacion() +" Destino del Bus:"+parAux.getParadaTuristica());
                     ListIterator<List> it3=conjuntoBuses.get(key).listIterator(contador);
                     /// recorremos la lista despues de que encontro la parada
                     while(it3.hasNext()){
                         
                         Parada parDestino=(Parada) it3.next();
                         if((parDestino.getParadaTuristica().equals(destino))& (contador+1!=it3.nextIndex())){
                            //System.out.println("\n\nBusDestino: "+key+" Ubicacion Parada: "+par.getUbicacion()+" Parada Destino: "+parDestino.getParadaTuristica());
                            ubicacionCrearMapaDestino=parDestino.getUbicacion();
                            cadenaInformacionDestino+="\n\nLinea: "+key+" Parada Destino: "+parDestino.getParadaTuristica();
                            aux=true;
                         }
                     }
                     
                 }
                 contador++;
                 cont++;
             }
            contador=0;
            cont=0;
        }
        if(aux==false){
            ///System.out.println("Ningun bus va hacia  ese destino");
            cadenaInformacionDestino+="Ningun bus va hacia  ese destino";
        }       
    }
    
    
        
}
