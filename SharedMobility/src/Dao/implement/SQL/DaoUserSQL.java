package Dao.implement.SQL;

import Dao.DaoUser;
import Model.DrivingLicense;
import Model.Helmet;
import Model.User;
import connection_handler.ConnectionHandler;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DaoUserSQL implements DaoUser {


    @Override
    public boolean insert(User user) {
        int insertCount=0;
        try {
       String query ="INSERT INTO SharedMobility.User( ID, name, surname, dateOfBirth, CF, helmet, credit)" +
               " VALUES (?, ?, ?, ?, ?, ?, ?)";
        ConnectionHandler connectionHandler = ConnectionHandler.getInstance();
        PreparedStatement ps = connectionHandler.getPreparedStatement(query);

        ps.setString(1,user.getID().toString());
        ps.setString(2,user.getName());
        ps.setString(3,user.getSurname());
        ps.setDate(4, Date.valueOf(user.getDateOfBirth()));
        ps.setString(5,user.getCF());
        ps.setString(6,user.getHelmet().toString());
        ps.setDouble(7,user.getCredit());

        insertCount= ps.executeUpdate();

        for(DrivingLicense drivingLicense:user.getDrivingLicenses()){
            String query2="INSERT INTO shared_mobility.driving_license(DrivingLicenseType, user_id) VALUES (?, ?)";
            PreparedStatement ps2 = connectionHandler.getPreparedStatement(query);
            ps2.setString(1,drivingLicense.toString());
            ps2.setString(2,user.getID().toString());
            ps2.executeUpdate();
        }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return insertCount > 0;
    }

    @Override
    public boolean update(User user) {
        int updateCount=0;
        try {
            String query ="UPDATE shared_mobility.user SET name=?, surname=?, dateOfBirth=?, CF=?, helmet=?, credit=? WHERE ID = ?";
            ConnectionHandler connectionHandler = ConnectionHandler.getInstance();
            PreparedStatement ps = connectionHandler.getPreparedStatement(query);

            ps.setString(7,user.getID().toString());
            ps.setString(1,user.getName());
            ps.setString(2,user.getSurname());
            ps.setDate(3, Date.valueOf(user.getDateOfBirth()));
            ps.setString(4,user.getCF());
            ps.setString(5,user.getHelmet().toString());
            ps.setDouble(6,user.getCredit());

            updateCount= ps.executeUpdate();

//            for(DrivingLicense drivingLicense:user.getDrivingLicenses()){
//                String query2="INSERT INTO shared_mobility.driving_license(DrivingLicenseType, user_id) VALUES (?, ?)";
//                PreparedStatement ps2 = connectionHandler.getPreparedStatement(query);
//                ps2.setString(1,drivingLicense.toString());
//                ps2.setString(2,user.getID().toString());
//                ps2.executeUpdate();
//            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return updateCount > 0;
    }

    @Override
    public boolean delete(UUID id){
        try{
        String query = "DELETE FROM shared_mobility.user WHERE ID = ?";

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);

        ps.setString(1, id.toString());
        int deletedCount = ps.executeUpdate();
        return deletedCount > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        }

    @Override
    public User get(UUID id) {
        try{
            String query = "SELECT * FROM shared_mobility.user WHERE id = ?";

            ConnectionHandler ch = ConnectionHandler.getInstance();
            PreparedStatement ps = ch.getPreparedStatement(query);

            ps.setString(1, id.toString());
            ResultSet rs = ps.executeQuery();

            String query2="SELECT * FROM shared_mobility.driving_license WHERE user_id= ?";
            PreparedStatement ps2 = ch.getPreparedStatement(query);

            ps2.setString(1,rs.getString("ID"));
            ResultSet rs2 = ps2.executeQuery();

            List<DrivingLicense> list= new ArrayList<>();
            while (rs.next()) list.add(DrivingLicense.valueOf(rs.getString("DrivingLicenseType")));



            User user= new User((UUID.fromString(rs.getString("ID"))),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getDate("dateOfBirth").toLocalDate(),
                    rs.getString("CF"),
                    list,
                    Helmet.valueOf(rs.getString("helmet")),
                    rs.getDouble("credit"));

            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAll() {
        List<User> utenti=new ArrayList<>();
        try{
            String query = "SELECT * FROM utente WHERE cognome =?";

            ConnectionHandler ch = ConnectionHandler.getInstance();
            PreparedStatement ps = ch.getPreparedStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                String query2="SELECT * FROM shared_mobility.driving_license WHERE user_id= ?";
                PreparedStatement ps2 = ch.getPreparedStatement(query);
                ResultSet rs2 = ps2.executeQuery();

                List<DrivingLicense> list= new ArrayList<>();
                while (rs.next()) list.add(DrivingLicense.valueOf(rs.getString("DrivingLicenseType")));



                User user= new User((UUID.fromString(rs.getString("ID"))),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getDate("dateOfBirth").toLocalDate(),
                        rs.getString("CF"),
                        list,
                        Helmet.valueOf(rs.getString("helmet")),
                        rs.getDouble("credit"));
                utenti.add(user);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return utenti;
    }
}
