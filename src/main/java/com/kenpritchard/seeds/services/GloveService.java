package com.kenpritchard.seeds.services;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collection;

import org.deeplearning4j.bagofwords.vectorizer.BaseTextVectorizer;
import org.deeplearning4j.bagofwords.vectorizer.TextVectorizer;
import org.deeplearning4j.bagofwords.vectorizer.TfidfVectorizer;
import org.deeplearning4j.bagofwords.vectorizer.Builder;
import org.deeplearning4j.models.glove.CoOccurrences;
import org.deeplearning4j.models.glove.Glove;
import org.deeplearning4j.models.glove.GloveWeightLookupTable;
import org.deeplearning4j.models.word2vec.wordstore.inmemory.InMemoryLookupCache;
import org.deeplearning4j.text.sentenceiterator.CollectionSentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.EndingPreProcessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.nd4j.linalg.factory.Nd4j;
import org.springframework.stereotype.Component;

import com.kenpritchard.seeds.domain.GloveRequest;

@Component
public class GloveService {
	public Collection<String> getSimilarStrings(GloveRequest request) {
		Collection<String> similar = null;
        Nd4j.ENFORCE_NUMERICAL_STABILITY = true;
        int layerSize = 300;
        final EndingPreProcessor preProcessor = new EndingPreProcessor();
        SentenceIterator iter = new CollectionSentenceIterator(request.getInputStrings());
        InMemoryLookupCache cache = new InMemoryLookupCache();
        TokenizerFactory tokenizerFactory = new DefaultTokenizerFactory();
        TextVectorizer  textVectorizer = new TfidfVectorizer.Builder().cache(cache).iterate(iter).minWords(1).tokenize(tokenizerFactory).build();
        textVectorizer.fit();
        tokenizerFactory.setTokenPreProcessor(preProcessor);
        CoOccurrences coOccurrences = new CoOccurrences.Builder().cache(cache).iterate(iter).tokenizer(tokenizerFactory).build();
        coOccurrences.fit();

        GloveWeightLookupTable table = new GloveWeightLookupTable.Builder().cache(cache).lr(0.005).build();

        Glove glove = new Glove.Builder()
						        		.learningRate(0.005)
						        		.batchSize(1000)
						                .cache(cache).coOccurrences(coOccurrences).cache(cache)
						                .iterations(30).vectorizer(textVectorizer).weights(table)
						                .layerSize(layerSize).iterate(iter).tokenizer(tokenizerFactory).minWordFrequency(1).symmetric(true)
						                .windowSize(15).build();
        glove.fit();

        similar = glove.wordsNearest(request.getTargetWord(),20);
        return similar;
		
	}
}
