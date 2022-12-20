package cr.ac.ucenfotec.util;

import java.io.FileInputStream;
import java.util.Properties;

public class Utils {
    public static String[] getProperties() throws Exception{
        String[] propiedades = new String[8];
        Properties p = new Properties();
        String path = "src\\cr\\ac\\ucenfotec\\bd.properties";

        try {
            p.load(new FileInputStream(path));
            propiedades[0] = p.getProperty("driver");
            propiedades[1] = p.getProperty("server");
            propiedades[2] = p.getProperty("dataBase");
            propiedades[3] = p.getProperty("useSSL");
            propiedades[4] = p.getProperty("allowPublicKeyRetrieval");
            propiedades[5] = p.getProperty("serverTimezone");
            propiedades[6] = p.getProperty("user");
            propiedades[7] = p.getProperty("password");

            return propiedades;

        }catch(Exception e){
            throw new Exception("Error al tratar de leer el archivo de propiedades");
        }
    }
}
