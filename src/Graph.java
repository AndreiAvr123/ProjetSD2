import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph  {
    Set<Stations> listeStations;
    private Map<Stations, Set<Troncons>> mapStationsTroncons = new HashMap<>();

    /**
     * Construit la liste des stations pour la liste d'adjacence. Ensuite construit une map
     * ayant comme clés chaque station de la liste des stations, et comme valeur une liste
     * de tronçons sortant de la station.
     * La liste des Stations se construit sur base du premier paramètre.
     * Les listes des tronçons se construisent sur base du deuxième paramètre.
     *
     * @param lignes fichier Lignes.txt à lire.
     * @param troncons fichier Tronçons.txt à lire.
     */
    public Graph(File lignes, File troncons) {
        listeStations = lireStations(lignes,2);
        for (Stations station : listeStations) {
            Set<Troncons> listeTroncons = lireTroncons(troncons,station);
            mapStationsTroncons.put(station,listeTroncons);
        }
    }

    // TODO méthode à revoir pcq elle fonctionne pas du tout
    public void calculerCheminMinimisantNombreTroncons(String arretDepart, String arretArrivee) {
        int nbrTroncons = 0;

        for (Stations station : listeStations){
            if (station.getNom().equals(arretArrivee))
                break;

            for (Troncons troncon : mapStationsTroncons.get(station)){
                if (troncon.getArrivee().equals(arretArrivee))
                    break;
            }

            nbrTroncons++;
        }

        System.out.println("Nombre de tronçons de " + arretDepart + " à " + arretArrivee +
            " est de : " + nbrTroncons + " tronçons.");
    }

    public void calculerCheminMinimisantTempsTransport(String arretDepart, String arretArrivee) {
    }

    /**
     * Lis le fichier et renvois une liste de toute les stations.
     *
     * @param fichierLignes le fichier à lire.
     * @param index correspondant au numéro, de la valeur pour chaque ligne, séparé par les virgules.
     * @return la liste de toute les stations.
     */
    public Set<Stations> lireStations(File fichierLignes, int index){
        Set<Stations> listeStations = new HashSet<Stations>();

        try{
            FileReader fr = new FileReader(fichierLignes);
            BufferedReader br = new BufferedReader(fr);
            String ligne;
            while((ligne = br.readLine()) != null){
                String[] lisplit = ligne.split(",");
                Stations stations = new Stations(lisplit[index]);
                listeStations.add(stations);
            }
            fr.close();

        }catch (IOException e){
            e.printStackTrace();
        }

        return listeStations;
    }

    /**
     * Lis le fichier et renvois une liste de tronçons ayant comme arret de
     * départ la station passée en parametre.
     *
     * @param fichierTroncons fichier à lire.
     * @param stationDepart la station de départ.
     * @return la liste des tronçons.
     */
    public Set<Troncons> lireTroncons(File fichierTroncons, Stations stationDepart){
        Set<Troncons> listeRetour = new HashSet<Troncons>();

        try{
            FileReader fr = new FileReader(fichierTroncons);
            BufferedReader br = new BufferedReader(fr);
            String ligne;
            while((ligne = br.readLine()) != null){
                String[] lisplit = ligne.split(",");
                Troncons troncons = new Troncons(new Lignes(Integer.parseInt(lisplit[0])),lisplit[1], lisplit[2],Integer.parseInt(lisplit[3]));
                if (troncons.getDepart().equals(stationDepart.getNom())){
                    listeRetour.add(troncons);
                }
            }
            fr.close();

        }catch (IOException e){
            e.printStackTrace();
        }

        return listeRetour;
    }
}
