package list

/**
 * @author Remus Amalinei http://remus-amalinei.blogspot.com
 */
class CycleHandler {

    /**
     * Returns the length of the cycle or 0 is there is no cycle.
     */
    static <T> Integer calculateCycleLength(Element<T> head) {
        if ( ! head) {
            throw new IllegalArgumentException('the list cannot be null')
        }

        Element<T> oneStepPointer = head
        Element<T> twoStepsPointer = head?.next?.next

        while ( ! oneStepPointer.is(twoStepsPointer) && twoStepsPointer) {
            oneStepPointer = oneStepPointer.next
            twoStepsPointer = twoStepsPointer?.next?.next
        }

        if (oneStepPointer.is(twoStepsPointer)) {
            cycleLength(oneStepPointer)
        } else {
            0
        }
    }

    private static <T> Integer cycleLength(Element<T> startingAt) {
        Element<T> oneStepPointer = startingAt.next
        Integer length = 1

        while ( ! oneStepPointer.is(startingAt)) {
            length++
            oneStepPointer = oneStepPointer.next
        }

        length
    }
}
