

import java.util.ArrayList;

public class SimplifyPathJava {
    public String simplifyPath(String path) {
        String[] lst1 = path.split("/");
        ArrayList<String> lst2 = new ArrayList<>();
        for (int i = 0; i < lst1.length; i++) {
            if (!(lst1[i].equals(".")
                || lst1[i].equals(""))) {
                lst2.add(lst1[i]);
            }
        }
        // deal with ..
        ArrayList<String> lst3 = new ArrayList<>();
        for (int i = 0; i < lst2.size(); i++) {
            if (lst2.get(i).equals("..")) {
                if (!lst3.isEmpty()) {
                    lst3.remove(lst3.size() - 1);
                }
            } else {
                lst3.add(lst2.get(i));
            }
        }
        return "/" + String.join("/", lst3);
    }

    public static void main(String[] args) {
        SimplifyPathJava test = new SimplifyPathJava();
        System.out.println(test.simplifyPath("/home/"));    
        System.out.println(test.simplifyPath("/../"));    
        System.out.println(
            test.simplifyPath("/a/./b/../../c/")
        );    
        System.out.println(
            test.simplifyPath("/a//b////c/d//././/..")
        );
    }    
}