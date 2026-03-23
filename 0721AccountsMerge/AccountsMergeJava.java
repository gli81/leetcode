

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class AccountsMergeJava {
    public List<List<String>> accountsMerge(
        List<List<String>> accounts
    ) {
        Map<String, List<Integer>> belongs = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String key = accounts.get(i).get(j);
                List<Integer> cur = belongs.getOrDefault(
                    key, new ArrayList<Integer>()
                );
                cur.add(i);
                belongs.put(key, cur);
            }
        }
        // System.out.println(belongs);
        Set<String> visited_email = new HashSet<>();
        Set<Integer> visited_id = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            if (!visited_id.contains(i)) {
                ans.add(new ArrayList<String>(
                    Arrays.asList(new String[]{
                        accounts.get(i).get(0)
                    })
                ));
            }
            dfs(
                i, belongs,accounts,
                visited_email, visited_id, ans
            );
        }
        // System.out.println(ans);
        // List<List<String>> ans2 = new ArrayList<>();
        for (int i = 0; i < ans.size(); i++) {

            Collections.sort(
                ans.get(i).subList(
                    1, ans.get(i).size()
                )
            );
            // Collections.sort(ans.get(i).subList(1, ans.get))
        }
        return ans;
    }

    private void dfs(
        int id,
        Map<String, List<Integer>> belongs,
        List<List<String>> accounts,
        Set<String> visited_email,
        Set<Integer> visited_id,
        List<List<String>> ans
    ) {
        if (visited_id.contains(id)) return;
        visited_id.add(id);
        for (int j = 1; j < accounts.get(id).size(); j++) {
            String key = accounts.get(id).get(j);
            if (visited_email.contains(key)) continue;
            visited_email.add(key);
            ans.get(ans.size() - 1).add(key);
            for (int linked : belongs.get(key)) {
                dfs(
                    linked, belongs, accounts,
                    visited_email, visited_id, ans    
                );
            }
        }
    }


    public static void main(String[] args) {
        AccountsMergeJava test =
            new AccountsMergeJava();
        List<List<String>> test1 = new ArrayList<>();
        test1.add(Arrays.asList(
            new String[]{
                "Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co"
            }
        ));
        test1.add(Arrays.asList(
            new String[]{
                "Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co"
            }
        ));
        test1.add(Arrays.asList(
            new String[]{
                "Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co"
            }
        ));
        test1.add(Arrays.asList(
            new String[]{
                "Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co"
            }
        ));
        test1.add(Arrays.asList(
            new String[]{
                "Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co"
            }
        ));
        System.out.println(test.accountsMerge(
            test1
        ));
        List<List<String>> test2 = new ArrayList<>();
        test2.add(Arrays.asList(
            new String[]{
                "John", "johnsmith@mail.com", "john00@mail.com"
            }
        ));
        test2.add(Arrays.asList(
            new String[]{
                "John", "johnnybravo@mail.com"
            }
        ));
        test2.add(Arrays.asList(
            new String[]{
                "John", "johnsmith@mail.com", "john_newyork@mail.com"
            }
        ));
        test2.add(Arrays.asList(
            new String[]{
                "Mary", "mary@mail.com"
            }
        ));
        System.out.println(test.accountsMerge(
            test2
        ));
    }
}
