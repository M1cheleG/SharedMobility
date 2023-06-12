import Dao.DaoUser;
import Dao.implement.DaoUserCsv;
import Model.DrivingLicense;
import Model.User;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class TestSharedMobility {
    public static void main(String[] args) {
        DaoUser daoUser = new DaoUserCsv(Paths.get("SharedMobility","src","Dao","implement","users.csv"));
        daoUser.insert(new User(UUID.fromString("4e23ad1c-fc29-45dc-a4e6-f77b969758c8"),"Mario","Rossi", LocalDate.parse("2000-10-05"),"c3d4", List.of(DrivingLicense.B,DrivingLicense.BSPECIAL),false,100));

        System.out.println(daoUser.getAll());
        System.out.println("ciao");

    }
}
