package code;

import java.util.Comparator;

public class ProsperityUntil100Comparator implements Comparator<Node>{
	
	@Override
    public int compare(Node n1, Node n2) {
        return Math.max(100-n1.getState().getProsperity(), 0) <  Math.max(100-n2.getState().getProsperity(), 0) ? -1 : 1;
    }

}
