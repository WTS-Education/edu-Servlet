package jp.co.wintechservice.webCalculator.beans;

/**
 * 結果レジスタ(ボックスに表示されるオペランドを格納),
 * X・Yレジスタ(結果レジスタの値をコピーして格納、次の計算に備えるため)
 * @author kohari.junichirou
 */
public class CalcBean {

    /**
     * 画面に表示する値
     */
    private String output;

    /**
     * 入力された値
     */
    private String input;

    /**
     * 前回押された演算子
     */
    private String operator;

    /**
     * 計算式
     */
    private String expression;

    private String x;


    //getter,setter
    public String getOutput() {
        return output;
    }
    public void setOutput(String output) {
        if (output.length() <16) {
            this.output = output;
        } else {
            this.output = output.substring(0, 16);
        }
    }

    public String getInput() {
        return input;
    }
    public void setInput(String input) {
        this.input = input;
    }

    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getX() {
        return x;
    }
    public void setX(String x) {
        this.x = x;
    }

    public String getExpression() {
        return expression;
    }
    public void setExpression(String expression) {
        this.expression = expression;
    }



}
