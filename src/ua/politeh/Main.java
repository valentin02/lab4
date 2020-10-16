package ua.politeh;



import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

    Database db = new Database();
    //FuncUtils.menu(db);
    //db.copyFileUsingChannel(new File(db.PATH + "db.txt"));
        db.addTriangle(2, 3, 4.5);
        db.addTriangle(2, 3, 4.5);
       db.addTriangle(2, 3, 4.5);
        db.addTriangle(2, 3, 4.5);
        db.jacksonSerialize("j.json");
        System.out.println(db.toString());
//    db.serialize(db.PATH+"db.txt");
     //   db.deserialize(db.PATH+"db.txt");
     // db.jacksonDeserialize("./src/ua/politeh/files/db_jackson1.json");
      //  System.out.println(db.toString());
      //  db.serializeFastJSON(db.PATH+"db.json");
       // db.deserialize(db.PATH+"db.json");

    }
}


