package source;
import java_cup.runtime.*;
import source.backend.Reportes.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import source.backend.herramientas.*;


%%
%public
%class Lexer
%unicode
%line
%column
%ignorecase
%cup

ID = [a-zA-Z_][a-zA-Z0-9_]*[a-zA-Z0-9-]*

%{
    public static ArrayList<Errores> errores = new ArrayList<>();
    public static ArrayList<Token> tokens = new ArrayList<>();
    public static ArrayList<OperadorAritmetico> operadorAritmetico = new ArrayList<>();

    public ArrayList<Errores> getErrores() {
        return errores;
    }

%}


%state OPERATOR_STATE

%%
"azul"            { return new Symbol(sym.AZUL, yyline+1, yycolumn+1, yytext()); }
"rojo"            { return new Symbol(sym.ROJO, yyline+1, yycolumn+1, yytext()); }
"amarillo"        { return new Symbol(sym.AMARILLO, yyline+1, yycolumn+1, yytext()); }
"verde"           { return new Symbol(sym.VERDE, yyline+1, yycolumn+1, yytext()); }
"negro"           { return new Symbol(sym.NEGRO, yyline+1, yycolumn+1, yytext()); }
"lila"            { return new Symbol(sym.LILA, yyline+1, yycolumn+1, yytext()); }
"cafe"            { return new Symbol(sym.CAFE, yyline+1, yycolumn+1, yytext()); }
"naranja"         { return new Symbol(sym.NARANJA, yyline+1, yycolumn+1, yytext()); }
"gris"            { return new Symbol(sym.GRIS, yyline+1, yycolumn+1, yytext()); }

"línea"           { return new Symbol(sym.LINEA, yyline+1, yycolumn+1, yytext()); }
"curva"           { return new Symbol(sym.CURVA, yyline+1, yycolumn+1, yytext()); }

"graficar"        { return new Symbol(sym.GRAFICAR, yyline+1, yycolumn+1, yytext()); }
"animar"          { return new Symbol(sym.ANIMAR, yyline+1, yycolumn+1, yytext()); }
"circulo"         { return new Symbol(sym.CIRCULO, yyline+1, yycolumn+1, yytext()); }
"cuadrado"        { return new Symbol(sym.CUADRADO, yyline+1, yycolumn+1, yytext()); }
"rectangulo"      { return new Symbol(sym.RECTANGULO, yyline+1, yycolumn+1, yytext()); }
"linea"           { return new Symbol(sym.LINEA_OBJ, yyline+1, yycolumn+1, yytext()); }
"poligono"        { return new Symbol(sym.POLIGONO, yyline+1, yycolumn+1, yytext()); }
"objeto"          { return new Symbol(sym.OBJETO, yyline+1, yycolumn+1, yytext()); }
"anterior"        { return new Symbol(sym.ANTERIOR, yyline+1, yycolumn+1, yytext()); }

[ \t\n\r\f]       {}

"+"               { operadorAritmetico.add(new OperadorAritmetico("SUMA", yytext(), yyline+1, yycolumn+1, 1)); return new Symbol(sym.SUMA, yyline+1, yycolumn+1, yytext()); }
"-"               { operadorAritmetico.add(new OperadorAritmetico("RESTA", yytext(), yyline+1, yycolumn+1, 1)); return new Symbol(sym.RESTA, yyline+1, yycolumn+1, yytext()); }
"*"               { operadorAritmetico.add(new OperadorAritmetico("MULTIPLICACIÓN", yytext(), yyline+1, yycolumn+1, 1)); return new Symbol(sym.MULTIPLICACION, yyline+1, yycolumn+1, yytext()); }
"/"               { operadorAritmetico.add(new OperadorAritmetico("DIVISIÓN", yytext(), yyline+1, yycolumn+1, 1)); return new Symbol(sym.DIVISION, yyline+1, yycolumn+1, yytext()); }
"("               { return new Symbol(sym.PAR_IZQ, yyline+1, yycolumn+1, yytext()); }
")"               { return new Symbol(sym.PAR_DER, yyline+1, yycolumn+1, yytext()); }
","               { return new Symbol(sym.COMA, yyline+1, yycolumn+1, yytext()); }

{ID}              { return new Symbol(sym.ID, yytext()); }
[0-9]+\.[0-9]+    { return new Symbol(sym.NUMERO, Double.parseDouble(yytext())); }
[0-9]+            { return new Symbol(sym.NUMERO, Integer.parseInt(yytext())); }
<<EOF>>           { return new Symbol(sym.EOF); }
[^]               {
                     errores.add(new Errores(yytext(), yyline + 1, yycolumn + 1, "Léxico", "Caracter desconocido: " + yytext()));
                     System.err.println("Error léxico: " + yytext() + " linea: " + String.valueOf(yyline + 1) + " columna: " + String.valueOf(yycolumn + 1));
                 }

                 