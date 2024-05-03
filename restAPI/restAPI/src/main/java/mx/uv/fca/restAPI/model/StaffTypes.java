package mx.uv.fca.restAPI.model;

import lombok.ToString;

@ToString
public enum StaffTypes {
    TRANSLATOR("Translator"),
    REDRAWER("Redrawer"),
    COLORIST("Colorist"),
    CLEANER("Cleaner"),
    PROOFREADER("Proofreader");

    private final String title;

    private StaffTypes(String title) {
        this.title = title;
    }
}
