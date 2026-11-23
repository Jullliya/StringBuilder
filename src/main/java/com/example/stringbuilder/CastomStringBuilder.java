package com.example.stringbuilder;

import java.util.ArrayDeque;
import java.util.Deque;


public class CastomStringBuilder {

    private StringBuilder current = new StringBuilder();

    private final Deque<String> snapshots = new ArrayDeque<>();

    private final int maxHistory;

    public CastomStringBuilder() {
        this(0);
    }

    public CastomStringBuilder(int maxHistory) {
        this.maxHistory = Math.max(0, maxHistory);
    }

    private void snapshot() {
        snapshots.push(current.toString());
        if (maxHistory > 0 && snapshots.size() > maxHistory) {
            snapshots.removeLast();
        }
    }

    public CastomStringBuilder append(String s) {
        snapshot(); current.append(s); return this;
    }
    public CastomStringBuilder append(char c) {
        snapshot(); current.append(c); return this;
    }
    public CastomStringBuilder append(int i) {
        snapshot(); current.append(i); return this;
    }
    public CastomStringBuilder insert(int offset, String s) {
        snapshot(); current.insert(offset, s); return this;
    }
    public CastomStringBuilder delete(int start, int end) {
        snapshot(); current.delete(start, end); return this;
    }
    public CastomStringBuilder deleteCharAt(int index) {
        snapshot(); current.deleteCharAt(index); return this;
    }
    public CastomStringBuilder replace(int start, int end, String s) {
        snapshot(); current.replace(start, end, s); return this;
    }
    public CastomStringBuilder reverse()               { snapshot(); current.reverse(); return this; }
    public CastomStringBuilder setCharAt(int index, char c) {
        snapshot(); current.setCharAt(index, c); return this;
    }
    public void setLength(int newLength)                 { snapshot(); current.setLength(newLength); }

    public boolean undo() {
        if (snapshots.isEmpty()) {
            return false;
        }
        current = new StringBuilder(snapshots.pop());
        return true;
    }

    public boolean canUndo()  {
        return !snapshots.isEmpty();
    }
    public int historySize()  {
        return snapshots.size();
    }

    public int length() {
        return current.length();
    }
    public int capacity() {
        return current.capacity();
    }
    public char charAt(int index) {
        return current.charAt(index);
    }
    public String substring(int start) {
        return current.substring(start);
    }
    public String substring(int start, int end) {
        return current.substring(start, end);
    }
    public int indexOf(String s) {
        return current.indexOf(s);
    }

    @Override
    public String toString() {
        return current.toString();
    }
}