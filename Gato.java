public class Gato extends Animal { // Clase Gato hereda de la clase Animal
    private boolean leGustaEstarConPersonas; // Atributo específico para los gatos
    private String tipoDePelaje; // Otro atributo que indica el tipo de pelaje (largo, corto, etc.)
    
    // Constructor 
public Gato(String nombre, String especie, String raza, int edad, String estadoSalud,
            boolean adoptado, String fechaAdopcion, boolean disponibleAdopcion,
            boolean disponibleAcogida, boolean leGustaEstarConPersonas, String tipoPelaje) {
    super(nombre, especie, raza, edad, estadoSalud, adoptado, fechaAdopcion, disponibleAdopcion, disponibleAcogida);
    this.leGustaEstarConPersonas = leGustaEstarConPersonas;
    this.tipoDePelaje = tipoPelaje;
}

    // Getter y Setter para leGustaEstarConPersonas
    public boolean isLeGustaEstarConPersonas() {
        return leGustaEstarConPersonas;
    }
// Método para saber si es juguetón
public boolean isJugueton() {
    return leGustaEstarConPersonas;
}

    public void setLeGustaEstarConPersonas(boolean leGustaEstarConPersonas) {
        this.leGustaEstarConPersonas = leGustaEstarConPersonas;
    }

    // Getter y Setter para tipoDePelaje
    public String getTipoDePelaje() {
        return tipoDePelaje;
    }

    public void setTipoDePelaje(String tipoDePelaje) {
        this.tipoDePelaje = tipoDePelaje;
    }

    // Método adicional para saber si el pelaje es largo (según el tipo)
    public boolean tienePelajeLargo() {
        return tipoDePelaje.toLowerCase().contains("largo");
    }

    // Sobrescritura del método hacerSonido
    @Override
    public String hacerSonido() {
        return "miau miau miau miaaau";  
    }

    // toString personalizado
    @Override
    public String toString() {
        return "Gato{" + super.toString() +
                ", leGustaEstarConPersonas=" + leGustaEstarConPersonas +
                ", tipoDePelaje='" + tipoDePelaje + "'}";
    }
}
