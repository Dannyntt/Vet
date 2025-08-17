public class Animal {  //Declaración de la clase Animal xd
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private String estadoSalud;
    private boolean vacunado;
    private String fechaIngreso;
    private boolean disponibleAdopcion;
    private boolean disponibleAcogida; 
    //Aquí definimos las propiedades del objeto Animal que determinan las características de cada animal

    public Animal(String nombre, String especie, String raza, int edad, String estadoSalud,
                  boolean vacunado, String fechaIngreso, boolean disponibleAdopcion, boolean disponibleAcogida) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.estadoSalud = estadoSalud;
        this.vacunado = vacunado;
        this.fechaIngreso = fechaIngreso;
        this.disponibleAdopcion = disponibleAdopcion;
        this.disponibleAcogida = disponibleAcogida;
    }
    // Constructor, nos permite crear un nuevo animal

    // Métodos Getters
    public String getNombre() { return nombre; }
    public String getEspecie() { return especie; }
    public String getRaza() { return raza; }
    public int getEdad() { return edad; }
    public String getEstadoSalud() { return estadoSalud; }
    public boolean isVacunado() { return vacunado; }
    public String getFechaIngreso() { return fechaIngreso; }
    public boolean isDisponibleAdopcion() { return disponibleAdopcion; }
    public boolean isDisponibleAcogida() { return disponibleAcogida; }
    //Son para obtener la información almacenada en los atributos de la clase. Nos ayuda a acceder a los datos privados del objeto
    
    public String hacerSonido() {
    return "El animal hace un sonido :3";
}

    //No tiene valor de retorno, pero permite que el animal haga un sonido general, podría ser sobrescrito por clases específicas

    public void setDisponibleAdopcion(boolean disponibleAdopcion) {
        this.disponibleAdopcion = disponibleAdopcion;
    }

    public void setDisponibleAcogida(boolean disponibleAcogida) {
        this.disponibleAcogida = disponibleAcogida;
    }
    //Estos setters nos dejan modificar el estado de los atributos privados. Por ej, podemos marcar a un animal como no disponible para adopción

    @Override // Nos ayuda con el metodo toString()
    public String toString() {
        return "Animal{" +
                "nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", raza='" + raza + '\'' +
                ", edad=" + edad +
                ", estadoSalud='" + estadoSalud + '\'' +
                ", vacunado=" + vacunado +
                ", fechaIngreso='" + fechaIngreso + '\'' +
                ", disponibleAdopcion=" + disponibleAdopcion +
                ", disponibleAcogida=" + disponibleAcogida +
                '}';
    }
}
