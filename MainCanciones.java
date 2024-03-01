import java.util.*;

public class MainCanciones {
    public static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        ArrayList<Album> albumlista=new ArrayList<>();

        Album album1 =new Album("CodeAllica","El diavolico Michael G.");
        Album album2 =new Album("System of a DAW","Serj Tankian");

        albumlista.add(album1);
        albumlista.add(album2);

        album1.addSong("Master of puppets",8.35);
        album1.addSong("Damage,Inc",5.08);
        album1.addSong("Enter Sandman",5.32);
        album2.addSong("Chop Suey!",3.29);
        album2.addSong("Toxicity",3.39);
        album2.addSong("Sugar",2.34);

        LinkedList<Cancion> listaReproduccion=new LinkedList<Cancion>();
        album1.addToPlayList("Master of puppets",listaReproduccion);
        album1.addToPlayList("Damage,Inc",listaReproduccion);
        album1.addToPlayList("Enter Sandman",listaReproduccion);
        album2.addToPlayList("Chop Suey!",listaReproduccion);
        album2.addToPlayList("Toxicity",listaReproduccion);
        album2.addToPlayList("Sugar",listaReproduccion);

        imprimirMenu();

        Play(listaReproduccion);


    }

    public static void imprimirMenu(){

        System.out.println("0 = Salir de la lista de reproducción");
        System.out.println("1 = Reproducir siguiente canción en la lista");
        System.out.println("2 = Reproducir la canción previa de la lista");
        System.out.println("3 = Repetir la canción actua");
        System.out.println("4 = Imprimir la lista de canciones en la playlist");
        System.out.println("5 = Volver a imprimir menu");
        System.out.println("6 = Eliminar cancion actual de la PlayList");
    }



    public static void  imprimirListaReproduccion(LinkedList<Cancion> listaReproduccion){

        Iterator<Cancion> it =listaReproduccion.iterator();

        while (it.hasNext()) {
            System.out.println("Cancion: " + it.next());
        }
    }

public static void Play (LinkedList<Cancion> listaReproduccion){

    boolean continuar = true;
    boolean haciadelante=true;
    int opcion;

    ListIterator<Cancion> it = listaReproduccion.listIterator();

    while (continuar){
        System.out.println("Elige una opcion.");
        opcion=sc.nextInt();

        if (opcion<0 || opcion>6){
            do {
                System.out.println("Esa ocion no es correcta, elige entre las siguientes opciones : ");
                imprimirMenu();
                opcion=sc.nextInt();

            }while (opcion<0 || opcion>6);
        }

        switch (opcion){

            case 0:
                System.out.println("Adios");
                continuar=false;
                break;

            case 1:

                if (!haciadelante) {
                    if (it.hasNext())
                        it.next();
                    haciadelante = true;
                }

                if (it.hasNext()) {
                    System.out.println("Escuchando :" + it.next());
                } else {
                    System.out.println("Ya no hay más canciones");
                }


                break;

            case 2:
                if(haciadelante) {
                    if (it.hasPrevious())
                        it.previous();
                    haciadelante = false;
                }

                if (it.hasPrevious()) {
                    System.out.println("Escuchando :" + it.previous());
                } else {
                    System.out.println("Ya no hay más canciones");
                }

                break;

            case 3:

                if (!it.hasPrevious()){
                    it.next();
                }

                it.previous();
                System.out.println("Ahora mismo estas ecuchando : "+it.next());

                break;

            case 4:
                System.out.println("Esta es tu lista de reproduccion");
                imprimirListaReproduccion(listaReproduccion);

                break;

            case 5:
                imprimirMenu();

                break;

            case 6:

                if (it.hasNext()&& haciadelante){

                    it.remove();
                    System.out.println("Escuchando :" + it.next());

                }
                else if (it.hasPrevious()&&!haciadelante){

                    it.remove();
                    System.out.println("Escuchando :" + it.previous());

                }
                else if (!it.hasNext()&&haciadelante){

                    it.remove();
                    System.out.println("Escuchando :" + it.previous());

                }
                else if (!it.hasPrevious()&&!haciadelante){
                    it.remove();
                    System.out.println("Escuchando :" + it.next());

                }
                break;
        }
    }
}










}
