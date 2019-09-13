package com.sanjaygoyaljpr;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class streamsTest {

	/**
	 * 
	 * https://www.deadcoderising.com/2017-02-21-java-8-accumulate-your-streams-using-collectors/
	 * 
	 */

	public static void main(String[] args) {

		List<Article> articles = new ArrayList<Article>();

		List<Article> articlesList = articles.stream().collect(Collectors.toList());

		Set<Article> set = articles.stream().collect(Collectors.toSet());

		Map<String, Article> map = articles.stream().collect(Collectors.toMap(Article::getAuthor, Function.identity()));

		Double avg = articles.stream().collect(Collectors.averagingInt(Article::getWordCount));

		Double avg1 = articles.stream().collect(Collectors.averagingLong(Article::getWordCount));

		Integer sum = articles.stream().collect(Collectors.summingInt(Article::getWordCount));

		String a = articles.stream().map(Article::getTitle).collect(Collectors.joining());
		// Resulting string: title1title2

		String b = articles.stream().map(Article::getTitle).collect(Collectors.joining(", "));
		// Resulting string: title1, title2

		// Comparator
		Comparator<Article> wordCountComparator = (a1, a2) -> a1.getWordCount() - a2.getWordCount();

		Optional<Article> art = articles.stream().collect(Collectors.maxBy(wordCountComparator));

		Optional<Article> art1 = articles.stream().collect(Collectors.minBy(wordCountComparator));

		// Partition your stream
		/**
		 * Let’s say we would like to split the articles in two based on the
		 * count of words being more or less than 1000 words.
		 */
		Map<Boolean, List<Article>> map2 = articles.stream().collect(Collectors.partitioningBy(article -> article.getWordCount() > 1000));
		/**
		 * This will result in a map with two entries. One with the key true
		 * which contains the articles that satisfied the predicate and one with
		 * key false with the articles that didn’t satisfy the predicate.
		 */

	}

}
