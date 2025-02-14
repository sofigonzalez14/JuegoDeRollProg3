/*package gestion;
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
        System.out.println("Personajes generados exitosamente!!!");
    }

    public void generarPersonajeManual() {
        System.out.println("Funcionalidad aún no implementada.");
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
        System.out.println(jugador + " - " + personaje);
        return personaje;
    }
    private String obtenerNombreAleatorio(Raza raza) {
        String nombre;
        do {
            switch (raza) {
                case HUMANO:
                    nombre = NombreHumano.values()[random.nextInt(NombreHumano.values().length)].name();
                    break;
                case ORCO:
                    nombre = NombreOrco.values()[random.nextInt(NombreOrco.values().length)].name();
                    break;
                case ELFO:
                    nombre = NombreElfo.values()[random.nextInt(NombreElfo.values().length)].name();
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
                    apodo = ApodoHumano.values()[random.nextInt(ApodoHumano.values().length)].name();
                    break;
                case ORCO:
                    apodo = ApodoOrco.values()[random.nextInt(ApodoOrco.values().length)].name();
                    break;
                case ELFO:
                    apodo = ApodoElfo.values()[random.nextInt(ApodoElfo.values().length)].name();
                    break;
                default:
                    apodo = "SinApodo";
            }
        } while (apodosUsados.contains(apodo));
        apodosUsados.add(apodo);
        return apodo;
    }
}
    
*/



