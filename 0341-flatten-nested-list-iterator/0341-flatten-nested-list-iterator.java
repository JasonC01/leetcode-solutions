public class NestedIterator implements Iterator<Integer> {
        List<NestedInteger> nestedList;
        int index = 0;
        NestedIterator nestedIterator;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.nestedList = nestedList;
            // nestedIterator = nestedList.size() > 0 && !nestedList.get(0).isInteger() ? new NestedIterator(nestedList.get(0).getList()) : null;
        }

        @Override
        public Integer next() {
            if (nestedList.get(index).isInteger()) {
                return nestedList.get(index++).getInteger();
            } else {
                // if (nestedIterator == null) {
                //     nestedIterator = new NestedIterator(nestedList.get(index).getList());
                // }
                if (nestedIterator.hasNext()) {
                    return nestedIterator.next();
                } else {
                    index++;
                    nestedIterator = null;
                    return this.next();
                }
            }
        }

        @Override
        public boolean hasNext() {
            if (index > nestedList.size() - 1) {
                return false;
            } else {
                if (nestedList.get(index).isInteger()) {
                    return true;
                } else {
                    //is list
                    if (nestedIterator == null) {
                        nestedIterator = new NestedIterator(nestedList.get(index).getList());
                        return this.hasNext();
                    } else {
                        if (nestedIterator.hasNext()) {
                            return true;
                        } else {
                            index++;
                            nestedIterator = null;
                            return this.hasNext();
                        }
                    }
                }
            }
        }
    }