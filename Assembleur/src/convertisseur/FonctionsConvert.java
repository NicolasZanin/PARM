package convertisseur;

public abstract class FonctionsConvert {
    String debutChaine;
    String[] listArgument;
    abstract String traiterNomAssembleur();

    public boolean checkImm(String[] listString){
        for(String chaine: listString) if(chaine.charAt(0) == '#') return true;
        return false;
    }

    public String getChaineBinaire(){
        return debutChaine + traiterNomAssembleur();
    }
}
