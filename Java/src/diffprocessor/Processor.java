package diffprocessor;

/**
 * Created by VavilauA on 6/19/2015.
 */
public class Processor {
    public Processor(long limit) {
        // TODO: initialize.
        // in my implementation there is no need to store limit
    }

    public void doProcess(SortedLimitedList<Double> mustBeEqualTo, SortedLimitedList<Double> expectedOutput) throws Exception {
        var firstListIterator = mustBeEqualTo.getFirst();
        var secondListIterator = expectedOutput.getFirst();

        while (firstListIterator != null) {
            while (secondListIterator != null && secondListIterator.getValue().compareTo(firstListIterator.getValue()) < 0) {
                secondListIterator = secondListIterator.getNext();
            }
            var oldIterator = firstListIterator;
            firstListIterator = firstListIterator.getNext();
            if (secondListIterator == null || !secondListIterator.getValue().equals(oldIterator.getValue())) {
                mustBeEqualTo.remove(oldIterator);
            } else {
                secondListIterator = secondListIterator.getNext();
            }
        }

        firstListIterator = mustBeEqualTo.getFirst();
        secondListIterator = expectedOutput.getFirst();
        while (secondListIterator != null) {
            if (firstListIterator != null && secondListIterator.getValue().compareTo(firstListIterator.getValue()) < 0) {
                mustBeEqualTo.addBefore(firstListIterator, secondListIterator.getValue());
                secondListIterator = secondListIterator.getNext();
                continue;
            }
            if (firstListIterator != null) {
                firstListIterator = firstListIterator.getNext();
                secondListIterator = secondListIterator.getNext();
            } else {
                mustBeEqualTo.addLast(secondListIterator.getValue());
                secondListIterator = secondListIterator.getNext();
            }
        }

        // TODO: make "mustBeEqualTo" list equal to "expectedOutput".
        // 0. Processor will be created once and then will be used billion times.
        // 1. Use methods: AddFirst, AddLast, AddBefore, AddAfter, Remove to modify list.
        // 2. Do not change expectedOutput list.
        // 3. At any time number of elements in list could not exceed the "Limit".
        // 4. "Limit" will be passed into Processor's constructor. All "mustBeEqualTo" and "expectedOutput" lists will have the same "Limit" value.
        // 5. At any time list elements must be in non-descending order.
        // 6. Implementation must perform minimal possible number of actions (AddFirst, AddLast, AddBefore, AddAfter, Remove).
        // 7. Implementation must be fast and do not allocate excess memory.
    }
}
