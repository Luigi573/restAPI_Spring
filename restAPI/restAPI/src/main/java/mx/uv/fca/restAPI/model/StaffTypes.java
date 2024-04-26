package mx.uv.fca.restAPI.model;

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

    @Override
    public String toString() {
        return title;
    }
}
