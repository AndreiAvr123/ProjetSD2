public class Ligne {
    private int identifiant = 1, numero, tmpsAttenteMoyen;
    private String depart, destination;
    private String typeTransport;

    public Ligne(int numero, int tmpsAttenteMoyen,
        String depart, String destination, String typeTransport){
      this.identifiant++;
      this.numero = numero;
      this.tmpsAttenteMoyen = tmpsAttenteMoyen;
      this.depart = depart;
      this.destination = destination;
      this.typeTransport = typeTransport;
    }

    // TODO vérifier ce constructeur
    public Ligne(int numero) {
      this.numero = numero;
    }
}
