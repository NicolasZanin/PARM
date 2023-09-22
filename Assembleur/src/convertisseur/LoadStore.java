package convertisseur;

public class LoadStore extends FonctionsConvert{
    public LoadStore(String[] listArgument){
        this.listArgument = listArgument;
        debutChaine = "1001";
    }

    public String traiterArgRtImm(){
        String entier = listArgument[1].substring(1);
        int entierConverti = ConvertToBits.convertStrToInt(entier);
        String rt = ConvertToBits.convertIntToBinaire((short) entierConverti,(short) 3);
        String imm = "00000000";
        if(listArgument.length > 2){
            entier = listArgument[listArgument.length-1].substring(1);
            entierConverti = ConvertToBits.convertStrToInt(entier);
            imm = ConvertToBits.convertIntToBinaire((short) (entierConverti/4),(short) 8);
        }
        return rt + " | " + imm;
    }

    @Override
    String traiterNomAssembleur() {
        return (listArgument[0].equals("str"))? " | 0 | " + traiterArgRtImm(): " | 1 | " + traiterArgRtImm();
    }
}
