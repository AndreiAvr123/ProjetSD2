public class Lignes {
    private int identifiant = 1, numero, tmpsAttenteMoyen;
    private String depart, destination, typeTransport;

    public Lignes(int numero, int tmpsAttenteMoyen,
        String depart, String destination, String typeTransport){
      this.identifiant++;
      this.numero = numero;
      this.tmpsAttenteMoyen = tmpsAttenteMoyen;
      this.depart = depart;
      this.destination = destination;
      this.typeTransport = typeTransport;
    }
}
