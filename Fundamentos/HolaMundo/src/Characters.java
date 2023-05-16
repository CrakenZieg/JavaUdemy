
public class Characters {

    public static void main(String args[]) {

        char conSimbolo = '!';
        System.out.println("Como SimboloChar = " + conSimbolo + " ('!')");

        char conUnicode = '\u0021';
        System.out.println("Como UnicodeChar = " + conUnicode + " ('\\u0021')");

        char conDecimal = 33;
        System.out.println("Como DecimalChar = " + conDecimal + " (33)");
        
        var conSimboloVar = '!';
        System.out.println("Como SimboloVar = " + conSimboloVar + " ('!')");

        var conUnicodeVar = '\u0021';
        System.out.println("Como UnicodeVar = " + conUnicodeVar + " ('\\u0021')");

        var conDecimalVar = 33;
        System.out.println("Como DecimalVar = " + conDecimalVar + " (33)");
        
        var conDecimalVarChar = (char)33;
        System.out.println("Como DecimalVarChar = " + conDecimalVarChar + " (char)(33)");
        
        int varIntChar = '!';
        System.out.println("Como varIntChar = " + varIntChar + " (int varIntChar = '!')");

    }

}
