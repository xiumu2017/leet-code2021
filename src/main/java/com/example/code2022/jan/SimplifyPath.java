package com.example.code2022.jan;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 2022-01-06
 */
@Slf4j
class SimplifyPath {
    public static void main(String[] args) {
//        String s = "/a/.////b/../../c";
//        String s = "/home//foo/";
        String s = "/a//b////c/d//././/..";
        String s1 = new SimplifyPath().simplifyPath2(s);
        log.info("s1 = " + s1);
    }

    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        deque.push("/");
        String temp = "";
        List<String> list = new ArrayList<>();
        if (!path.endsWith("/")) {
            path = path + "/";
        }
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                if (!"".equals(temp)) {
                    list.add("/" + temp);
                }
                temp = "";
            } else {
                temp += path.charAt(i);
            }
        }
        for (String s : list) {
            if ("/..".equals(s) && deque.size() > 1) {
                deque.pop();
            } else if (!"/.".equals(s) && !"/..".equals(s)) {
                deque.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.insert(0, deque.poll());
        }
        return sb.toString();
    }

    public String simplifyPath2(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offerLast(name);
            }
        }
        StringBuilder ans = new StringBuilder();
        if (stack.isEmpty()) {
            ans.append('/');
        } else {
            while (!stack.isEmpty()) {
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/simplify-path/solution/jian-hua-lu-jing-by-leetcode-solution-aucq/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}