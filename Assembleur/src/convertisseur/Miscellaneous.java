package convertisseur;

public class Miscellaneous extends FonctionsConvert{
    public Miscellaneous(String[] listArgument){
        this.listArgument = listArgument;
        debutChaine = "10110000";
    }

    public String traiterArgImm(){
        int indiceImm = 2;
        if(listArgument[1].charAt(0) == 's' && listArgument[2].charAt(0) == 's'){
            indiceImm = 3;
        }
        String entier = listArgument[indiceImm].substring(1);
        int entierConverti = ConvertToBits.convertStrToInt(entier);

        return ConvertToBits.convertIntToBinaire((short) (entierConverti/4),(short) 7);
    }

    @Override
    public String traiterNomAssembleur() {
        return (listArgument[0].equals("add"))? " | 0 | " + traiterArgImm() : " | 1 | " + traiterArgImm();
    }
}
