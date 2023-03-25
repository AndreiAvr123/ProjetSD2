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

public class Graph {
    private Set<Station> listeStations;
    private Map<Station, Set<Troncon>> mapStationsTroncons;
    private Map<String, Station> stringStation;

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
        listeStations = new HashSet<>();
        mapStationsTroncons = new HashMap<>();
        stringStation = new HashMap<>();
        lireTroncons(troncons);
    }

    public void calculerCheminMinimisantNombreTroncons(String arretDepart, String arretArrivee) {
        Deque<Station> file = new ArrayDeque<>();
        Set<Station> dejaVisite = new HashSet<>();
        HashMap<Station, Troncon> mapStation = new HashMap<>();

        file.add(stringStation.get(arretDepart));
        dejaVisite.add(stringStation.get(arretDepart));

        Station stationArrivee = stringStation.get(arretArrivee);
        Station stationDepart = stringStation.get(arretDepart);
        Station station = stationDepart;

        Station test = stringStation.get("BARON DE CASTRO");

        while (!file.isEmpty() || !station.equals(stationArrivee)){
            station = file.removeFirst();

            // System.out.println(station.getNom());
            // System.out.println(mapStationsTroncons.containsKey(station));
            for (Troncon troncon : mapStationsTroncons.get(station)){
                station = troncon.getArrivee();
                if (dejaVisite.add(station)){
                    file.add(station);
                    mapStation.put(station, troncon);
                }
            }
        }

        for (Station station1 : mapStation.keySet()){
            System.out.println(mapStation.get(station1));
        }

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
    public Set<Station> lireStations(File fichierLignes, int index){

        try{
            FileReader fr = new FileReader(fichierLignes);
            BufferedReader br = new BufferedReader(fr);
            String ligne;
            while((ligne = br.readLine()) != null){
                String[] lisplit = ligne.split(",");
                Station stations = new Station(lisplit[index]);
                listeStations.add(stations);
                mapStationsTroncons.put(stations,null);
                System.out.println(mapStationsTroncons.containsKey(stations));
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
     * @return la liste des tronçons.
     */
    public void lireTroncons(File fichierTroncons){

        try{
            FileReader fr = new FileReader(fichierTroncons);
            BufferedReader br = new BufferedReader(fr);
            String ligne;
            while((ligne = br.readLine()) != null){
                String[] lisplit = ligne.split(",");
                Station stationDepart = new Station(lisplit[1]);
                Troncon troncon = new Troncon(new Ligne(Integer.parseInt(lisplit[0])),stationDepart, new Station(lisplit[2]),Integer.parseInt(lisplit[3]));

                if (!stringStation.containsKey(lisplit[1])){
                    stringStation.put(lisplit[1],stationDepart);
                    listeStations.add(stationDepart);

                    HashSet<Troncon> listeTroncons = new HashSet<>();
                    listeTroncons.add(troncon);
                    mapStationsTroncons.put(stringStation.get(lisplit[1]),listeTroncons);
                }else{
                    mapStationsTroncons.get(stringStation.get(lisplit[1])).add(troncon);
                }
            }
            fr.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
