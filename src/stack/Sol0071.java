package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Sol0071 {

    static public String simplifyPath(String path) {
        String[] folderNames = path.split("/+");
        Deque<String> folderNameDequeue = new ArrayDeque<>();

        for (String name : folderNames) {
            switch (name) {
                case "":
                case ".":
                    break;
                case "..":
                    if (!folderNameDequeue.isEmpty()) {
                        folderNameDequeue.removeFirst();
                    }
                    break;
                default:
                    folderNameDequeue.addFirst(name);
                    break;
            }
        }
        if (folderNameDequeue.isEmpty()) {
            return "/";
        }

        StringBuilder res = new StringBuilder();
        while (!folderNameDequeue.isEmpty()) {
            res.append('/');
            res.append(folderNameDequeue.removeLast());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
        System.out.println(simplifyPath("/a//b////c/d//././/.."));

    }
}