public class Ave extends Animal { // Clase Ave hereda de la clase Animal
    private boolean puedeVolar; // Atributo especifico de la clase Ave
    private String tipoAlimentacion; // otro atributo 

    // Constructor que recibe los parametros
public Ave(String nombre, String especie, String raza, int edad, String estadoSalud,
           boolean adoptado, String fechaAdopcion, boolean disponibleAdopcion,
           boolean disponibleAcogida, boolean puedeVolar, String tipoAlimentacion) {
    super(nombre, especie, raza, edad, estadoSalud, adoptado, fechaAdopcion, disponibleAdopcion, disponibleAcogida);
    this.puedeVolar = puedeVolar;
    this.tipoAlimentacion = tipoAlimentacion;
}


    // Getter para el atributo puedeVolar
    public boolean isPuedeVolar() {
        return puedeVolar;
    }

    // Setter para el atributo puedeVolar
    public void setPuedeVolar(boolean puedeVolar) {
        this.puedeVolar = puedeVolar;
    }

    // Getter para el tipo de alimentación
    public String getTipoAlimentacion() {
        return tipoAlimentacion;
    }

    // Setter para el tipo de alimentación
    public void setTipoAlimentacion(String tipoAlimentacion) {
        this.tipoAlimentacion = tipoAlimentacion;
    }

    // Sobrescritura del método hacerSonido para las aves
    @Override
    public String hacerSonido() {
        return "canta el pollito pio :v";  // Sonido característico de las aves
    }

    // Override del método toString() para incluir información del ave
    @Override
    public String toString() {
        return "Ave{" + super.toString() +
                ", puedeVolar=" + puedeVolar +
                ", tipoAlimentacion='" + tipoAlimentacion + "'}";
    }
}
