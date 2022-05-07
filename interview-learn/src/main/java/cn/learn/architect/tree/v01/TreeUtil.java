package cn.learn.architect.tree.v01;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Fly365
 * @date 2022-03-24
 */
public class TreeUtil {

    public static Map<String,Object> mapArray = new LinkedHashMap<String, Object>();
    public List<TreeNode> menuCommon;
    public List<Object> list = new ArrayList<Object>();

    public List<Object> menuList(List<TreeNode> menu){
        this.menuCommon = menu;
        for (TreeNode x : menu) {
            Map<String,Object> mapArr = new LinkedHashMap<String, Object>();
            if(x.getpId()=="0"){
                mapArr.put("id", x.getId());
                mapArr.put("name", x.getName());
                mapArr.put("pid", x.getpId());
                mapArr.put("childList", menuChild(x.getId()));
                list.add(mapArr);
            }
        }
        return list;
    }

    public List<?> menuChild(String id){
        List<Object> lists = new ArrayList<Object>();
        for(TreeNode a:menuCommon){
            Map<String,Object> childArray = new LinkedHashMap<String, Object>();
            if(a.getpId() == id){
                childArray.put("id", a.getId());
                childArray.put("name", a.getName());
                childArray.put("pid", a.getpId());
                childArray.put("childList", menuChild(a.getId()));
                lists.add(childArray);
            }
        }
        return lists;
    }

}
