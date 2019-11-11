public class CellApplication {

    public static void main(String[] args) {
        System.out.println("1");
        SpringApplication.run(CellApplication.class, args);
        System.out.println("2");
        SpringApplication.run(CellApplication.class, args);
    }

}