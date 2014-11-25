package list

/**
 * @author Remus Amalinei http://remus-amalinei.blogspot.com
 */
class ReverseList {

    Element reverseRecursively(Element head) {
        if (!head || !head.next) {
            return head
        }

        Element secondElement = head.next
        head.next = null

        Element secondElementReversed = reverseRecursively(secondElement)
        secondElement.next = head

        secondElementReversed
    }
}
