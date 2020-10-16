package ua.politeh;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;

public class Database {

    public final String PATHS = "./src/ua/politeh/filesS/";
    public final String PATHJ = "./src/ua/politeh/filesJ/";

    public ArrayList<Triangle> triangles;

    public Database() {
        triangles = new ArrayList<>();
    }

    /**
     * This method add new triangle to list
     *
     * @param side1 side1
     * @param side2 side2
     * @param side3 side3
     */
    public void addTriangle(double side1, double side2, double side3) {
        this.triangles.add(new Triangle(side1, side2, side3));
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < this.triangles.size(); i++) {
            result += "\nTriangle #" + ++i + "\n" + triangles.get(--i).toString() + "\n_________________________";
        }
        return result;
    }

    public void serialize(String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(PATHS + filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.triangles);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void deserialize(String filename) {
        filename = (filename == null) ? "db.txt" : filename;
        try {
            FileInputStream fileIn = new FileInputStream(PATHS + filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.triangles = (ArrayList<Triangle>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Triangle class not found");
            c.printStackTrace();
        }
    }

    public void jacksonSerialize(String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(PATHJ + filename), this);
    }

    public void jacksonDeserialize(String filename) throws IOException {
        filename = (filename == null) ? "db.json" : filename;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Database db1 = objectMapper.readValue(new File(PATHJ + filename), Database.class);
        this.triangles = db1.triangles;
    }


    /**
     * this method output list names of document
     *
     * @return Array of names of document
     */
    public String[] listFilesUsingJavaIO(String path) {
        File f = new File(path);
        return f.list();
    }

    /**
     * This method return name of document which will be backup
     *
     * @return name of document
     */
    public String nameFileS() {
        String[] l = this.listFilesUsingJavaIO(PATHS);
        String n = "db" + (l.length) + ".txt";
        return n;
    }

    public String nameFileJ() {
        String[] l = this.listFilesUsingJavaIO(PATHJ);
        String n = "db" + (l.length) + ".json";
        return n;
    }
}


