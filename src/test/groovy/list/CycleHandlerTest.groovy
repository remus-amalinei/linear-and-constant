package list

import spock.lang.Specification

import static list.CycleHandler.calculateCycleLength

/**
 * @author Remus Amalinei http://remus-amalinei.blogspot.com
 */
class CycleHandlerTest extends Specification {

    void 'should calculate the length of the cycle'() {
        given:
        Element<Integer> listWithACycleOfLength3 = buildListWithACycleOfLength3()

        when:
        Integer cycleLength = calculateCycleLength(listWithACycleOfLength3)

        then:
        cycleLength == 3
    }

    void 'should calculate the length of the cycle when is of length 1 starting at head'() {
        given:
        Element<Integer> listWithACycleOfLength1StartingAtHead = new Element<>(value: 1)
        listWithACycleOfLength1StartingAtHead.next = listWithACycleOfLength1StartingAtHead

        when:
        Integer cycleLength = calculateCycleLength(listWithACycleOfLength1StartingAtHead)

        then:
        cycleLength == 1
    }

    void 'should return 0 for a list with no cycles'() {
        given:
        Element<Integer> head = new Element(
                value: 1,
                next: new Element<Integer>(
                        value: 2,
                        next: new Element(
                                value: 3,
                                next: new Element(
                                        value: 4))))

        when:
        Integer cycleLength = calculateCycleLength(head)

        then:
        cycleLength == 0
    }

    void 'should throw an IllegalArgumentException when the list to calculate cycle length for is null'() {
        when:
        calculateCycleLength(null)

        then:
        thrown(IllegalArgumentException)
    }

    private Element<Integer> buildListWithACycleOfLength3() {
        // 1 -> 2 -> 3 -> 4
        //      \ <-<-<- /

        Element<Integer> head = new Element(value: 1)
        Element<Integer> element2 = new Element(value: 2)
        Element<Integer> element3 = new Element(value: 3)
        Element<Integer> element4 = new Element(value: 4)

        head.next = element2
        element2.next = element3
        element3.next = element4
        element4.next = element2

        head
    }
}
