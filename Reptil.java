public class Reptil extends Animal {
    private boolean esVenenoso;

    // Constructor que recibe los parámetros
public Reptil(String nombre, String especie, String raza, int edad, String estadoSalud,
              boolean adoptado, String fechaAdopcion, boolean disponibleAdopcion,
              boolean disponibleAcogida, boolean esVenenoso) {
    super(nombre, especie, raza, edad, estadoSalud, adoptado, fechaAdopcion, disponibleAdopcion, disponibleAcogida);
    this.esVenenoso = esVenenoso;
}
// Getter y Setter para el atributo esVenenoso
    public boolean isEsVenenoso() {
        return esVenenoso;
    }

    public void setEsVenenoso(boolean esVenenoso) {
        this.esVenenoso = esVenenoso;
    }

    @Override
    public String hacerSonido() {
        return "shhhh"; //no se como hacen los reptiles, pero lo queria poner en todas xd
    }
    @Override
public String toString() {
    return "Reptil{" + super.toString() +
           ", esVenenoso=" + esVenenoso + '}';
}
}
