package com.alexonepath.util;

import com.alexonepath.MercleTree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {
    public static void displayPrettyTree(MercleTree mercleTree) {
        for (int i = 0; i < 50; i++) {
            System.out.print("=");
        }
        System.out.println();

        int rootKeySize = mercleTree.getRoot().getKey().toString().length();
        int defaultSpaceSize = rootKeySize < 3 ? 3 : rootKeySize;
        int height = getMaxHeight(mercleTree.getRoot(), null) - 1;
        int spaceTotal = defaultSpaceSize * (int) Math.pow(2, height) - 1;
        int interval = 0;

        Queue<MercleTree.Node> queue = new LinkedList<>();
        queue.offer(mercleTree.getRoot());

        for (int i = 0; i <= height; i++) {
            int parentSpace = (int) ((Math.pow(2, (height - i))) - 1) * defaultSpaceSize;
            int nodeCntInHeight = (int) (Math.pow(2, i));
            if (i > 0) {
//                interval = (spaceTotal - parentSpace * 2 - nodeCntInHeight) / (nodeCntInHeight - 1) + (height * 2);
                interval = ((parentSpace * 2) / 2) + 1;
            }

            for (int j = 0; j < nodeCntInHeight; j++) {
                MercleTree.Node peek = queue.poll();

                if (i == 0 && j == 0) {
                    print(parentSpace, height, peek);
                } else {
                    print(interval + i, height, peek);
                }

                if (peek == null) {
                    queue.offer(null);
                    queue.offer(null);
                } else {
                    queue.offer(peek.getLeft());
                    queue.offer(peek.getRight());
                }
            }

            System.out.println();
        }
    }

    private static void print(int count, int height, MercleTree.Node root) {
        for (int i = 0; i < count * height; i++) {
            System.out.print(" ");
        }

        if (root != null) {
            for (int j = 0; j < height - root.getKey().toString().length(); j++) {
                System.out.print(" ");
            }

            System.out.print(String.format("%s", root.getKey()));
        } else {
            for (int j = 0; j < height; j++) {
                System.out.print(" ");
            }
        }
    }

    public static int getMaxHeight(MercleTree.Node node, int[] size) {
        if (node == null) {
            return 0;
        }
        if (size == null) {
            size = new int[]{1};
        }

        return Math.max(getMaxHeight(node.getLeft(), size), getMaxHeight(node.getRight(), size)) + 1;
    }
}
