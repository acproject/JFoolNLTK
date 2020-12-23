/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owiseman.ai.plan.test;
import java.util.ArrayList;
import me.midday.FoolNLTK;
import me.midday.lexical.AnalysisResult;
import me.midday.lexical.Entity;
import me.midday.lexical.LexicalAnalyzer;
import me.midday.lexical.Word;

import java.util.List;
/**
 *
 * @author hx_pc
 */
public class LSTMlexicalParserDemo {
    public static void main(String[] args) {
        String text = "南京市长江大桥";
        String text2 = "北京欢迎你";
        LexicalAnalyzer lexicalAnalyzer = FoolNLTK.getLSTMLexicalAnalyzer();
        
        // Participle
        List<List<Word>> words = lexicalAnalyzer.cut(text);
        words.forEach(ws -> {
            ws.forEach(System.out::println);
        });
        
        // Participle, POS Tagging, Named Entity Recognition
        List<AnalysisResult> results = lexicalAnalyzer.analysis(text);
        results.forEach(System.out::println);
        
        System.out.println();
        System.out.println("多文本");
        List<String> docs = new ArrayList<>();
        docs.add(text);
        docs.add(text2);
        List<List<Word>> dWords = lexicalAnalyzer.cut(docs);
        dWords.forEach(ws -> {
            ws.forEach(System.out::println);
        });
        
        // POS Tagging
        List<List<Word>> dPosWords = lexicalAnalyzer.pos(docs);
        dPosWords.forEach(ws-> {
            ws.forEach(System.out::println);
        });
        
        // Named Entity Recognition
        List<List<Entity>> dEntitys = lexicalAnalyzer.ner(docs);
        dEntitys.forEach(ents -> {
            ents.forEach(System.out::println);
        });
        // Participle, POS Tagging, Named Entity Recognition
         List<AnalysisResult>  dResults = lexicalAnalyzer.analysis(docs);
        dResults.forEach(System.out::println);
    }
}
