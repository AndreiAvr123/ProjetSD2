import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    Set<Stations> listeStations;
    private Map<Stations, Set<Troncons>> mapStationsTroncons = new HashMap<>();

    public Graph(File lignes, File troncons) {
        listeStations = lireStations(lignes,2);
        for (int i = 1; i <= listeStations.size(); i++) {
            Set<Troncons> listeTroncons = lireTroncons(troncons);


        }
    }

    public void calculerCheminMinimisantNombreTroncons(String arretDepart, String arretArrivee) {

    }

    public void calculerCheminMinimisantTempsTransport(String arretDepart, String arretArrivee) {
    }

    /**
     * Lis un fichier et affiche son contenu
     * @param fichierLignes le fichier à lire
     */
    public Set<Stations> lireStations(File fichierLignes, int index){
        Set<Stations> listeRetour = new HashSet<Stations>();

        try{
            FileReader fr = new FileReader(fichierLignes);
            BufferedReader br = new BufferedReader(fr);
            String ligne;
            while((ligne = br.readLine()) != null){
                String[] lisplit = ligne.split(",");
                Stations stations = new Stations(lisplit[index]);
                listeRetour.add(stations);
            }
            fr.close();

        }catch (IOException e){
            e.printStackTrace();
        }

        return listeRetour;
    }

    // TODO deuxieme paramètre correspondant à un arret de départ du troncons

    public Set<Troncons> lireTroncons(File fichierTroncons){
        Set<Troncons> listeRetour = new HashSet<Troncons>();

        try{
            FileReader fr = new FileReader(fichierTroncons);
            BufferedReader br = new BufferedReader(fr);
            String ligne;
            while((ligne = br.readLine()) != null){
                String[] lisplit = ligne.split(",");
                Troncons troncons = new Troncons(new Lignes(Integer.parseInt(lisplit[0])),Integer.parseInt(lisplit[1]),lisplit[2], lisplit[3]);
                listeRetour.add(troncons);
            }
            fr.close();

        }catch (IOException e){
            e.printStackTrace();
        }

        return listeRetour;
    }
}
