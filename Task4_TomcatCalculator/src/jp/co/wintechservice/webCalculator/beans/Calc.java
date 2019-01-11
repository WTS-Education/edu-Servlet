package jp.co.wintechservice.webCalculator.beans;


/**
 * 結果レジスタ(ボックスに表示されるオペランドを格納),
 * X・Yレジスタ(結果レジスタの値をコピーして格納、次の計算に備えるため)
 * @author kohari.junichirou
 *
 */
public class Calc {
    /**
     * 結果レジスタ(ボックスに表示されるオペランド)
     */
    private String result;
    /**
     * Xレジスタ
     */
    private double x;
    /**
     * Yレジスタ
     */
    private double y;



    //getter,setter
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        if (result.length() < 17) {
            this.result = result;
        }
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

}
