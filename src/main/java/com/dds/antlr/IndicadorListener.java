// Generated from E:/Fernando/Desktop/Diseno de Sistemas/dds2017Grupo9/src/main/antlr4\Indicador.g4 by ANTLR 4.7

	package com.dds.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IndicadorParser}.
 */
public interface IndicadorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IndicadorParser#indicador}.
	 * @param ctx the parse tree
	 */
	void enterIndicador(IndicadorParser.IndicadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link IndicadorParser#indicador}.
	 * @param ctx the parse tree
	 */
	void exitIndicador(IndicadorParser.IndicadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link IndicadorParser#termino}.
	 * @param ctx the parse tree
	 */
	void enterTermino(IndicadorParser.TerminoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IndicadorParser#termino}.
	 * @param ctx the parse tree
	 */
	void exitTermino(IndicadorParser.TerminoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IndicadorParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(IndicadorParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link IndicadorParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(IndicadorParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link IndicadorParser#numero}.
	 * @param ctx the parse tree
	 */
	void enterNumero(IndicadorParser.NumeroContext ctx);
	/**
	 * Exit a parse tree produced by {@link IndicadorParser#numero}.
	 * @param ctx the parse tree
	 */
	void exitNumero(IndicadorParser.NumeroContext ctx);
	/**
	 * Enter a parse tree produced by {@link IndicadorParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(IndicadorParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link IndicadorParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(IndicadorParser.IdContext ctx);
}