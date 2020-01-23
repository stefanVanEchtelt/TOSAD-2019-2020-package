package businessRuleBuilder;

import templates.Template;
import businessRule.BusinessRule;
import failure.Failure;
import join.Join;
import join.JoinService;
import rule.Rule;
import triggerType.TriggerType;

import java.util.List;

public class OracleBusinessRuleBuilder implements BusinessRuleBuilder {
    private String businessRule;
    private String header = "";
    private String declaration = "";
    private String joins = "";
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

    public void buildDeclaration(Rule rule) {
        String declarationContent = new Template("declarationTemplate").getContent();

        StringBuilder vars = new StringBuilder();
        for (String var: rule.getJoinableValues()) {
            vars.append(var.replace(".", "_"));
            vars.append(" " + var + "%type;");

            if (rule.getJoinableValues().indexOf(var) < rule.getJoinableValues().size() - 1) {
                vars.append("\n\t");
            }
        }

        declarationContent = declarationContent.replace("{{ vars_replacement }}", vars.toString());

        this.declaration = declarationContent;
    }

    public void buildJoins(Rule rule) {
        StringBuilder joinsContent = new StringBuilder();
        JoinService joinService = new JoinService();

        for (String value: rule.getJoinableValues()) {
            String[] splitValue = value.split("\\.", value.length());
            Join join = joinService.getJoinByTables(splitValue[0], rule.getColumn().getTableName());
            String joinTemplate = new Template("joinTemplate").getContent();

            joinTemplate = joinTemplate.replace("{{ select_replacement }}", value);
            joinTemplate = joinTemplate.replace("{{ variableName_replacement }}", value.replace(".", "_"));
            joinTemplate = joinTemplate.replace("{{ tableName_replacement }}", join.getFromTable() + ", " + join.getToTable());
            joinTemplate = joinTemplate.replace("{{ condition_replacement }}", join.getFromTable() + "." + join.getFromColumn() + " = " + join.getToTable() + "." + join.getToColumn());
            joinsContent.append(joinTemplate);

            if (rule.getJoinableValues().indexOf(value) < rule.getJoinableValues().size() - 1) {
                joinsContent.append("\n");
            }
        }

        this.joins = joinsContent.toString();
    }

    public void buildBody(Rule rule) {
        String bodyContent = new Template("bodyTemplate").getContent();

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
        this.businessRule = this.businessRule.replace("{{ declaration_replacement }}", this.declaration);
        this.businessRule = this.businessRule.replace("{{ join_replacement }}", this.joins);
        this.businessRule = this.businessRule.replace("{{ body_replacement }}", this.body);
        this.businessRule = this.businessRule.replace("{{ exceptions_replacement }}", this.failure);

        return this.businessRule;
    }
}