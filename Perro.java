public class Perro extends Animal {  // Hereda de la clase Animal
    private String nivelAdiestramiento; // Atributo específico de la clase Perro
    private String tamaño; // otro atributo específico

    // Constructor 
public Perro(String nombre, String especie, String raza, int edad, String estadoSalud,
             boolean adoptado, String fechaAdopcion, boolean disponibleAdopcion,
             boolean disponibleAcogida, String nivelAdiestramiento, String tamaño) {
    super(nombre, especie, raza, edad, estadoSalud, adoptado, fechaAdopcion, disponibleAdopcion, disponibleAcogida);
    this.nivelAdiestramiento = nivelAdiestramiento;
    this.tamaño = tamaño;
}


    // Getter para el nivel de adiestramiento
    public String getNivelAdiestramiento() {
        return nivelAdiestramiento;
    }

    // Setter para el nivel de adiestramiento
    public void setNivelAdiestramiento(String nivelAdiestramiento) {
        this.nivelAdiestramiento = nivelAdiestramiento;
    }

    // Getter para el tamaño
    public String getTamaño() {
        return tamaño;
    }

    // Setter para el tamaño
    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    // Sobrescritura del método hacerSonido
    @Override
    public String hacerSonido() {
        return "guau guau :v";  
    }

    // Sobrescritura del método toString() para incluir el nuevo atributo tamaño
    @Override
    public String toString() {
        return "Perro{" + super.toString() +
               ", nivelAdiestramiento='" + nivelAdiestramiento + '\'' +
               ", tamaño='" + tamaño + '\'' + '}';
    }
}
