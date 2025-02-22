package gestion;
import java.util.*;

import modelo.*;

public class GestorPersonajes {
    private List<Personaje> personajes1;
    private List<Personaje> personajes2;
    private Random random;
    private Set<String> nombresUsados;
    private Set<String> apodosUsados;

    public GestorPersonajes() {
        this.personajes1 = new ArrayList<>();
        this.personajes2 = new ArrayList<>();
        this.random = new Random();
        this.nombresUsados = new HashSet<>();
        this.apodosUsados = new HashSet<>();
    }

    public void generarPersonajeAleatorio() {
        System.out.println("Generando 6 personajes aleatorios...");

        for (int i = 0; i < 6; i++) {
            Personaje p = generarPersonajeAleatorio("Jugador " + (i < 3 ? "1" : "2"));
            if (i < 3) {
                personajes1.add(p);
            } else {
                personajes2.add(p);
            }
        }

        System.out.println("Personajes generados para el Jugador 1:");
        for (Personaje p : personajes1) {
            System.out.println(p.toString()); 
        }

        System.out.println("Personajes generados para el Jugador 2:");
        for (Personaje p : personajes2) {
            System.out.println(p.toString());  
        }
        
        System.out.println("Personajes generados exitosamente!!!");
    }
    // Genera un personaje con atributos aleatorios
    private Personaje generarPersonajeAleatorio(String jugador) {
        Raza raza = Raza.values()[random.nextInt(Raza.values().length)];
        String nombre = obtenerNombreAleatorio(raza);
        String apodo = obtenerApodoAleatorio(raza);
        int edad = random.nextInt(301);
        int nivel = random.nextInt(10) + 1;

        Estadisticas estadisticas = new Estadisticas(
            100,
            random.nextInt(10) + 1,
            random.nextInt(5) + 1,
            random.nextInt(10) + 1,
            random.nextInt(10) + 1
        );

        Personaje personaje = new Personaje(nombre, apodo, raza.name(), edad, nivel, estadisticas);
       
        return personaje;
    }

    private String obtenerNombreAleatorio(Raza raza) {
        String nombre;
        do {
            switch (raza) {
                case HUMANO:
                    nombre = Nombres.HUMANO.getNombreAleatorio();
                    break;
                case ORCO:
                    nombre = Nombres.ORCO.getNombreAleatorio();
                    break;
                case ELFO:
                    nombre = Nombres.ELFO.getNombreAleatorio();
                    break;
                default:
                    nombre = "Desconocido";
            }
        } while (nombresUsados.contains(nombre));
        nombresUsados.add(nombre);
        return nombre;
    }

    private String obtenerApodoAleatorio(Raza raza) {
        String apodo;
        do {
            switch (raza) {
                case HUMANO:
                    apodo = Apodos.HUMANO.getApodoAleatorio();
                    break;
                case ORCO:
                    apodo = Apodos.ORCO.getApodoAleatorio();
                    break;
                case ELFO:
                    apodo = Apodos.ELFO.getApodoAleatorio();
                    break;
                default:
                    apodo = "Sin Apodo";
            }
        } while (apodosUsados.contains(apodo));
        apodosUsados.add(apodo);
        return apodo;
    }
    public void generarPersonajeManual() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Generando un personaje manualmente...");
    
        // Solicitar el nombre
        System.out.print("Ingrese el nombre del personaje: ");
        String nombre = scanner.nextLine();
    
        // Solicitar el apodo
        System.out.print("Ingrese el apodo del personaje: ");
        String apodo = scanner.nextLine();
    
        // Solicitar la raza
        System.out.print("Seleccione la raza (HUMANO, ORCO, ELFO): ");
        String razaInput = scanner.nextLine().toUpperCase();
        Raza raza;
        try {
            raza = Raza.valueOf(razaInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Raza no válida. Se asignará 'HUMANO' por defecto.");
            raza = Raza.HUMANO; // Asignar un valor por defecto
        }
    
        // Solicitar la edad
        System.out.print("Ingrese la edad del personaje (0-300): ");
        int edad = Integer.parseInt(scanner.nextLine());
    
        // Solicitar el nivel
        System.out.print("Ingrese el nivel del personaje (1-10): ");
        int nivel = Integer.parseInt(scanner.nextLine());
    
        // Crear estadísticas aleatorias o solicitarlas al usuario
        Estadisticas estadisticas = new Estadisticas(
            100, // Salud
            (int) (Math.random() * 10) + 1, // Fuerza aleatoria
            (int) (Math.random() * 5) + 1, // Destreza aleatoria
            (int) (Math.random() * 10) + 1, // Armadura aleatoria
            (int) (Math.random() * 10) + 1  // Velocidad aleatoria
        );
    
        // Crear el personaje
        Personaje personaje = new Personaje(nombre, apodo, raza.name(), edad, nivel, estadisticas);
        
        // Agregar el personaje a la lista correspondiente
        if (personajes1.size() < 3) {
            personajes1.add(personaje);
        } else {
            personajes2.add(personaje);
        }
    
        System.out.println("Personaje creado exitosamente: " + personaje.toString());
    } 
}
