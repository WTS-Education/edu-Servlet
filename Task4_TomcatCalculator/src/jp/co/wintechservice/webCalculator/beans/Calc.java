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


    /**
     * 足し算
     * @return 足し算結果
     */
    public String add(){
        x += y;
        return result = String.valueOf(x);
    }
    /**
     * 引き算
     * @return 引き算結果
     */
    public String substract(){
        x -= y;
        return result = String.valueOf(x);
    }
    /**
     * 掛け算
     * @return 掛け算結果
     */
    public String multiply(){
        x *= y;
        return result = String.valueOf(x);
    }
    /**
     * 割り算
     * @return 割り算結果
     */
    public String divide() {
        x /= y;
        return result = String.valueOf(x);
    }

    //getter,setter
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
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
