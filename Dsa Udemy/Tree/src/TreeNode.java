import java.util.ArrayList;

public class TreeNode {
    String value;
    ArrayList<TreeNode> children;

    public TreeNode(String value){
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode node){
        this.children.add(node);
    }

    public String print(int level){
        StringBuilder ref;
        ref = new StringBuilder("  ".repeat(level) + value + "\n");
        for(TreeNode node: this.children)
            ref.append(node.print(level + 1));

        return ref.toString();
    }

}
