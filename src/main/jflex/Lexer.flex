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
%}

%class Lexer
%public
%line
%column
%ignorecase
%cup
%unicode

%init{
    yyline = 1;
    yycolumn = 1;
%init}

DIGITO = [0-9]
NUMERO = {DIGITO}+(\.{DIGITO}+)?([eE][+-]?{DIGITO}+)?
LETRA = [a-zA-Z]
ID = {LETRA}({LETRA}|{DIGITO}|_)*

%%
"," { return symbol(sym.COMA, yytext()); }
[ \t\n\r]+ {/* Ignorar espacios en blanco */}
"graficar" { return symbol(sym.GRAFICAR, yytext()); }
"circulo" { return symbol(sym.CIRCULO, yytext()); }
"cuadrado" { return symbol(sym.CUADRADO, yytext()); }
"rectangulo" { return symbol(sym.RECTANGULO, yytext()); }
"linea" { return symbol(sym.LINEA, yytext()); }
"poligono" { return symbol(sym.POLIGONO, yytext()); }
"animar" { return symbol(sym.ANIMAR, yytext()); }
"objeto" { return symbol(sym.OBJETO, yytext()); }
"anterior" { return symbol(sym.ANTERIOR, yytext()); }
"curva" { return symbol(sym.CURVA, yytext()); }
"recta" { return symbol(sym.RECTA, yytext()); }

"(" { return symbol(sym.PAR_IZQ, yytext()); }
")" { return symbol(sym.PAR_DER, yytext()); }

"+" { return symbol(sym.SUMA, yytext()); }
"-" { return symbol(sym.RESTA, yytext()); }
"*" { return symbol(sym.MULTIPLICACION, yytext()); }
"/" { return symbol(sym.DIVISION, yytext()); }

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
    // Imprimir el mensaje de error léxico
    System.out.println("Error léxico: Caracter no reconocido '" + yytext() + "' en la fila "
    + yyline + ", columna " + yycolumn);

    // Imprimir la línea de separación
    System.out.println("--------------");
}