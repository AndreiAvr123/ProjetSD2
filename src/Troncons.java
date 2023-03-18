public class Troncons {
    private Lignes numLigne;
    private int duree;
    private String depart,arrivee;

    public Troncons(Lignes numLigne, String depart, String arrivee, int duree) {
        this.numLigne = numLigne;
        this.duree = duree;
        this.depart = depart;
        this.arrivee = arrivee;
    }

    public int getDuree() {
        return duree;
    }

    public Lignes getNumLigne() {
        return numLigne;
    }

    public String getArrivee() {
        return arrivee;
    }

    public String getDepart() {
        return depart;
    }
}
