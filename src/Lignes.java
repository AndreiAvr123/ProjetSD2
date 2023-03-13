public class Lignes {
    private int identifiant = 1, numero, tmpsAttenteMoyen;
    private Stations depart, destination;
    private String typeTransport;

    public Lignes(int numero, int tmpsAttenteMoyen,
        Stations depart, Stations destination, String typeTransport){
      this.identifiant++;
      this.numero = numero;
      this.tmpsAttenteMoyen = tmpsAttenteMoyen;
      this.depart = depart;
      this.destination = destination;
      this.typeTransport = typeTransport;
    }

    // TODO vérifier ce constructeur
    public Lignes(int numero) {
      this.numero = numero;
    }
}
