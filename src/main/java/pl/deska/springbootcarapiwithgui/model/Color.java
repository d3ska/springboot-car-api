package pl.deska.springbootcarapiwithgui.model;

public enum Color {

    RED("Red"), BLUE("Blue"), GREEN("Green"), ORANGE("Orange"),
    YELLOW("Yellow"), PINK("Pink"), PURPLE("Purple"), VIOLET("Violet"),
    TURQUOISE("Turquoise"), GOLD("Gold"), LIME("Lime"), AQUA("Aqua"),
    NAVY("Navy"), CORAL("Coral"), TEAL("Teal"), BROWN("Brown"),
    WHITE("White"), BLACK("Black");

    private String value;

    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
