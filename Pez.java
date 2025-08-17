public class Pez extends Animal { // La clase Pez hereda de la clase Animal
    private String tipoAgua;  // Atributo que define el tipo de agua (dulce o salada)

    // Constructor
    public Pez(String nombre, String raza, String raza2, int edad, String estadoSalud,
               boolean vacunado, String fechaIngreso, boolean disponibleAdopcion,
               boolean disponibleAcogida, String tipoAgua) {
        // Llamada al constructor de la clase Animal, con la especie "Pez"
        super(nombre, "Pez", raza, edad, estadoSalud, vacunado, fechaIngreso, disponibleAdopcion, disponibleAcogida);
        this.tipoAgua = tipoAgua;  // Asignamos el tipo de agua
    }

    // Getter y setter para el tipo de agua
    public String getTipoAgua() {
        return tipoAgua;
    }

    public void setTipoAgua(String tipoAgua) {
        this.tipoAgua = tipoAgua;
    }

    // Sobrescritura del método hacerSonido para los peces
    @Override
    public String hacerSonido() {
        return "mamahuevo, que digo glu glu glu"; 
    }

    // Método específico de los peces, por ejemplo, nadar
    public void nadar() {
        System.out.println("Nadaremos Nadaremos en el mar el mar el mar");
    }

    // Sobrescritura del método toString() para incluir el tipo de agua
    @Override
    public String toString() {
        return "Pez{" + super.toString() +
                ", tipoAgua='" + tipoAgua + "'}";
    }
}
