public class DeskovaHra {
    private String nazevHry;
    private boolean zakoupeno;
    private int oblibenost;

    public DeskovaHra(String nazevHry, boolean zakoupeno, int oblibenost) throws OblibenostException {
        this.nazevHry = nazevHry;
        this.zakoupeno = zakoupeno;
        setOblibenost(oblibenost);
    }

    public DeskovaHra(String nazevHry) throws OblibenostException {
        this(nazevHry, false, 1);
    }

    public String getNazevHry() {
        return nazevHry;
    }

    public void setNazevHry(String nazevHry) {
        this.nazevHry = nazevHry;
    }

    public boolean isZakoupeno() {
        return zakoupeno;
    }

    public void setZakoupeno(boolean zakoupeno) {
        this.zakoupeno = zakoupeno;
    }

    public int getOblibenost() {
        return oblibenost;
    }

    public void setOblibenost(int oblibenost) throws OblibenostException {
        if (oblibenost <= 0 || oblibenost > 3){
            throw new OblibenostException("Oblíbenost musí být v rozmezí 1-3");
        }
        this.oblibenost = oblibenost;
    }
}
