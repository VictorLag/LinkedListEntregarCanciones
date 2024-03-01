import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String nombre;
    private String artista;
    public ArrayList<Cancion> canciones=new ArrayList<Cancion>();

    private Cancion findSong (String titulocancion){

        for (int cont=0;cont< canciones.size();cont++){

            if (canciones.get(cont).getTitulo().equals(titulocancion)){

                return canciones.get(cont);
            }
        }
        return null;
    }

    public boolean addSong (String titulo, double duracion){

        if (findSong(titulo)!=null){


            return false;
        }
        canciones.add(new Cancion(titulo,duracion));

        return true;
    }

    public boolean addToPlayList (int numeroPista, LinkedList<Cancion> listaReproduccion){

        if (!listaReproduccion.contains(listaReproduccion.get(numeroPista))){

            return false;
        }
        listaReproduccion.add(canciones.get(numeroPista));
        return true;
    }

    public boolean addToPlayList (String tituloCancion, LinkedList<Cancion> listaReproduccion){

        if (!listaReproduccion.contains(findSong(tituloCancion))){

            listaReproduccion.add(findSong(tituloCancion));
            return false;
        }
         else{

            return true;
        }
    }

    public Album (String nombrealbum, String artista){

        this.nombre=nombrealbum;
        this.artista=artista;

        ArrayList canciones = new ArrayList<Cancion>();
        this.canciones=canciones;
    }


}
