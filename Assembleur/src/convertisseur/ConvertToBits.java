package convertisseur;

public class ConvertToBits {

    private ConvertToBits() {
        throw new IllegalStateException();
    }

    public static short convertStrToInt(String chiffre){
        short nombre = 0;

        for( short i = 0; i<chiffre.length(); i++ ) {
            if(chiffre.charAt(i) < '0' || chiffre.charAt(i) > '9') break;
            nombre *= 10;
            nombre += (chiffre.charAt(i) - '0');
        }

        return nombre;
    }

    public static String convertIntToBinaire(short entier, short bits){
        StringBuilder binaire = new StringBuilder();

        while( entier > 0 ) {
            binaire.insert(0, (entier % 2));
            entier /= 2;
        }

        for(short i = (short) binaire.length(); i < bits; i++) binaire.insert( 0,"0" );

        return binaire.toString();
    }

    public static String convertIntToBinaireComplementary(short entier, short bits){
        if(entier < 0){
            StringBuilder binaire = new StringBuilder(convertIntToBinaire((short) -entier, bits));
            int lastOne = binaire.length();
            for(int i = 0;i < binaire.length();i++){
                if(binaire.charAt(i) == '1') lastOne = i;
            }
            for(int i = 0; i < lastOne;i++){
                binaire.replace(i,i+1,(binaire.charAt(i) == '0')? "1":"0");
            }
            return binaire.toString();
        }
        else return convertIntToBinaire(entier, bits);
    }



    public static String convertBitsToHexa(String binaire){
        StringBuilder hexa = new StringBuilder();
        short i = 0;
        short indiceTab = 0;
        short count = 0;
        String[] listSplitHexa = new String[4];

        for(i = 0; i < 4; i++) listSplitHexa[i] = "";

        i = 0;
        while ( i < binaire.length()  &&  indiceTab < 4) {
            if ( binaire.charAt(i) >= '0' && binaire.charAt(i) <= '9') {
                listSplitHexa[indiceTab] += binaire.charAt(i);
                count++;

                if (count == 4 && i != binaire.length() - 1) {
                    indiceTab++;
                    count = 0;
                }
            }
            i++;
        }

        for (i = 0; i <= indiceTab; i++) {
            hexa.append( convertMorceauBitsToHexa(listSplitHexa[i]) );
        }

        return hexa.toString();
    }

    private static char convertMorceauBitsToHexa(String binaire){
        short nombreTemp = 0;
        short i = (short) 0;

        while ( i < binaire.length() ) {
            nombreTemp *= 2;
            nombreTemp += (short) ( binaire.charAt(i) - '0' );
            i++;
        }

        if ( nombreTemp >= 16 ) throw new ArithmeticException( "Le nombre doit pas être > 16" );
        else if ( nombreTemp < 10 ) return (char) ( nombreTemp + '0' );
        else return (char) ( nombreTemp - 10 + 'a' );
    }

}
