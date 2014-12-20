package recursion

import spock.lang.Specification

/**
 * @author Remus Amalinei http://remus-amalinei.blogspot.com
 */
class PermutationsTest extends Specification {

    void 'should generate all permutations'() {
        given:
        Integer n = 5
        Integer nFactorial = 120

        when:
        List<List<Integer>> permutationList = new Permutations().generate(n)

        then:

        containsDistinctListsOfSize(permutationList, nFactorial, n)
    }

    static boolean containsDistinctListsOfSize(List<List<Integer>> listOfLists, Integer listOfListsCount, Integer listSize) {
        Set<List<Integer>> set = (listOfLists as Set<List<Integer>>)

        if (set.size() != listOfListsCount) {
            return false
        }

        for (list in listOfLists) {
            if (list.size() != listSize) {
                return false
            }
        }

        true
    }
}
