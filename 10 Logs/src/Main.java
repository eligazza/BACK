import ar.com.dh.service.ListaEnterosService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ListaEnterosService service = new ListaEnterosService(1, 3, 7, 9, 13, 17, 23, 342, 5, 3, 1, 46);
        System.out.println(service.getPromedio());
        System.out.println(service.getMaximoDeLista());
        System.out.println(service.getMinimoDeLista());
    }
}