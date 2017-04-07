package com.ansj.vec.model;

/**
 * Created by lvlonglong on 2017/4/7.
 */
public class MatchResultBean implements Comparable{
    private String matchedName;
    private double score;

    public String getMatchedName() {
        return matchedName;
    }

    public void setMatchedName(String matchedName) {
        this.matchedName = matchedName;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public MatchResultBean(String matchedName, double score) {
        this.matchedName = matchedName;
        this.score = score;
    }

    public static MatchResultBean of(String matchedName, double score) {
        return new MatchResultBean(matchedName, score);
    }

    @Override
    public int compareTo(Object o) {
        MatchResultBean other = (MatchResultBean)o;
        return this.score > other.score ? -1 : 1;
    }
}
