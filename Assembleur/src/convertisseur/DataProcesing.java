package convertisseur;

import java.util.Map;

public class DataProcesing extends FonctionsConvert{
    public DataProcesing(String[] listArgument){
        this.listArgument = listArgument;
        debutChaine = "010000";
    }

    public String traiterArg(){
        String entier = listArgument[2].substring(1);
        int entierConverti = ConvertToBits.convertStrToInt(entier);
        String R2 = ConvertToBits.convertIntToBinaire((short) entierConverti,(short) 3);

        entier = listArgument[1].substring(1);
        entierConverti = ConvertToBits.convertStrToInt(entier);
        String R1 = ConvertToBits.convertIntToBinaire((short) entierConverti,(short) 3);

        return R2 + " | " + R1;
    }

    @Override
    public String traiterNomAssembleur(){
        String nomAssembleur = listArgument[0];
        if (nomAssembleur.equals("ands")) return " | 0000 | " + traiterArg();
        else if (nomAssembleur.equals("eors")) return " | 0001 | " + traiterArg();
        else if (nomAssembleur.equals("lsls")) return " | 0010 | " + traiterArg();
        else if (nomAssembleur.equals("lsrs")) return " | 0011 | " + traiterArg();
        else if (nomAssembleur.equals("asrs")) return " | 0100 | " + traiterArg();
        else if (nomAssembleur.equals("adcs")) return " | 0101 | " + traiterArg();
        else if (nomAssembleur.equals("sbcs")) return " | 0110 | " + traiterArg();
        else if (nomAssembleur.equals("rors")) return " | 0111 | " + traiterArg();
        else if (nomAssembleur.equals("tst")) return " | 1000 | " + traiterArg();
        else if (nomAssembleur.equals("rsbs")) return " | 1001 | " + traiterArg();
        else if (nomAssembleur.equals("cmp")) return " | 1010 | " + traiterArg();
        else if (nomAssembleur.equals("cmn")) return " | 1011 | " + traiterArg();
        else if (nomAssembleur.equals("orrs")) return " | 1100 | " + traiterArg();
        else if (nomAssembleur.equals("muls")) return " | 1101 | " + traiterArg();
        else if (nomAssembleur.equals("bics")) return " | 1110 | " + traiterArg();
        else if (nomAssembleur.equals("mvns")) return " | 1111 | " + traiterArg();
        else return "";
    }
}
