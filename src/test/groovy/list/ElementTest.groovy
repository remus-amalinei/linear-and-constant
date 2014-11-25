package list

import spock.lang.Specification

/**
 * @author Remus Amalinei http://remus-amalinei.blogspot.com
 */
class ElementTest extends Specification {

    void 'next should be considered by equals'() {
        expect:
        list1 == list2

        where:
        list1                                              | list2
        null                                               | null
        new Element(value: 1)                              | new Element(value: 1)
        new Element(value: 2, next: new Element(value: 3)) | new Element(value: 2, next: new Element(value: 3))
    }
}
