package pl.deska.springbootcarapiwithgui.model;

public class Range {
    private int from;
    private int to;

    public Range(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public Range() {
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
}
