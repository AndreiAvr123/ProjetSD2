import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Graph {
    private Map<String, ArrayList<String>> mapStationListeTroncons;
    public Graph(File lignes, File troncons) {
        lireFichier(lignes);
    }

    public void calculerCheminMinimisantNombreTroncons(String arretDepart, String arretArrivee) {

    }

    public void calculerCheminMinimisantTempsTransport(String arretDepart, String arretArrivee) {
    }

    /**
     * Lis un fichier et affiche son contenu
     * @param fichier le fichier à lire
     */
    public void lireFichier(File fichier){
        try{
            FileReader fr = new FileReader(fichier);
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String ligne;
            while((ligne = br.readLine()) != null){
                String[] lisplit = ligne.split(",");
                sb.append(lisplit[1]);
                sb.append('\n');
            }
            fr.close();
            System.out.println("Contenu du fichier :");
            System.out.println(sb.toString());
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
