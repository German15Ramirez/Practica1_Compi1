package source;
import java_cup.runtime.*;
import java.io.StringReader;
import java.io.IOException;

%%
%{
StringBuilder stringBuilder = new StringBuilder();

private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
}

private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
}

// Método para realizar pruebas de análisis
public void testLexer(String input) throws IOException {
    yyreset(new StringReader(input));
    Symbol token;
    while ((token = next_token()).sym != sym.EOF) {
        System.out.println("Token: " + token.sym + ", Valor: " + token.value);
    }
}
%}

%class Lexer
%public
%line
%column
%cup
%unicode

%init{
    yyline = 1;
    yycolumn = 1;
%init}

WHITESPACE = [\t\n\r]+
DIGITO = [0-9]
NUMERO = {DIGITO}+(\.{DIGITO}+)?([eE][+-]?{DIGITO}+)?
LETRA = [a-zA-Z]
ID = {LETRA}({LETRA}|{DIGITO}|_)*

%%

{WHITESPACE} {}
"graficar" { return symbol(sym.GRAFICAR); }
"circulo" { return symbol(sym.CIRCULO); }
"cuadrado" { return symbol(sym.CUADRADO); }
"rectangulo" { return symbol(sym.RECTANGULO); }
"linea" { return symbol(sym.LINEA); }
"poligono" { return symbol(sym.POLIGONO); }
"animar" { return symbol(sym.ANIMAR); }
"objeto" { return symbol(sym.OBJETO); }
"anterior" { return symbol(sym.ANTERIOR); }
"curva" { return symbol(sym.CURVA); }
"recta" { return symbol(sym.RECTA); }

"," { return symbol(sym.COMA); }
"(" { return symbol(sym.PAR_IZQ); }
")" { return symbol(sym.PAR_DER); }

"+" { return symbol(sym.SUMA); }
"-" { return symbol(sym.RESTA); }
"*" { return symbol(sym.MULTIPLICACION); }
"/" { return symbol(sym.DIVISION); }

{ID} { return symbol(sym.ID, yytext()); }
{NUMERO} { return symbol(sym.NUMERO, Double.parseDouble(yytext())); }

"azul" { return symbol(sym.COLOR, "azul"); }
"rojo" { return symbol(sym.COLOR, "rojo"); }
"amarillo" { return symbol(sym.COLOR, "amarillo"); }
"verde" { return symbol(sym.COLOR, "verde"); }
"lila" { return symbol(sym.COLOR, "lila"); }
"negro" { return symbol(sym.COLOR, "negro"); }
"cafe" { return symbol(sym.COLOR, "cafe"); }
"naranja" { return symbol(sym.COLOR, "naranja"); }
"gris" { return symbol(sym.COLOR, "gris"); }

. {
    System.out.println("Error léxico: Caracter no reconocido '" + yytext() + "' en la línea "
    + yyline + ", columna " + yycolumn);
}