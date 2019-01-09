package jp.co.wintechservice.webCalculator.logic;

/**
 * 電卓の計算ロジックを記述するクラス
 * @author KohariJunichiro
 *
 */
public class CalculationLogic {
    private double x;
    private double y;
    private String result;

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
    public String sub(){
        x -= y;
        return result = String.valueOf(x);
    }
    /**
     * 掛け算
     * @return 掛け算結果
     */
    public String multi(){
        x *= y;
        return result = String.valueOf(x);
    }
    /**
     * 割り算
     * @return 割り算結果
     */
    public String div() {
        x /= y;
        return result = String.valueOf(x);
    }

    //getter,setter
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
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }

}
