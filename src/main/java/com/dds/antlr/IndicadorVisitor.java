// Generated from E:/Fernando/Desktop/Diseno de Sistemas/dds2017Grupo9/src/main/antlr4\Indicador.g4 by ANTLR 4.7

	package com.dds.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link IndicadorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface IndicadorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link IndicadorParser#indicador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndicador(IndicadorParser.IndicadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link IndicadorParser#termino}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermino(IndicadorParser.TerminoContext ctx);
	/**
	 * Visit a parse tree produced by {@link IndicadorParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(IndicadorParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link IndicadorParser#numero}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumero(IndicadorParser.NumeroContext ctx);
	/**
	 * Visit a parse tree produced by {@link IndicadorParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(IndicadorParser.IdContext ctx);
}