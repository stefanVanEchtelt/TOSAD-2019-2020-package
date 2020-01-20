import Util.Template;
import businessRule.BusinessRule;
import failure.Failure;
import rule.Rule;
import triggerType.TriggerType;

import java.util.List;

public class OracleBusinessRuleBuilder implements BusinessRuleBuilder {
    private String businessRule;
    private String header = "";
    private String body = "";
    private String failure = "";

    OracleBusinessRuleBuilder() {
        this.businessRule = new Template("businessRuleTemplate").getContent();
    }

    public void buildHeader(BusinessRule businessRule, List<TriggerType> triggerTypes) {
        String headerContent = new Template("headerTemplate").getContent();

        String triggers = "";
        for (TriggerType triggerType: triggerTypes) {
            triggers += triggerType.getName();
            if (triggerTypes.indexOf(triggerType) < triggerTypes.size() - 1) {
                triggers += " or ";
            }
        }
        headerContent = headerContent.replace("{{ trigger_types_replacement }}", triggers);
        headerContent = headerContent.replace("{{ trigger_name_replacement }}", businessRule.getName());
        headerContent = headerContent.replace("{{ table_name_replacement }}", businessRule.getTable());

        this.header = headerContent;
    }

    public void buildBody(Rule rule) {
        String bodyContent = new Template("bodyTemplate").getContent();

        // TODO joins???

        bodyContent = bodyContent.replace("{{ statement_replacement }}", rule.create());

        this.body = bodyContent;
    }

    public void buildFailure(Failure exception) {
        String failureContent = new Template("exceptionTemplate").getContent();

        failureContent = failureContent.replace("{{ failure_name_replacement }}", exception.getName());
        failureContent = failureContent.replace("{{ failure_code_replacement }}", Integer.toString(exception.getCode()));
        failureContent = failureContent.replace("{{ failure_message_replacement }}", exception.getMessage());

        this.failure = failureContent;
    }

    public String build() {
        this.businessRule = this.businessRule.replace("{{ header_replacement }}", this.header);
        this.businessRule = this.businessRule.replace("{{ body_replacement }}", this.body);
        this.businessRule = this.businessRule.replace("{{ exceptions_replacement }}", this.failure);

        return this.businessRule;
    }
}