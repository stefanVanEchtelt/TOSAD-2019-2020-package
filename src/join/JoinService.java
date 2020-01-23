package join;

public class JoinService {
    public Join getJoinByTables(String fromTable, String toTable) {
        Join join = new Join(fromTable, toTable);
        return join.loadFullJoin();
    }
}
