grammar Gramatica;

@header {
	package dds;
}


 //Muestra el orden del Parser (derecha a izquierda, y de abajo hacia arriba)

PROGRAM: 'program';



expresion : termino ((SUM | RES) termino)* ;

termino  : factor ((MUL | DIV) factor)* ;

factor : NUMERO | '(' expresion ')';

NUMERO : DIGIT+ ;

SUM : '+' ;

MUL : '*' ;

RES : '-' ;

DIV : '/' ;

GT: '>';

LT: '<';

GEQ: '>=';

LEQ: '<=';

ASSIGN: '=';

BRACKET_OPEN: '{';

BRACKET_CLOSE: '}';

PAR_OPEN: '(';

PAR_CLOSE: ')';

SEMICOLON: ';';

ID: [a-zA-Z_][a-zA-z0-9_]*;

DIGIT : ('0' .. '9') ;



WS : [ \r\n\t] + -> channel (HIDDEN) ;


