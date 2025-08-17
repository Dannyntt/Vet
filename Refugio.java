import java.util.Scanner;

public class Refugio {

    private static final int MAX_ANIMALES = 100;
    private static Animal[] animales = new Animal[MAX_ANIMALES];
    private static int cantidadAnimales = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        try {
            do {
                System.out.println("\n+------------------------------------+");
                System.out.println("|         MENU DEL REFUGIO :)        |");
                System.out.println("+------------------------------------+");
                System.out.println("| 1. Registrar nuevo animal          |");
                System.out.println("| 2. Ver animales registrados        |");
                System.out.println("| 3. Registrar adopcion              |");
                System.out.println("| 4. Registrar acogida temporal      |");
                System.out.println("| 5. Buscar animales                 |");
                System.out.println("| 0. Salir                           |");
                System.out.println("+------------------------------------+");
                System.out.print("Elige una opcion: ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        registrarAnimal(sc);
                        break;
                    case 2:
                        mostrarAnimales();
                        break;
                    case 3:
                        registrarTransaccion(sc, "adopcion");
                        break;
                    case 4:
                        registrarTransaccion(sc, "acogida");
                        break;
                    case 5:
                        buscarAnimales(sc);
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema... :(");
                        break;
                    default:
                        System.out.println("Opcion invalida. Intenta de nuevo.");
                }
            } while (opcion != 0);
        } finally {
            sc.close();
        }
    }

    private static void registrarAnimal(Scanner sc) {
        if (cantidadAnimales >= MAX_ANIMALES) {
            System.out.println("El refugio esta lleno.");
            return;
        }

        try {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Especie (Perro/Gato/Ave/Reptil/Pez): ");
            String especie = sc.nextLine().trim();

            System.out.print("Raza: ");
            String raza = sc.nextLine();

            System.out.print("Edad en años: ");
            int edad = Integer.parseInt(sc.nextLine());

            System.out.print("Estado de salud: ");
            String salud = sc.nextLine();

            System.out.print("¿Disponible para adopcion? (true/false): ");
            boolean adopcion = Boolean.parseBoolean(sc.nextLine());

            System.out.print("¿Disponible para acogida? (true/false): ");
            boolean acogida = Boolean.parseBoolean(sc.nextLine());

            Animal nuevo;

            switch (especie.toLowerCase()) {
                case "perro":
                    System.out.print("Nivel de adiestramiento (Bajo/Medio/Alto): ");
                    String nivel = sc.nextLine();

                    System.out.print("Tamaño (Pequeño/Mediano/Grande): ");
                    String tamaño = sc.nextLine();

                    nuevo = new Perro(nombre, "Perro", raza, edad, salud, false, "", adopcion, acogida, nivel, tamaño);
                    break;

                case "gato":
                    System.out.print("¿Le gusta estar con personas? (true/false): ");
                    boolean leGusta = Boolean.parseBoolean(sc.nextLine());

                    System.out.print("Tipo de pelaje (Corto/Largo/Sin pelaje): ");
                    String pelaje = sc.nextLine();

                    nuevo = new Gato(nombre, "Gato", raza, edad, salud, false, "", adopcion, acogida, leGusta, pelaje);
                    break;

                case "ave":
                    System.out.print("¿Puede volar? (true/false): ");
                    boolean vuela = Boolean.parseBoolean(sc.nextLine());

                    System.out.print("Tipo de alimentacion (Granivoro/Frugivoro/Nectarivoro): ");
                    String alimentacion = sc.nextLine();

                    nuevo = new Ave(nombre, "Ave", raza, edad, salud, false, "", adopcion, acogida, vuela, alimentacion);
                    break;

                case "reptil":
                    System.out.print("¿Es venenoso? (true/false): ");
                    boolean venenoso = Boolean.parseBoolean(sc.nextLine());

                    nuevo = new Reptil(nombre, "Reptil", raza, edad, salud, false, "", adopcion, acogida, venenoso);
                    break;

                case "pez":
                    System.out.print("¿Qué tipo de agua tiene el pez? (dulce/salada/ambos): ");
                    String tipoAgua = sc.nextLine().trim().toLowerCase();

                    if (!(tipoAgua.equals("dulce") || tipoAgua.equals("salada") || tipoAgua.equals("ambos"))) {
                        System.out.println("Tipo de agua no valido.");
                        return;
                    }

                    nuevo = new Pez(nombre, "Pez", raza, edad, salud, false, "", adopcion, acogida, tipoAgua);
                    break;

                default:
                    System.out.println("Especie no valida.");
                    return;
            }

            animales[cantidadAnimales++] = nuevo;
            System.out.println("Animal registrado correctamente. :)");

            // Guardar el animal en el archivo txt
            guardarAnimalEnArchivo(nuevo);

        } catch (Exception e) {
            System.out.println("Error al registrar animal: " + e.getMessage());
        }
    }

    private static void mostrarAnimales() {
        if (cantidadAnimales == 0) {
            System.out.println("No hay animales registrados. :(");
            return;
        }

        System.out.println("\nLISTA DE ANIMALES REGISTRADOS");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < cantidadAnimales; i++) {
            System.out.println("Animal #" + (i + 1));
            mostrarAnimal(animales[i]);
            System.out.println("---------------------------------------------");
        }
    }

    private static void mostrarAnimal(Animal a) {
        System.out.printf("Nombre             : %s\n", a.getNombre());
        System.out.printf("Especie            : %s\n", a.getEspecie());
        System.out.printf("Raza               : %s\n", a.getRaza());
        System.out.printf("Edad               : %d años\n", a.getEdad());
        System.out.printf("Estado de salud    : %s\n", a.getEstadoSalud());
        System.out.printf("Adopcion disponible: %s\n", a.isDisponibleAdopcion() ? "Si" : "No");
        System.out.printf("Acogida disponible : %s\n", a.isDisponibleAcogida() ? "Si" : "No");
        System.out.printf("Sonido             : %s\n", a.hacerSonido());

        if (a instanceof Perro) {
            Perro p = (Perro) a;
            System.out.printf("Tamaño             : %s\n", p.getTamaño());
            System.out.printf("Adiestramiento     : %s\n", p.getNivelAdiestramiento());
        } else if (a instanceof Gato) {
            Gato g = (Gato) a;
            System.out.printf("¿Le gusta compañia?: %s\n", g.isJugueton() ? "Si" : "No");
            System.out.printf("Tipo de pelaje     : %s\n", g.tienePelajeLargo());
        } else if (a instanceof Ave) {
            Ave av = (Ave) a;
            System.out.printf("¿Puede volar?      : %s\n", av.isPuedeVolar() ? "Si" : "No");
            System.out.printf("Alimentacion       : %s\n", av.getTipoAlimentacion());
        } else if (a instanceof Reptil) {
            Reptil r = (Reptil) a;
            System.out.printf("¿Es venenoso?      : %s\n", r.isEsVenenoso() ? "Si" : "No");
        } else if (a instanceof Pez) {
            Pez pz = (Pez) a;
            System.out.printf("Tipo de agua       : %s\n", pz.getTipoAgua());
        }
    }

    private static void guardarAnimalEnArchivo(Animal animal) {
        try {
            java.io.FileWriter writer = new java.io.FileWriter("animales.txt", true);
            writer.write(formatoAnimalConFormato(animal) + "\n");
            writer.close();
        } catch (Exception e) {
            System.out.println("Error al guardar el animal: " + e.getMessage());
        }
    }

    private static String formatoAnimalConFormato(Animal a) {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(a.getNombre()).append("\n");
        sb.append("Especie: ").append(a.getEspecie()).append("\n");
        sb.append("Raza: ").append(a.getRaza()).append("\n");
        sb.append("Edad: ").append(a.getEdad()).append(" años\n");
        sb.append("Salud: ").append(a.getEstadoSalud()).append("\n");
        sb.append("Adopción: ").append(a.isDisponibleAdopcion() ? "Sí" : "No").append("\n");
        sb.append("Acogida: ").append(a.isDisponibleAcogida() ? "Sí" : "No").append("\n");

        if (a instanceof Perro) {
            Perro p = (Perro) a;
            sb.append("Tamaño: ").append(p.getTamaño()).append("\n");
            sb.append("Nivel de adiestramiento: ").append(p.getNivelAdiestramiento()).append("\n");
        } else if (a instanceof Gato) {
            Gato g = (Gato) a;
            sb.append("Le gusta gente: ").append(g.isJugueton() ? "Sí" : "No").append("\n");
            sb.append("Pelaje: ").append(g.tienePelajeLargo() ? "Largo" : "Corto").append("\n");
        } else if (a instanceof Ave) {
            Ave av = (Ave) a;
            sb.append("Puede volar: ").append(av.isPuedeVolar() ? "Sí" : "No").append("\n");
            sb.append("Alimentación: ").append(av.getTipoAlimentacion()).append("\n");
        } else if (a instanceof Reptil) {
            Reptil r = (Reptil) a;
            sb.append("Venenoso: ").append(r.isEsVenenoso() ? "Sí" : "No").append("\n");
        } else if (a instanceof Pez) {
            Pez pz = (Pez) a;
            sb.append("Tipo de agua: ").append(pz.getTipoAgua()).append("\n");
        }

        return sb.toString();
    }

    private static void registrarTransaccion(Scanner sc, String tipoTransaccion) {
        if (cantidadAnimales == 0) {
            System.out.println("No hay animales registrados para " + tipoTransaccion + ".");
            return;
        }

        try {
            System.out.print("Introduce el nombre del animal: ");
            String nombreAnimal = sc.nextLine();
            Animal animal = null;

            for (int i = 0; i < cantidadAnimales; i++) {
                if (animales[i].getNombre().equalsIgnoreCase(nombreAnimal)) {
                    animal = animales[i];
                    break;
                }
            }

            if (animal == null) {
                System.out.println("Animal no encontrado.");
                return;
            }

            System.out.print("Introduce la fecha de la transacción (dd/mm/yyyy): ");
            String fecha = sc.nextLine();

            System.out.println("Transacción registrada: " + tipoTransaccion + " de " + nombreAnimal);
            guardarTransaccionEnArchivo(tipoTransaccion, nombreAnimal, fecha);
        } catch (Exception e) {
            System.out.println("Error al registrar transacción: " + e.getMessage());
        }
    }

    private static void guardarTransaccionEnArchivo(String tipoTransaccion, String nombreAnimal, String fecha) {
        try {
            java.io.FileWriter writer = new java.io.FileWriter("transacciones.txt", true);
            writer.write("Transacción: " + tipoTransaccion + "\n");
            writer.write("Animal: " + nombreAnimal + "\n");
            writer.write("Fecha: " + fecha + "\n");
            writer.write("---------------------------------------------\n");
            writer.close();
        } catch (Exception e) {
            System.out.println("Error al guardar la transacción: " + e.getMessage());
        }
    }

    private static void buscarAnimales(Scanner sc) {
        System.out.print("Introduce el nombre o la especie para buscar: ");
        String busqueda = sc.nextLine().trim().toLowerCase();
        boolean encontrado = false;

        for (int i = 0; i < cantidadAnimales; i++) {
            Animal animal = animales[i];
            if (animal.getNombre().toLowerCase().contains(busqueda) || animal.getEspecie().toLowerCase().contains(busqueda)) {
                mostrarAnimal(animal);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún animal con esa búsqueda. :(");
        }
    }
}
