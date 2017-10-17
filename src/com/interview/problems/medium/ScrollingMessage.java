package com.interview.problems.medium;

import java.util.Deque;
import java.util.LinkedList;

public class ScrollingMessage {

    /**
     *
     * Scrolling banner, typical data structure management problem which receives a message, an offset,
     * and a direction (boolean) with which move the message the determined amount of offset to the required
     * direction.
     *
     * Ej: Message, 3, false (right)
     * Result: ageMess
     *
     * @param sMessage - String to be moved.
     * @param iOffset - Number of spaces each character moves.
     * @param bDirection - Direction of movement.
     */

    private static void scrollingMessageSolution(String sMessage, int iOffset, boolean bDirection){
        Object temporalStorage;
        Deque doubleQueue = new LinkedList();

        for (int iCharIndex = 0; iCharIndex < sMessage.length(); iCharIndex++){
            doubleQueue.add(sMessage.charAt(iCharIndex));
        }


        if (bDirection) {
            for (int iOffsetCount = 0; iOffsetCount < iOffset; iOffsetCount++) {
                temporalStorage = doubleQueue.removeFirst();
                doubleQueue.addLast(temporalStorage);
            }
        }
        else {
            for (int iOffsetCount = 0; iOffsetCount < iOffset; iOffsetCount++) {
                temporalStorage = doubleQueue.removeLast();
                doubleQueue.addFirst(temporalStorage);
            }
        }

    }

    public static void main(String[] args) {
        scrollingMessageSolution("Message", 3, false);
    }
}
