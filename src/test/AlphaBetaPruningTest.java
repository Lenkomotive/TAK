import algorithm.Node;
import algorithm.PruningHelper;
import algorithm.Tree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlphaBetaPruningTest {
    @Test
    public void alphaBetaPruneTest() {
        Node child25 = new Node(null,true,null,null);
        child25.val = -25;
        Node child31 = new Node(null,true,null,null);
        child31.val = -31;
        Node child32 = new Node(null,true,null,null);
        child32.val = -32;
        Node child44 = new Node(null,true,null,null);
        child44.val = -44;
        Node child13 = new Node(null,true,null,null);
        child13.val = 13;
        Node child3 = new Node(null,true,null,null);
        child3.val = 3;
        Node child12 = new Node(null,true,null,null);
        child12.val = -12;
        Node child47 = new Node(null,true,null,null);
        child47.val = 47;
        Node child34 = new Node(null,true,null,null);
        child34.val = 34;
        Node child22 = new Node(null,true,null,null);
        child22.val = 22;

        Tree tree = new Tree(null);

        tree.root.children.add(new Node(null,true,null,null));
        tree.root.children.add(new Node(null,true,null,null));
        tree.root.children.add(new Node(null,true,null,null));
        tree.root.children.get(0).children.add(new Node(null,false,null,null));
        tree.root.children.get(0).children.add(new Node(null,false,null,null));
        tree.root.children.get(0).children.add(new Node(null,false,null,null));
        tree.root.children.get(1).children.add(new Node(null,false,null,null));
        tree.root.children.get(1).children.add(new Node(null,false,null,null));
        tree.root.children.get(2).children.add(new Node(null,false,null,null));
        tree.root.children.get(2).children.add(new Node(null,false,null,null));

        tree.root.children.get(0).children.get(0).children.add(child25);
        tree.root.children.get(0).children.get(0).children.add(child31);
        tree.root.children.get(0).children.get(1).children.add(child32);
        tree.root.children.get(0).children.get(2).children.add(child44);

        tree.root.children.get(1).children.get(0).children.add(child13);
        tree.root.children.get(1).children.get(1).children.add(child3);
        tree.root.children.get(1).children.get(1).children.add(child12);

        tree.root.children.get(2).children.get(0).children.add(child47);
        tree.root.children.get(2).children.get(1).children.add(child34);
        tree.root.children.get(2).children.get(1).children.add(child22);
        Assertions.assertEquals(34, PruningHelper.alphaBetaPrune(tree.root, -1000, 1000));
    }

    @Test
    public void alphaBetaPruneTest2() {
        Node child25 = new Node(null,true,null,null);
        child25.val = -25;
        Node child31 = new Node(null,true,null,null);
        child31.val = -31;
        Node child32 = new Node(null,true,null,null);
        child32.val = -32;
        Node child44 = new Node(null,true,null,null);
        child44.val = -44;
        Node child13 = new Node(null,true,null,null);
        child13.val = 13;
        Node child3 = new Node(null,true,null,null);
        child3.val = 3;
        Node child12 = new Node(null,true,null,null);
        child12.val = -12;
        Node child47 = new Node(null,true,null,null);
        child47.val = 47;
        Node child34 = new Node(null,true,null,null);
        child34.val = 34;
        Node child22 = new Node(null,true,null,null);
        child22.val = 22;

        Tree tree = new Tree(null);

        tree.root.children.add(new Node(null,true,null,null));
        tree.root.children.add(new Node(null,true,null,null));
        tree.root.children.add(new Node(null,true,null,null));
        tree.root.children.get(0).children.add(new Node(null,false,null,null));
        tree.root.children.get(0).children.add(new Node(null,false,null,null));
        tree.root.children.get(0).children.add(new Node(null,false,null,null));
        tree.root.children.get(1).children.add(new Node(null,false,null,null));
        tree.root.children.get(1).children.add(new Node(null,false,null,null));
        tree.root.children.get(2).children.add(new Node(null,false,null,null));
        tree.root.children.get(2).children.add(new Node(null,false,null,null));

        tree.root.children.get(0).children.get(0).children.add(child47);
        tree.root.children.get(0).children.get(0).children.add(child34);
        tree.root.children.get(0).children.get(1).children.add(child22);
        tree.root.children.get(0).children.get(2).children.add(child13);

        tree.root.children.get(1).children.get(0).children.add(child3);
        tree.root.children.get(1).children.get(1).children.add(child12);
        tree.root.children.get(1).children.get(1).children.add(child25);

        tree.root.children.get(2).children.get(0).children.add(child31);
        tree.root.children.get(2).children.get(1).children.add(child32);
        tree.root.children.get(2).children.get(1).children.add(child44);
        Assertions.assertEquals(13, PruningHelper.alphaBetaPrune(tree.root, -1000, 1000));
    }

}
