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
    StringBuilder expression = new StringBuilder();

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
    public StringBuilder getExpression() {
        return expression;
    }
    public void setExpression(String num, String operator) {
        if (num == "resetNumber") {
            expression.delete(0, expression.length());
        } else if (num == "changeOperator") {
            expression.append(getOutput());
        } else if (operator.equals("√")) {
            if (num.equals("hasRoot")) { //windows電卓は√入力するときスペース入っていない
                String[] expressionArray = expression.toString().split(" ");
                int rootIndex = expressionArray.length -1;
                String root = "√(" + getX() + ")";
                expressionArray[rootIndex] = root;
                expression.append(root);
                setX(root);
            } else {
                String rootFormat = "√(" + getOutput() + ")";
                expression.append(rootFormat + " ");
                setX(rootFormat);
            }
        } else if (operator.equals("x²")) {
            expression.append("sqr(").append(num).append(")");
        } else if (operator.equals("1/x")) {
            expression.append("1/(").append(num).append(")");
        }
        else {
            expression.append(num + " ");
            expression.append(operator + " ");
        }
    }


}
