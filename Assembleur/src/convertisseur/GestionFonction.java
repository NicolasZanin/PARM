package convertisseur;


public class GestionFonction {

    public int choiceClass(String[] lineSplit){
        String nomFonction = lineSplit[0];
        if( nomFonction.equals("lsls") || nomFonction.equals("lsrs") || nomFonction.equals("asrs") ) return sameNameFunctionDifferentArgument(lineSplit);
        else if ( nomFonction.equals("subs") ) return 1;
        else if ( nomFonction.equals("cmp") ) return ( lineSplit[2].charAt(0) == 'r' )? 2 : 1;
        else if ( nomFonction.equals("adds") ) return 1;
        else if ( nomFonction.equals("movs") ) return 1;
        else if ( nomFonction.equals("str") ) return 3;
        else if ( nomFonction.equals("ldr") ) return 3;
        else if ( nomFonction.equals("add") ) return 4;
        else if ( nomFonction.equals("sub") ) return 4;
        else if ( nomFonction.charAt(0) == 'b' && ( (nomFonction.length() == 1) || ( nomFonction.length() > 1 && nomFonction.charAt(1) != 'i') ) ) return 5;
        else return 2;
    }

    public String redirectionClass(String[] lineSplit, int nombre){
        FonctionsConvert fonctionsConvert;
        switch (nombre){
            case 1: fonctionsConvert = new SASM(lineSplit); break;
            case 2: fonctionsConvert = new DataProcesing(lineSplit); break;
            case 3: fonctionsConvert = new LoadStore(lineSplit); break;
            case 4: fonctionsConvert = new Miscellaneous(lineSplit); break;
            case 5: fonctionsConvert = new Branch(lineSplit); break;
            default: return null;
        }
        return fonctionsConvert.getChaineBinaire();
    }

    private int sameNameFunctionDifferentArgument(String[] lineSplit){
        return ( lineSplit.length == 4 )? 1 : 2;
    }

}
