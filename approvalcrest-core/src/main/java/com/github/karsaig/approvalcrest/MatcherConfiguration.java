package com.github.karsaig.approvalcrest;

import org.hamcrest.Matcher;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;


public class MatcherConfiguration {

    private final Set<String> pathsToIgnore = new HashSet<>();
    private final Map<String, Matcher<?>> customMatchers = new HashMap<>();
    private final List<Class<?>> typesToIgnore = new ArrayList<>();
    private final List<Matcher<String>> patternsToIgnore = new ArrayList<>();
    private final List<Function<Object, Boolean>> skipCircularReferenceCheck = new ArrayList<>();
    private final Set<String> pathsToSort = new HashSet<>();
    private final List<Matcher<String>> patternsToSort = new ArrayList<>();

    public MatcherConfiguration() {
        skipCircularReferenceCheck.add(o -> Path.class.isInstance(o));
    }

    public Map<String, Matcher<?>> getCustomMatchers() {
        return customMatchers;
    }

    public Set<String> getPathsToIgnore() {
        return pathsToIgnore;
    }

    public List<Matcher<String>> getPatternsToIgnore() {
        return patternsToIgnore;
    }

    public List<Function<Object, Boolean>> getSkipCircularReferenceCheck() {
        return skipCircularReferenceCheck;
    }

    public List<Class<?>> getTypesToIgnore() {
        return typesToIgnore;
    }

    public Set<String> getPathsToSort() {
        return pathsToSort;
    }

    public List<Matcher<String>> getPatternsToSort() {
        return patternsToSort;
    }

    public MatcherConfiguration addPathToIgnore(String path) {
        pathsToIgnore.add(path);
        return this;
    }

    public MatcherConfiguration addPathToIgnore(String[] fieldPaths) {
        for (String fieldPath : fieldPaths) {
            pathsToIgnore.add(fieldPath);
        }
        return this;
    }

    public MatcherConfiguration addPathToIgnore(Collection<String> fieldPaths) {
        pathsToIgnore.addAll(fieldPaths);
        return this;
    }

    public MatcherConfiguration addCustomMatcher(String fieldPath, Matcher<?> matcher) {
        customMatchers.put(fieldPath, matcher);
        return this;
    }

    public MatcherConfiguration addTypeToIgnore(Class<?> clazz) {
        typesToIgnore.add(clazz);
        return this;
    }

    public MatcherConfiguration addTypeToIgnore(Class<?>[] clazzs) {
        for (Class<?> clazz : clazzs) {
            typesToIgnore.add(clazz);
        }
        return this;
    }

    public MatcherConfiguration addTypeToIgnore(Collection<Class<?>> clazzs) {
        typesToIgnore.addAll(clazzs);
        return this;
    }

    public MatcherConfiguration addPatternToIgnore(Matcher<String> fieldNamePattern) {
        patternsToIgnore.add(fieldNamePattern);
        return this;
    }

    public MatcherConfiguration addPatternToIgnore(Matcher<String>[] fieldNamePatterns) {
        for (Matcher<String> matcher : fieldNamePatterns) {
            patternsToIgnore.add(matcher);
        }
        return this;
    }

    public MatcherConfiguration addPatternToIgnore(Collection<Matcher<String>> fieldNamePattern) {
        patternsToIgnore.addAll(fieldNamePattern);
        return this;
    }

    public MatcherConfiguration addSkipCircularReferenceChecker(Function<Object, Boolean> checker) {
        skipCircularReferenceCheck.add(checker);
        return this;
    }


    public MatcherConfiguration addSkipCircularReferenceChecker(Function<Object, Boolean>[] checkers) {
        for (Function<Object, Boolean> actual : checkers) {
            skipCircularReferenceCheck.add(actual);
        }
        return this;
    }

    public MatcherConfiguration addPatternToSort(Matcher<String> fieldNamePattern) {
        patternsToSort.add(fieldNamePattern);
        return this;
    }

    public MatcherConfiguration addPatternToSort(Matcher<String>[] fieldNamePatterns) {
        for (Matcher<String> matcher : fieldNamePatterns) {
            patternsToSort.add(matcher);
        }
        return this;
    }

    public MatcherConfiguration addPatternToSort(Collection<Matcher<String>> fieldNamePattern) {
        patternsToSort.addAll(fieldNamePattern);
        return this;
    }

    public MatcherConfiguration addPathToSort(String path) {
        pathsToSort.add(path);
        return this;
    }

    public MatcherConfiguration addPathToSort(String[] fieldPaths) {
        for (String fieldPath : fieldPaths) {
            pathsToSort.add(fieldPath);
        }
        return this;
    }

    public MatcherConfiguration addPathToSort(Collection<String> fieldPaths) {
        pathsToSort.addAll(fieldPaths);
        return this;
    }
}
