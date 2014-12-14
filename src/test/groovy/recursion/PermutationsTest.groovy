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
        containsNFactorialDistinctLists(permutationList, n, nFactorial)
    }

    private boolean containsNFactorialDistinctLists(List<List<Integer>> permutationList, Integer n, Integer nFactorial) {
        Set<List<Integer>> set = (permutationList as Set<List<Integer>>)

        if (set.size() != nFactorial) {
            return false
        }

        for (permutation in permutationList) {
            if (permutation.size() != n) {
                return false
            }
        }

        true
    }
}
