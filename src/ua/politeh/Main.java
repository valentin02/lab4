package ua.politeh;

import lombok.SneakyThrows;

import java.io.IOException;

public class Main {

    @SneakyThrows
    public static void main(String[] args) throws IOException {
        Database db = new Database();
        while (true) {
            String menu = "What would you prefer to work with: \n 1 usual serialisation \n 2 Jackson serialisation \n \n Please input number: ";
            System.out.println(menu);
            switch ((int) FuncUtils.checkNum()) {
                case 1:
                    FuncUtils.menuS(db);
                    db.serialize(db.nameFileS());
                    return;
                case 2:
                    FuncUtils.menuJ(db);
                    db.jacksonSerialize(db.nameFileJ());
                    return;
            }
        }
    }

}


