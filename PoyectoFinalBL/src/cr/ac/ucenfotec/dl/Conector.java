package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.util.Utils;

public class Conector {

    private static AccesoBD coneccionBD = null;

    public static AccesoBD getConnector() throws Exception{
        String[] infoBD = Utils.getProperties();
        String URL = infoBD[0]+"//"+infoBD[1]+"/"+infoBD[2]+"?useSSL="+infoBD[3]+"&allowPublicKeyRetrieval="+infoBD[4]+"&serverTimezone="+infoBD[5];
        String user = infoBD[6];
        String password = infoBD[7];

        // singleton
        if(coneccionBD == null){
            coneccionBD = new AccesoBD(URL,user,password);
        }
        return coneccionBD;
    }
}
