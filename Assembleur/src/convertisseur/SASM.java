package convertisseur;

public class SASM extends FonctionsConvert{

    public SASM(String[] listArgument){
        this.listArgument = listArgument;
        debutChaine = "00";
    }

    public String traiterArgImmRmRd(){
        String entier = listArgument[3].substring(1);
        int entierConverti = ConvertToBits.convertStrToInt(entier);
        String imm = ConvertToBits.convertIntToBinaire((short) entierConverti,(short) 5);

        entier = listArgument[2].substring(1);
        entierConverti = ConvertToBits.convertStrToInt(entier);
        String rm = ConvertToBits.convertIntToBinaire((short) entierConverti,(short) 3);

        entier = listArgument[1].substring(1);
        entierConverti = ConvertToBits.convertStrToInt(entier);
        String rd = ConvertToBits.convertIntToBinaire((short) entierConverti,(short) 3);

        return imm + " | " + rm + " | " + rd;
    }

    public String traiterArgRdImm(){
        String entier = listArgument[2].substring(1);
        int entierConverti = ConvertToBits.convertStrToInt(entier);
        String imm = ConvertToBits.convertIntToBinaire((short) entierConverti,(short) 8);

        entier = listArgument[1].substring(1);
        entierConverti = ConvertToBits.convertStrToInt(entier);
        String rd = ConvertToBits.convertIntToBinaire((short) entierConverti,(short) 3);


        return rd + " | " + imm;
    }

    public String traiterArgImmRnRd(){
        String entier = listArgument[3].substring(1);
        int entierConverti = ConvertToBits.convertStrToInt(entier);
        String imm = ConvertToBits.convertIntToBinaire((short) entierConverti,(short) 3);

        entier = listArgument[2].substring(1);
        entierConverti = ConvertToBits.convertStrToInt(entier);
        String rn = ConvertToBits.convertIntToBinaire((short) entierConverti,(short) 3);

        entier = listArgument[1].substring(1);
        entierConverti = ConvertToBits.convertStrToInt(entier);
        String rd = ConvertToBits.convertIntToBinaire((short) entierConverti,(short) 3);

        return imm + " | " + rn + " | " + rd;
    }

    public String traiterArgRmRnRd(){
        String entier = listArgument[3].substring(1);
        int entierConverti = ConvertToBits.convertStrToInt(entier);
        String rm = ConvertToBits.convertIntToBinaire((short) entierConverti,(short) 3);

        entier = listArgument[2].substring(1);
        entierConverti = ConvertToBits.convertStrToInt(entier);
        String rn = ConvertToBits.convertIntToBinaire((short) entierConverti,(short) 3);

        entier = listArgument[1].substring(1);
        entierConverti = ConvertToBits.convertStrToInt(entier);
        String rd = ConvertToBits.convertIntToBinaire((short) entierConverti,(short) 3);

        return rm + " | " + rn + " | " + rd;
    }

    public String traitermovs(){
        String imm = "00000";

        String entier = listArgument[2].substring(1);
        int entierConverti = ConvertToBits.convertStrToInt(entier);
        String rm = ConvertToBits.convertIntToBinaire((short) entierConverti,(short) 3);

        entier = listArgument[1].substring(1);
        entierConverti = ConvertToBits.convertStrToInt(entier);
        String rd = ConvertToBits.convertIntToBinaire((short) entierConverti,(short) 3);

        return imm + " | " + rm + " | " + rd;
    }

    @Override
    public String traiterNomAssembleur(){
        String nomAssembleur = listArgument[0];
        if (nomAssembleur.equals("lsls")) return " | 000 | " + traiterArgImmRmRd();
        else if (nomAssembleur.equals("lsrs")) return " | 001 | " + traiterArgImmRmRd();
        else if (nomAssembleur.equals("asrs")) return " | 010 | " + traiterArgImmRmRd();
        else if (nomAssembleur.equals("adds")){
            if(listArgument.length == 3) return " | 110 | " + traiterArgRdImm();
            else if(checkImm(listArgument)) return " | 01110 | " + traiterArgImmRnRd();
            else return " | 01100 | " +  traiterArgRmRnRd();
        }
        else if(nomAssembleur.equals("subs")){
            if(listArgument.length == 3) return " | 111 | " + traiterArgRdImm();
            else if(checkImm(listArgument)) return " | 01111 | " + traiterArgImmRnRd();
            else return " | 01101 | " + traiterArgRmRnRd();
        }
        else if(nomAssembleur.equals("movs")){
            if(checkImm(listArgument)) return " | 100 | " + traiterArgRdImm();
            else return " | 000 | " + traitermovs();
        }
        else return " | 101 | " + traiterArgRdImm();
    }
}
