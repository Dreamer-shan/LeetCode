//package 序列化二叉树37;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
///**
// * @author Shan
// * @Description
// * @create 2021-01-28 21:55
// */
//
//
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}
//
////public class Codec {
////
////    // Encodes a tree to a single string.
////    public String serialize(TreeNode root) {
////        if (root == null)   return "[]";
////        StringBuffer res = new StringBuffer("[");
////        Queue<TreeNode> queue = new LinkedList<>();
////        queue.offer(root);
////        while (!queue.isEmpty()){
////            TreeNode node = queue.poll();
////            if (node != null){
////                res.append(node.val + ",");
////                // null 也可以加到 queue 里面
////                queue.offer(node.left);
////                queue.offer(node.right);
////            }else {
////                res.append("null,");
////            }
////        }
////        // 删除逗号
////        res.deleteCharAt(res.length() - 1);
////        res.append("]");
////        return res.toString();
////    }
////
////    // Decodes your encoded data to tree.
////    public TreeNode deserialize(String data) {
////        if (data.equals("[]"))  return null;
////        // substring是左闭右开 data[0] 是字符 "[", 所以从1开始 data.length() - 1 是字符"]"
////        String[] vals = data.substring(1, data.length() - 1).split(",");
////        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
////        Queue<TreeNode> queue = new LinkedList<>();
////        queue.offer(root);
////        int i = 1;
////        while (!queue.isEmpty()){
////            TreeNode node = queue.poll();
////            if (!vals[i].equals("null")){
////                node.left = new TreeNode(Integer.parseInt(vals[i]));
////                queue.offer(node.left);
////            }
////            i++;
////            if (!vals[i].equals("null")){
////                node.right = new TreeNode(Integer.parseInt(vals[i]));
////                queue.offer(node.right);
////            }
////            i++;
////        }
////        return root;
////    }
////}
//
//public class Codec {
//
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        if (root == null)   return "[]";
//        StringBuilder res = new StringBuilder("[");
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()){
//            TreeNode node = queue.poll();
//            if (node != null){
//                res.append(node.val + ",");
//                queue.offer(node.left);
//                queue.offer(node.right);
//            }else {
//                res.append("null,");
//            }
//        }
//        res.deleteCharAt(res.length() - 1);
//        res.append("]");
//        return res.toString();
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        if (data.equals("[]"))  return null;
//        String[] vals = data.substring(1, data.length() - 1).split(",");
//        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int i = 1;
//        while (!queue.isEmpty()){
//            TreeNode node = queue.poll();
//            if (!vals[i].equals("null")){
//                node.left = new TreeNode(Integer.parseInt(vals[i]));
//                queue.offer(node.left);
//            }
//            // 加在外面，不然遇到null的时候i
//            i++;
//            if (!vals[i].equals("null")){
//                node.right = new TreeNode(Integer.parseInt(vals[i]));
//                queue.offer(node.right);
//            }
//            i++;
//        }
//        return root;
//
//    }
//}