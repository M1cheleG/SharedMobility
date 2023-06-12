package Dao.implement;

import Dao.DaoUser;
import Model.DrivingLicense;
import Model.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;

public class DaoUserCsv implements DaoUser {

    private Path usersCsv;
    private TreeMap<UUID,User> idsToUsers;

    public DaoUserCsv(Path usersCsv) {
        this.usersCsv = usersCsv;
        this.idsToUsers= new TreeMap<>();

        try {
        if(!Files.exists(usersCsv)) {
                Files.createFile(usersCsv);
        }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader br =Files.newBufferedReader(usersCsv)){
            String line;

            while ((line= br.readLine())!=null){
                String[] values =line.split(",");
                this.idsToUsers.put(UUID.fromString(values[0]),new User(UUID.fromString(values[0]),values[1],values[2], LocalDate.parse(values[3]),values[4],
                        List.of(DrivingLicense.valueOf(values[5])),Boolean.getBoolean(values[6]),Double.valueOf(values[7])));
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean insert(User user) {
        this.idsToUsers.put(user.getID(),user);
        return save();
    }

    @Override
    public boolean update(User user) {
        this.idsToUsers.put(user.getID(),user);
        return save();
    }

    @Override
    public boolean delete(UUID id) {
        User removedUser = idsToUsers.remove(id);

        if(removedUser!=null) {
            return save();
        }else {
            return false;
        }
    }

    @Override
    public User get(UUID id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }


    private boolean save() {
        try (BufferedWriter bw = Files.newBufferedWriter(this.usersCsv)) {
            for (User user : idsToUsers.values()) {
                List<String> values = Arrays.asList(
                        user.getID().toString(),
                        user.getName(),
                        user.getSurname(),
                        user.getDateOfBirth().toString(),
                        user.getCF(),
                        user.getDrivingLicenses().toString(),
                        Boolean.toString(user.isHelmet()),
                        Double.toString(user.getCredit())
                        );

                bw.write(String.join(",", values));
                bw.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}


