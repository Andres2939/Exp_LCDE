import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Metodo playlist = new Metodo();
        playlist.agregarFinal(new Cancion("El perdedor", "Romeo Santos"));
        playlist.agregarFinal(new Cancion("Siempre sere", "Tito rojas"));
        playlist.agregarFinal(new Cancion("Si no regresas", "Binomio De Oro De America"));
        boolean continuar = true;

        while (continuar) {
            System.out.println("===== PLAYLIST =====");
            System.out.println("1) Agregar al final");
            System.out.println("2) Agregar siguiente");
            System.out.println("3) Eliminar por titulo");
            System.out.println("4) Mostrar lista");
            System.out.println("5) Mostrar actual");
            System.out.println("6) Avanzar");
            System.out.println("7) Retroceder");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese titulo");
                    String titulo = sc.nextLine();
                    System.out.println("Ingrese autor");
                    String autor = sc.nextLine();
                    Cancion cancion = new Cancion(titulo, autor);
                    System.out.println(playlist.agregarFinal(cancion)); 
                    break;
                case 2:
                    System.out.println("Ingrese cancion de referencia");
                    String ref = sc.nextLine();
                    System.out.println("Ingrese titulo");
                    titulo = sc.nextLine();
                    System.out.println("Ingrese autor");
                    autor = sc.nextLine();
                    cancion = new Cancion(titulo, autor);
                    if (!playlist.agregarSiguiente(ref, cancion))
                        System.out.println("No se encontró la canción de referencia.");
                    break;
                case 3:
                    System.out.println("Titulo a eliminar");
                    titulo = sc.nextLine();
                    playlist.eliminar(titulo);
                    System.out.println("cancion " + titulo + " eliminado");
                    break;
                case 4:
                    playlist.Mostrar();
                    break;
                case 5:
                    playlist.mostrarActual();
                    break;
                case 6:
                    playlist.avanzar();
                    break;
                case 7:
                    playlist.retroceder();
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }
}
