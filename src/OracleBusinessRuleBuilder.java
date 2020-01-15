import failure.Failure;
import rule.Rule;
import triggerType.TriggerType;

import java.util.List;

public class OracleBusinessRuleBuilder implements BusinessRuleBuilder {
    private String businessRule;

    public OracleBusinessRuleBuilder() {
        this.businessRule = new Template("businessRuleTemplate").getContent();
    }

    public void buildHeader(String triggerName, List<TriggerType> triggerTypes) {
        String headerContent = new Template("headerTemplate").getContent();

        String triggers = "";
        for (TriggerType triggerType: triggerTypes) {
            triggers += triggerType.getName();
            if (triggerTypes.indexOf(triggerType) < triggerTypes.size() - 1) {
                triggers += "/";
            }
        }
        headerContent = headerContent.replace("{{ trigger_types_replacement }}", triggers);
        headerContent = headerContent.replace("{{ trigger_name_replacement }}", "x");
        headerContent = headerContent.replace("{{ table_name_replacement }}", "x");


        this.businessRule = this.businessRule.replace("{{ header_replacement }}", headerContent);
    }

    public void buildBody(Rule rule, Failure exception) {
        String bodyContent = new Template("bodyTemplate").getContent();

        bodyContent = bodyContent.replace("{{ statement_replacement }}", rule.create());
        bodyContent = bodyContent.replace("{{ failure_name_replacement }}", exception.getName());

        this.businessRule = this.businessRule.replace("{{ body_replacement }}", bodyContent);
    }

    public void buildFailure(Failure exception) {
        String failureContent = new Template("exceptionTemplate").getContent();

        failureContent = failureContent.replace("{{ failure_name_replacement }}", exception.getName());
        failureContent = failureContent.replace("{{ failure_code_replacement }}", Integer.toString(exception.getCode()));
        failureContent = failureContent.replace("{{ failure_message_replacement }}", exception.getMessage());

        this.businessRule = this.businessRule.replace("{{ exceptions_replacement }}", failureContent);
    }

    public String build() {
        // TODO .....
        if (!this.businessRule.contains("_replacement")) {
            return this.businessRule;
        }

        return "";
    }
}