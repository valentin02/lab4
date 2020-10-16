package ua.politeh;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ua.politeh.Triangle;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {

   // public final String PATH = "./src/ua/politeh/files/";

    public ArrayList<Triangle> triangles ;

    public Database(){
        triangles = new ArrayList<>();
    }


    /*public Database(ArrayList<Triangle> triangles) {
        this.triangles = triangles;
    }*/

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

    /**
     * This method save data in file
     *
     * @param filename name of file
     * @throws IOException
     */
    /*public void save(String filename) throws IOException {

        FileOutputStream outStream = new FileOutputStream(PATH + filename);
        BufferedOutputStream bw = new BufferedOutputStream(outStream);

        double[] temp;
        String _t = "";
        for (int i = 0; i < triangles.size(); i++) {
            temp = triangles.get(i).getSides();
            _t += temp[0] + "\n " + temp[1] + "\n " + temp[2] + "\n";
        }

        byte[] b = _t.getBytes();
        bw.write(b, 0, b.length);
        bw.close();
        outStream.close();
    }
*/
    /**
     * This method read data from the file
     *
     * @param filename name of file
     * @throws IOException
     */
    /*public void load(String filename) throws IOException {
        triangles.clear();
        Scanner scanner = new Scanner(new FileInputStream(PATH + filename));
        double s1 = -1, s2 = -1, s3 = -1;
        while (scanner.hasNextLine()) {
            try {
                s1 = Double.valueOf(scanner.nextLine());
                s2 = Double.valueOf(scanner.nextLine());
                s3 = Double.valueOf(scanner.nextLine());
                addTriangle(s1, s2, s3);
            } catch (NumberFormatException exception) {
                continue;
            }
        }
        scanner.close();
    }*/

    public void serialize(String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.triangles);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void deserialize(String filename) {
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.triangles = (ArrayList<Triangle>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Student class not found");
            c.printStackTrace();
        }
    }

    public void jacksonSerialize(String filename) throws IOException {
        new ObjectMapper().writeValue(new File(filename), this);
    }

    public void jacksonDeserialize(String filename) throws IOException {
        Database db1 = new ObjectMapper().readValue(new File(filename), Database.class);
      //  this.triangles = db1.triangles;
    }

  /*public void serializeFastJSON(String filename) throws IOException {
      FileWriter outStream = new FileWriter(filename);
      BufferedWriter bw = new BufferedWriter(outStream);
      bw.write(JSON.toJSONString(this.triangles));
      bw.close();
      outStream.close();
  }

    public void deserializeFastJSON(String filename) throws IOException {
        Scanner scanner = new Scanner(new FileReader(filename));
        this.clear();
        double x1, x2, x3;
        ArrayList<JSONObject> JSOList = JSON.parseObject(scanner.nextLine(), ArrayList.class);
        for (JSONObject st : JSOList) {
        //    this.addTriangle(new Triangle(st.getDouble("sides")));
            x1 =st.getDouble("area");
            this.addTriangle(x1,x1,x1);
        }
        scanner.close();
    }*/


    private void clear() {
      this.triangles.clear();
    }

    /**
     * this method output list names of document
     *
     * @return Array of names of document
     */
    public String[] listFilesUsingJavaIO() {
        File f = new File("./src/ua/politeh/files/");
        return f.list();
    }

    /**
     * This method return name of document which will be backup
     *
     * @return name of document
     */
    public String nameFile() {
        String[] l = this.listFilesUsingJavaIO();
        String n = "./src/ua/politeh/files/" + "db" + (l.length) + ".txt";
        return n;
    }
}


