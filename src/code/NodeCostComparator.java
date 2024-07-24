package code;
import java.util.Comparator;

public class NodeCostComparator implements Comparator<Node> {

    @Override
    public int compare(Node n1, Node n2) {
        return n1.getState().getMoneySpent() < n2.getState().getMoneySpent() ? -1 : 1;
    }
}
