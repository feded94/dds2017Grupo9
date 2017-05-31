grammar Indicador;

@header {
	package dds;
}

indicador : termino ((SUM | RES) termino)* ;

termino  : factor ((MUL | DIV) factor)* ;

factor : numero | id | '(' indicador ')' ;

numero : DIGITO+ ;

id : LETRA (LETRA | numero | '_')* ;

SUM : '+' ;

MUL : '*' ;

RES : '-' ;

DIV : '/' ;

DIGITO : ('0' .. '9') ;

LETRA : ('A' .. 'Z') | ('a' .. 'z') ;

WS : [ \r\n\t] + -> channel (HIDDEN) ;
