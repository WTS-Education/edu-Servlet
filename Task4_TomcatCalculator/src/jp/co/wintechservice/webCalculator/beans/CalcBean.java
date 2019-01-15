package jp.co.wintechservice.webCalculator.beans;


/**
 * 結果レジスタ(ボックスに表示されるオペランドを格納),
 * X・Yレジスタ(結果レジスタの値をコピーして格納、次の計算に備えるため)
 * @author kohari.junichirou
 *
 */
public class CalcBean {

    /**
     * 画面に表示される数字
     */
    private String input;
    /**
     * 計算結果
     */
    private double result;
    /**
     * X(計算用の変数)
     */
    private double x;
    /**
     * Y(計算用の変数)
     */
    private double y;
    /**
     * 前回押された演算子
     *
     */
    private String operator;


    //getter,setter
    public String getInput() {
        return input;
    }
    public void setInput(String input) {
        this.input = input;
    }

    public double getResult() {
        return result;
    }
    public void setResult(double result) {
        if (String.valueOf(result).length() < 17) {
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

    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }

}
