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
    yychar = 1;
%init}

WHITESPACE = [\t\n\r]+
DIGITO = [0-9]
NUMERO = {DIGITO}+(\.{DIGITO}+)?([eE][+-]?{DIGITO}+)?
LETRA = [a-zA-Z]
ID = {LETRA}({LETRA}|{DIGITO}|_)*

%%

{WHITESPACE} {}
"graficar" { return new Symbol(sym.GRAFICAR, yyline, yychar, yytext()); }


. {
    System.out.println("Este es un error léxico: " + yytext() + ", en la línea: "
    + yyline + ", en la columna: " + yychar);
}