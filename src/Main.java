public class Main {
    public static void main(String[] args) throws OblibenostException {
        SpravceDeskovychHer s = new SpravceDeskovychHer();
        s.pridejDeskovku(new DeskovaHra("", false, 2));
        GUI gui = new GUI(s);
        gui.setVisible(true);

    }
}