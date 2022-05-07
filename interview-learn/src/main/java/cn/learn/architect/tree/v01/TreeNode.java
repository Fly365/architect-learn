package cn.learn.architect.tree.v01;

import java.util.Objects;

/**
 * @author Fly365
 * @date 2022-03-24
 */
public class TreeNode {

    private String id;
    private String pId;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return Objects.equals(id, treeNode.id) && Objects.equals(pId, treeNode.pId) && Objects.equals(name, treeNode.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pId, name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id='" + id + '\'' +
                ", pId='" + pId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
