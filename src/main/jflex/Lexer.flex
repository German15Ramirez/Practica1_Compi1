package source;
import java_cup.runtime.*;

%%
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

%{
StringBuffer string = new StringBuffer();

private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
}

private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
}
%}


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
    System.out.println("Error léxico: " + yytext() + ", en la línea: "
    + yyline + ", en la columna: " + yycolumn);
}
