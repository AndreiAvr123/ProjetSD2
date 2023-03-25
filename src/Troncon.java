public class Troncon {
    private Ligne numLigne;
    private int duree;
    private Station depart,arrivee;

    public Troncon(Ligne numLigne, Station depart, Station arrivee, int duree) {
        this.numLigne = numLigne;
        this.duree = duree;
        this.depart = depart;
        this.arrivee = arrivee;
    }

    public int getDuree() {
        return duree;
    }

    public Ligne getNumLigne() {
        return numLigne;
    }

    public Station getArrivee() {
        return arrivee;
    }

    public Station getDepart() {
        return depart;
    }
}
