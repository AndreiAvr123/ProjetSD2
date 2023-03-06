import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Graph {

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
                sb.append(ligne);
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
