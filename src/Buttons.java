public class Buttons {

    //Denne her klasse er en prototype som jeg bruger ind i System.out.print
    //så jeg taster instancerings navnet på denne klasse efterfulgte big- small- eller doubleButton metoden
    //og overdrager en tekst som parameter

    private String margeTop;
    private String margeCenter;
    private String margeBottom;

    public Buttons(String marge1, String marge2, String text) {
        this.margeTop = marge1;
        this.margeCenter = marge2;
        this.margeBottom = text;
    }

    public String bigButton(String text) {
        margeTop = " ------------------------------------------------------------------------------------------------ ";
        margeCenter = centerString(96, text);
        margeBottom = " ------------------------------------------------------------------------------------------------ ";
        return (margeTop + "\n" + margeCenter + "\n" + margeBottom);
    }

    public String dobbleButton(String text1, String text2) {
        margeTop = " ----------------------------------------------- ";
        margeCenter = centerString(47, text1);
        String margeCenter2 = centerString(47, text2);
        margeBottom = " ----------------------------------------------- ";
        return (margeTop + margeTop + "\n" + margeCenter + margeCenter2 + "\n" + margeBottom + margeBottom);

    }


    public String smallButton(String text) {
        margeTop = " ----------------------------------------------- ";
        margeCenter = centerString(47, text);
        margeBottom = " ----------------------------------------------- ";
        return (margeTop + "\n" + margeCenter + "\n" + margeBottom);

    }

    public static String centerString(int width, String s) {
        return String.format("|%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s)) + "|";
    }

}
