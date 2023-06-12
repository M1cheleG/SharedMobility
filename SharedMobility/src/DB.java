import Model.User;
import Model.Vehicle;
import java.util.ArrayList;
import java.util.List;

//DB con Singleton
public class DB {
    private static DB Internalinstance;
    private List<User> user;
    private List<Vehicle> vehicle;
    private DB(){
        user = new ArrayList<>();
        vehicle = new ArrayList<>();
    }

    public static DB getInstance(){
        if(Internalinstance == null){
                if(Internalinstance == null){
                    Internalinstance = new DB();
                }

        }
        return Internalinstance;
    }
}
