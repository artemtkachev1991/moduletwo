public class Main extends ModuleJDBC{
    public static void main  (String[] args) {
        ModuleJDBC moduleJDBC = new ModuleJDBC();
        moduleJDBC.createDbUserTable();
        moduleJDBC.readAllLines();
    }

}
