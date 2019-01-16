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

    //getter,setter
    public String getOutput() {
        return output;
    }
    public void setOutput(String output) {
        if (String.valueOf(output).length() < 17) {
            this.output = output;
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


}
