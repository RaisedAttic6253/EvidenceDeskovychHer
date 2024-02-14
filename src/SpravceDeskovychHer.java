import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SpravceDeskovychHer extends JFrame {
    private final ArrayList<DeskovaHra> seznamDeskovychHer = new ArrayList<>();
    public SpravceDeskovychHer() {
        cteni();
    }
    private void cteni() {
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader("DeskoveHry.txt")))) {
            while (sc.hasNextLine()) {
                String radek = sc.nextLine();
                String[] polozky = radek.split(";");
                String nazev = polozky[0];
                boolean zakoupeno = polozky[1].equals("ano");
                int oblibenost = Integer.parseInt(polozky[2]);
                seznamDeskovychHer.add(new DeskovaHra(nazev, zakoupeno, oblibenost));
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Soubor nebyl nalezen:" + e.getLocalizedMessage());
        } catch (OblibenostException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());

        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Špatný formát čísla:" + e.getLocalizedMessage());
        }
    }
    public void pridejDeskovku(DeskovaHra deskovaHra) {
        seznamDeskovychHer.add(deskovaHra);
    }

    public DeskovaHra getDeskovka(int index) {
        return seznamDeskovychHer.get(index);
    }

    public int getPocetDeskovek() {
        return seznamDeskovychHer.size();
    }

    public void setDeskovka(int indexAktualniDeskovky, DeskovaHra aktualniDeskovka) {
        seznamDeskovychHer.set(indexAktualniDeskovky, aktualniDeskovka);
        zapis();
    }

    private void zapis(){
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("deskovky.txt")))) {
            for (DeskovaHra deskovka : seznamDeskovychHer) {
                printWriter.println(deskovka.getNazevHry() + ";" + (deskovka.isZakoupeno() ? "ano" : "ne") + ";" + deskovka.getOblibenost());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
