import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/15/14:53
 * @Description:
 */
class Data{
    public Data() {
    }
    private String dataId;
    private String name;

    public Data(String dataId, String name) {
        this.dataId = dataId;
        this.name = name;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Rule{
    public Rule() {
    }
    private String ruleId;
    private String condition;

    public Rule(String ruleId, String condition) {
        this.ruleId = ruleId;
        this.condition = condition;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}

class Result{
    public Result() {
    }
    private String dataId;
    private String ruleId;

    public Result(String dataId, String ruleId) {
        this.ruleId = ruleId;
        this.dataId = ruleId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }
}
public class Test2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<Data> datas = new ArrayList<>();
        List<Rule> rules = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (Rule rule : rules){
            String condition = rule.getCondition();
            map.put(rule.getRuleId(),rule.getCondition());
        }
        for (Data data : datas){
            if(map.containsKey(data.getName())){
                
            }
        }

    }
}
